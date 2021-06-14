// Native methods implementation of
// F:/FinalAssignment/SecRobotApp/src/secrobotapp/AIImplementationA.java

#include <math.h>
#include <stdlib.h>

#include "AIImplementationA.h"

void JNICALL Java_AIImplementationA_RunImplementationA
  (JNIEnv * env, jobject object, jobject param1) 
{
    printf("Starting");
    
    //Accessing methods in Robot Control Class
    jclass RobotControlClass = (*env)->GetObjectClass(env, param1);
    jmethodID getRobot = (*env)->GetMethodID(env, RobotControlClass, "getRobot", "()LRobotInfo;");
    jmethodID getallRobots = (*env)->GetMethodID(env, RobotControlClass, "getAllRobots", "()[LRobotInfo;");
    
    jmethodID movenorth = (*env)->GetMethodID(env,RobotControlClass,"moveNorth","()Z");
    jmethodID moveeast = (*env)->GetMethodID(env,RobotControlClass,"moveEast","()Z");
    jmethodID movesouth = (*env)->GetMethodID(env,RobotControlClass,"moveNorth","()Z");
    jmethodID movewest = (*env)->GetMethodID(env,RobotControlClass,"moveNorth","()Z");
    jmethodID isfire = (*env)->GetMethodID(env,RobotControlClass,"fire","(II)Z");
    
    jmethodID drawln1 = (*env)->GetMethodID(env,RobotControlClass,"drawline1","(IIII)V");
    jmethodID drawln2 = (*env)->GetMethodID(env,RobotControlClass,"drawline2","(IIII)V");
    jmethodID drawln3 = (*env)->GetMethodID(env,RobotControlClass,"drawline3","(IIII)V");
    jmethodID sethelt = (*env)->GetMethodID(env,RobotControlClass,"sethealt","(DII)V");
    jmethodID upar = (*env)->GetMethodID(env,RobotControlClass,"updatear","()V");
    jmethodID displaywinner = (*env)->GetMethodID(env,RobotControlClass,"DisplayWinnner","(Ljava/lang/String;)V");
    
    //Accessing get robot object in robot control class
    jobject robotObject = (*env)->CallObjectMethod(env,param1,getRobot);
    
    //Accessing getAllrobots method in robot control class
    jobjectArray robotarray = (*env)->CallObjectMethod(env,param1,getallRobots);
    (*env)->GetObjectArrayElement(env,robotarray,0);
    
    //Variable declaration of RobotInfo Class
    jclass RobotInfoClass = (*env)->GetObjectClass(env, robotObject);
    
    //Method declarations in RobotInfo Class
    jmethodID getName = (*env)->GetMethodID(env, RobotInfoClass, "getname", "()Ljava/lang/String;");
    jmethodID getX = (*env)->GetMethodID(env, RobotInfoClass, "getx", "()I");
    jmethodID getY = (*env)->GetMethodID(env, RobotInfoClass, "gety", "()I");
    jmethodID gethealth = (*env)->GetMethodID(env,RobotInfoClass, "gethealth" , "()D");
    jmethodID sethealth = (*env)->GetMethodID(env,RobotInfoClass, "sethealth" , "(D)V");
    
    
    //Variable declaration of Queue and Robot Count
    int capacity = 6;
    int count = 3;
    
    char* direction = "north";
    
    
    while(1)
    {
        //Checks the robot count, if it is equals to 1, Jump to else condition and display the winner
        if((count==3)&&(count>1))
        {
            //Iterate for three times to manipulate three robots
            for(int i=0; i<3; i++)
            {
                jobject enemyobject = (*env)->GetObjectArrayElement(env,robotarray,i);
                
                jstring rob1 = (*env)->CallObjectMethod(env,robotObject,getName);
                char* robp1 =(char*) (*env)->GetStringUTFChars(env,rob1,NULL);
                
                jstring rob2 = (*env)->CallObjectMethod(env,enemyobject,getName);
                char* robp2 =(char*) (*env)->GetStringUTFChars(env,rob2,NULL);
                
                
                //Checks if myrobot object and enemy robot objects are the same object
                if(strcmp(robp1,robp2)< 0||strcmp(robp1,robp2)>0)
                {
                    printf("Name check\n");
                    int myx = (*env)->CallIntMethod(env,robotObject,getX);
                    int myy = (*env)->CallIntMethod(env,robotObject,getY);
                    int enemyx = (*env)->CallIntMethod(env,enemyobject,getX);
                    int enemyy = (*env)->CallIntMethod(env,enemyobject,getY);
                    
                    //Checks the enemy robot is standing in two block radius
                    if((abs(myx-enemyx)<=2)&&(abs(myy-enemyy)<=2))
                    {
                        printf("Location check\n");
                        printf("Robot that shoot %s\n",(*env)->GetStringUTFChars(env,(*env)->CallObjectMethod(env,robotObject,getName),NULL));
                        printf("Robot that get hit %s \n",(*env)->GetStringUTFChars(env,(*env)->CallObjectMethod(env,(*env)->GetObjectArrayElement(env,robotarray,i),getName),NULL));
                        usleep(5000);
                        double health;
                        
                        jboolean fire = (*env)->CallBooleanMethod(env,enemyobject,isfire,(int)enemyx,(int)enemyy);
                        
                        if(fire)    //Checks the enemy is available for firing
                        {
                            printf("Fire check\n");
                            if(strcmp(robp1,(char*) (*env)->GetStringUTFChars(env,(*env)->CallObjectMethod(env,(*env)->GetObjectArrayElement(env,robotarray,0),getName),NULL))== 0)
                            {
                                //Checks whether the Robot 1 is shooting and proceed for shooting
                                printf("Shoot check\n");
                                health = (double) (*env)->CallDoubleMethod(env,enemyobject,gethealth);
                                
                                //Checks if the enemy robot s health is between 100 and 30
                                if((health<=100)&&(health>30))
                                {
                                    (*env)->CallVoidMethod(env,param1,drawln1,myx,myy,enemyx,enemyy);
                                    (*env)->CallVoidMethod(env,enemyobject,sethealth,health-35);
                                    usleep(2500);
                                }
                                else if(health==30)
                                {
                                    //Checks the enemy robot s health is equals to 30
                                    (*env)->CallVoidMethod(env,param1,drawln1,myx,myy,enemyx,enemyy);
                                    (*env)->CallVoidMethod(env,enemyobject,sethealth,health-30);
                                    usleep(2500);
                                    count = count-1;
                                }
                            }
                            else if(strcmp(robp1,(char*) (*env)->GetStringUTFChars(env,(*env)->CallObjectMethod(env,(*env)->GetObjectArrayElement(env,robotarray,1),getName),NULL))== 0)
                            {
                                //Checks whether the Robot 2 is shooting and proceed for shooting
                                health = (double) (*env)->CallDoubleMethod(env,enemyobject,gethealth);
                                
                                //Checks if the enemy robot s health is between 100 and 30
                                if((health<=100)&&(health>30))
                                {
                                    (*env)->CallVoidMethod(env,param1,drawln2,myx,myy,enemyx,enemyy);
                                    (*env)->CallVoidMethod(env,enemyobject,sethealth,health-35);
                                    usleep(2500);
                                }
                                else if(health==30)
                                {
                                    //Checks the enemy robot s health is equals to 30
                                    (*env)->CallVoidMethod(env,param1,drawln2,myx,myy,enemyx,enemyy);
                                    (*env)->CallVoidMethod(env,enemyobject,sethealth,health-30);
                                    usleep(2500);
                                    count = count-1;
                                }
                            }
                            else if(strcmp(robp1,(char*) (*env)->GetStringUTFChars(env,(*env)->CallObjectMethod(env,(*env)->GetObjectArrayElement(env,robotarray,2),getName),NULL))== 0)
                            {
                                //Checks whether the Robot 3 is shooting and proceed for shooting
                                health = (double) (*env)->CallDoubleMethod(env,enemyobject,gethealth);
                                
                                //Checks if the enemy robot s health is between 100 and 30
                                if((health<=100)&&(health>30))
                                {
                                    (*env)->CallVoidMethod(env,param1,drawln3,myx,myy,enemyx,enemyy);
                                    (*env)->CallVoidMethod(env,enemyobject,sethealth,health-35);
                                    usleep(2500);
                                }
                                else if(health==30)
                                {
                                    //Checks the enemy robot s health is equals to 30
                                    (*env)->CallVoidMethod(env,param1,drawln3,myx,myy,enemyx,enemyy);
                                    (*env)->CallVoidMethod(env,enemyobject,sethealth,health-30);
                                    usleep(2500);
                                    count = count-1;
                                }
                            }
                        }
                    }
                }
            }
      }
        else
        {   //Check whether the Robot 3 has won. if it has won, Display a message box saying Robot 3 has won
            if(((*env)->CallDoubleMethod(env,(*env)->GetObjectArrayElement(env,robotarray,0),gethealth)==0)&&((*env)->CallDoubleMethod(env,(*env)->GetObjectArrayElement(env,robotarray,1),gethealth)==0))
            {
                printf("End of the program\n");
                jobject winnerobject = (*env)->GetObjectArrayElement(env,robotarray,2);
                jstring winnername = (*env)->CallObjectMethod(env,winnerobject,getName);
                (*env)->CallVoidMethod(env,param1,displaywinner,winnername);
                exit(0);
            }
            else if(((*env)->CallDoubleMethod(env,(*env)->GetObjectArrayElement(env,robotarray,1),gethealth)==0)&&((*env)->CallDoubleMethod(env,(*env)->GetObjectArrayElement(env,robotarray,2),gethealth)==0))
            {   //Check whether the Robot 0 has won. if it has won, Display a message box saying Robot 0 has won
                printf("End of the program\n");
                jobject winnerobject = (*env)->GetObjectArrayElement(env,robotarray,0);
                jstring winnername = (*env)->CallObjectMethod(env,winnerobject,getName);
                (*env)->CallVoidMethod(env,param1,displaywinner,winnername);
                exit(0);
            }
            else if(((*env)->CallDoubleMethod(env,(*env)->GetObjectArrayElement(env,robotarray,0),gethealth)==0)&&((*env)->CallDoubleMethod(env,(*env)->GetObjectArrayElement(env,robotarray,2),gethealth)==0))
            {   //Check whether the Robot 1 has won. if it has won, Display a message box saying Robot 1 has won
                printf("End of the program\n");
                jobject winnerobject = (*env)->GetObjectArrayElement(env,robotarray,1);
                jstring winnername = (*env)->CallObjectMethod(env,winnerobject,getName);
                (*env)->CallVoidMethod(env,param1,displaywinner,winnername);
                exit(0);
            }
        }
        
        if(strcmp(direction,"north")==0)
        {
            if(!(*env)->CallBooleanMethod(env,param1,movenorth)){direction = "east";}
            (*env)->CallVoidMethod(env,param1,upar);
            usleep(100000);
        }
        else if(strcmp(direction,"east")==0)
        {
            if(!(*env)->CallBooleanMethod(env,param1,moveeast)){direction = "south";}
            (*env)->CallVoidMethod(env,param1,upar);
            usleep(100000);

        }
        else if(strcmp(direction,"south")==0)
        {
            if(!(*env)->CallBooleanMethod(env,param1,movesouth)){direction = "west";}
            (*env)->CallVoidMethod(env,param1,upar);
            usleep(100000);
        }
        else if(strcmp(direction,"west")==0)
        {
            if(!(*env)->CallBooleanMethod(env,param1,movewest)){direction = "north";}
            (*env)->CallVoidMethod(env,param1,upar);
            usleep(100000);
        }
        
    }
        
    
    
}

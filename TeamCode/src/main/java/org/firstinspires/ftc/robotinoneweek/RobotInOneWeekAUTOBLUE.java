package org.firstinspires.ftc.robotinoneweek;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name="RobotInOneWeekAUTOBLUE", group="FTC")
public class RobotInOneWeekAUTOBLUE extends LinearOpMode implements RobotVariables{
    AutonomousVoids autonomousvoids = new AutonomousVoids();
    @Override
    public void runOpMode() throws InterruptedException  {

        waitOneFullHardwareCycle();
        waitForStart();

        //autonomousvoids.Forward(1,1);
        autonomousvoids.Jewels("blue");


    }
}

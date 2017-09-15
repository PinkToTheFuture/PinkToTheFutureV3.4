package org.firstinspires.ftc.robotinoneweek;


import com.qualcomm.ftccommon.Restarter;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous(name="RobotInOneWeekAUTORED", group="FTC")
public class RobotInOneWeekAUTORED extends LinearOpMode implements RobotVariables{
    AutonomousVoids autonomousvoids = new AutonomousVoids();
    @Override
    public void runOpMode() throws InterruptedException  {

        waitOneFullHardwareCycle();
        waitForStart();

        //autonomousvoids.Forward(1,1);
        autonomousvoids.Jewels("red");


    }
}

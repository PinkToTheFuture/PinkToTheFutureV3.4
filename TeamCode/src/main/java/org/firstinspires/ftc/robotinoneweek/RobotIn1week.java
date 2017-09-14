package org.firstinspires.ftc.robotinoneweek;


import com.qualcomm.ftccommon.Restarter;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="RobotInOneWeek", group="FTC")
public class RobotIn1week extends LinearOpMode implements RobotVariables{

    @Override
    public void runOpMode() throws InterruptedException  {
        RobotComponents robotcomponents = new RobotComponents();
        double ArmPos = 0;
        double Rpower;
        double Lpower;
        double GlyphgrabLPos = 0;
        double GlyphgrabRPos = 1;

        double fastency = 1;
        


        robotcomponents.Arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        robotcomponents.Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robotcomponents.Arm.setPower(1);
        
        robotcomponents.LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        robotcomponents.LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        robotcomponents.RelicSlideOpenerR.setPosition(RelicSlideRServoMIN);
        robotcomponents.RelicSlideOpenerL.setPosition(RelicSlideLServoMAX);
        


        waitOneFullHardwareCycle();
        waitForStart();
        while (opModeIsActive()) {
            waitOneFullHardwareCycle();
            if (gamepad1.dpad_up)     fastency = 1;
            if (gamepad1.dpad_down)   fastency = 0.2;
            if (gamepad1.dpad_right)  fastency = 0.4;

            if (gamepad2.a) {
                GlyphgrabLPos += 0.01;
                GlyphgrabRPos -= 0.01;
            }
            if (gamepad2.b) {
                GlyphgrabLPos -= 0.01;
                GlyphgrabRPos += 0.01;
            }

            if (gamepad2.x){
                robotcomponents.RelicSlideOpenerR.setPosition(RelicSlideRServoMAX);
                robotcomponents.RelicSlideOpenerL.setPosition(RelicSlideLServoMIN);
            }
            if (gamepad2.y){
                robotcomponents.RelicSlideOpenerR.setPosition(RelicSlideRServoMIN);
                robotcomponents.RelicSlideOpenerL.setPosition(RelicSlideLServoMAX);
            }

            Lpower = gamepad1.left_stick_y;
            Rpower = gamepad1.right_stick_y;

            robotcomponents.LFdrive.setPower(Lpower*fastency);
            robotcomponents.LBdrive.setPower(Lpower*fastency);
            robotcomponents.RFdrive.setPower(Rpower*fastency);
            robotcomponents.RBdrive.setPower(Rpower*fastency);

            if (gamepad2.left_stick_y != 0){
                ArmPos += gamepad2.left_stick_y * 8;
                robotcomponents.Arm.setTargetPosition((int)ArmPos);
            }

            GlyphgrabLPos = Range.clip(GlyphgrabLPos,0.4,1);
            GlyphgrabRPos = Range.clip(GlyphgrabRPos,0,0.6);
            robotcomponents.GlyphgrabL.setPosition(GlyphgrabLPos);
            robotcomponents.GlyphgrabR.setPosition(GlyphgrabRPos);

        }
    }
}

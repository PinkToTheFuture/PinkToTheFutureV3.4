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
        AutonomousVoids standardvoids = new AutonomousVoids();
        standardvoids.INITALL();


        double Rpower;
        double Lpower;
        double GlyphgrabLPos = 0;
        double GlyphgrabRPos = 1;

        double fastency = 1;
        DcMotor Arm = hardwareMap.dcMotor.get("armmotor");
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");
        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        Servo GlyphgrabL = hardwareMap.servo.get("glyphgrabl");
        Servo GlyphgrabR = hardwareMap.servo.get("glyphgrabr");
        Servo RelicSlideOpener = hardwareMap.servo.get("relicslideopener");



        waitOneFullHardwareCycle();
        waitForStart();
        while (opModeIsActive()) {
            waitOneFullHardwareCycle();
            if (gamepad1.dpad_up)     fastency = 1;
            if (gamepad1.dpad_down)   fastency = 0.4;
            if (gamepad1.a) {
                GlyphgrabLPos += 0.01;
                GlyphgrabRPos -= 0.01;
            }
            if (gamepad1.b) {
                GlyphgrabLPos -= 0.01;
                GlyphgrabRPos += 0.01;
            }

            if (gamepad1.x) RelicSlideOpener.setPosition(0);
            if (gamepad1.y) RelicSlideOpener.setPosition(0.7);

            Lpower = gamepad1.left_stick_y;
            Rpower = gamepad1.right_stick_y;

            LFdrive.setPower(Lpower*fastency);
            LBdrive.setPower(Lpower*fastency);
            RFdrive.setPower(Rpower*fastency);
            RBdrive.setPower(Rpower*fastency);


            GlyphgrabLPos = Range.clip(GlyphgrabLPos,0.4,1);
            GlyphgrabRPos = Range.clip(GlyphgrabRPos,0,0.6);
            GlyphgrabL.setPosition(GlyphgrabLPos);
            GlyphgrabR.setPosition(GlyphgrabRPos);
            Arm.setPower(gamepad2.left_stick_y * 0.5);
        }
    }
}

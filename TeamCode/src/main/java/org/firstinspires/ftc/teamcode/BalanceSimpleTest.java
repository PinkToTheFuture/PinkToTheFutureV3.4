package org.firstinspires.ftc.teamcode;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.qualcomm.hardware.hitechnic.HiTechnicNxtDcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "BalanceSimpleTest", group = "TeleOp")
public class BalanceSimpleTest extends LinearOpMode {
    //Motors
    private DcMotor LFdrive;
    private DcMotor LBdrive;
    private DcMotor RFdrive;
    private DcMotor RBdrive;

    //Sensors
    bno055driver imu;


    @Override
    public void runOpMode() throws InterruptedException {
        LFdrive = hardwareMap.dcMotor.get("LFdrive");
        RFdrive = hardwareMap.dcMotor.get("RFdrive");
        LBdrive = hardwareMap.dcMotor.get("LBdrive");
        RBdrive = hardwareMap.dcMotor.get("RBdrive");

        imu = new bno055driver("IMU", hardwareMap);

        double LFpower = 0;
        double RFpower = 0;
        double LBpower = 0;
        double RBpower = 0;

        telemetry.addLine("ready to start");
        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {


            RFpower = -(((imu.getAngles()[1]/10) + (imu.getAngles()[2]/10)) / 2);
            RBpower = -(((imu.getAngles()[1]/10) - (imu.getAngles()[2]/10)) / 2);
            LFpower = -(((imu.getAngles()[1]/10) - (imu.getAngles()[2]/10)) / 2);
            LBpower = -(((imu.getAngles()[1]/10) + (imu.getAngles()[2]/10)) / 2);

            //RIGHT STICK
            RFpower = RFpower - (imu.getAngles()[0]/10);
            RBpower = RBpower - (imu.getAngles()[0]/10);
            LFpower = LFpower + (imu.getAngles()[0]/10);
            LBpower = LBpower + (imu.getAngles()[0]/10);

            Range.clip(RFpower, -1, 1);
            Range.clip(RBpower, -1, 1);
            Range.clip(LFpower, -1, 1);
            Range.clip(LBpower, -1, 1);

            LFdrive.setPower(LFpower);
            RFdrive.setPower(RFpower);
            LBdrive.setPower(LBpower);
            RBdrive.setPower(RBpower);

            telemetry.addLine("Pitch: " + (imu.getAngles()[1])); //pitch
            telemetry.addLine("Roll: " + (imu.getAngles()[2]));  //roll
            telemetry.update();
        }
    }

}

package org.firstinspires.ftc.robotinoneweek;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.*;

@Autonomous(name = "AutoVoids", group = "full")
@Disabled
class RobotComponents extends LinearOpMode implements RobotVariables {
    DcMotor Arm = hardwareMap.dcMotor.get("armmotor");
    DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
    DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
    DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
    DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");
    Servo GlyphgrabL = hardwareMap.servo.get("glyphgrabl");
    Servo GlyphgrabR = hardwareMap.servo.get("glyphgrabr");
    Servo RelicSlideOpenerR = hardwareMap.servo.get("relicslideopenerr");
    Servo RelicSlideOpenerL = hardwareMap.servo.get("relicslideopenerl");




    public void runOpMode(){

    }

}
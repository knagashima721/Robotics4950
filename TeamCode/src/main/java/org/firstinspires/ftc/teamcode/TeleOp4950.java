package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class TeleOp4950 extends LinearOpMode{

    // Declare OpMode variables
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    public void runOpMode() {
        leftMotor = hardwareMap.dcMotor.get("left_m");
        rightMotor = hardwareMap.dcMotor.get("right_m");

        waitForStart();

        while(opModeIsActive()){
            float leftPower = -gamepad1.left_stick_y;
            float rightPower = -gamepad1.right_stick_y;
            leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);
        }
    }
}
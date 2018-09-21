package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class TeleOp4950 extends LinearOpMode{

    // Declare drive motors
    private DcMotor motorRight;
    private DcMotor motorLeft;

    // declare the arm variable
    private Servo armServo;

    // To move robotic arm
    private static final double ARM_RETRACTED_POSITION = 0.2;
    private static final double ARM_EXTENDED_POSITION = 0.8;

    public void runOpMode() throws InterruptedException
    {
        // Initialize drive motors
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");

        // If drive motors are given full power, robot would spin because of the motors being in
        // opposite directions. So reverse one
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        // Initialize arm servo
        armServo = hardwareMap.servo.get("armServo");

        // Retract arm servo to stay within 18"
        armServo.setPosition(ARM_RETRACTED_POSITION);

        // Wait until start button is pressed
        waitForStart();

        // Repeatedly run code in here until stop button is pressed
        while(opModeIsActive())
        {
            // Tank drive
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);

            // Move the arm servo if requested
            if(gamepad2.a)
            {
                armServo.setPosition(ARM_EXTENDED_POSITION);
            }
            if(gamepad2.b)
            {
                armServo.setPosition(ARM_RETRACTED_POSITION);
            }

            // Give hardware a chance to catch up
            idle();
        }
    }
}

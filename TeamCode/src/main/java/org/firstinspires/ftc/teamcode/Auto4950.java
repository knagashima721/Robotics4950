package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

public class Auto4950 extends LinearOpMode{
    HardwarePushbot robot = new HardwarePushbot();
    private ElapsedTime runtime = new ElapsedTime();

    static final double F_SPEED = 0.9;
    static final double T_SPEED = 0.5;

    public void runOpMode(){
        robot.init(hardwareMap);
        waitForStart();

        // Step 1:  Drive forward for 3 seconds
        robot.leftDrive.setPower(F_SPEED);
        robot.rightDrive.setPower(F_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.update();
        }

        // Step 2: Spin right for a second
        robot.leftDrive.setPower(T_SPEED);
        robot.rightDrive.setPower(-T_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.update();
        }

        // Step 3: Go backward for a second
        robot.leftDrive.setPower(-F_SPEED);
        robot.rightDrive.setPower(-F_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.update();
        }


    }

}

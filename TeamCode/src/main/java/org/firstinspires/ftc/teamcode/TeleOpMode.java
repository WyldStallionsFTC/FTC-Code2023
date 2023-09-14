package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TeleTutorial.java ")
public class TeleOpMode extends LinearOpMode {
    private DcMotor backRight;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor frontLeft;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");

        // Put initialization blocks here.
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            telemetry.update();
            if (gamepad1.left_stick_y < 0) {
                forward();
            } else {
                if (gamepad1.left_stick_y > 0) {
                    backward();
                } else {
                    if (gamepad1.left_stick_x > 0) {
                        strafeR();
                    } else {
                        if (gamepad1.left_stick_x < 0) {
                            strafeL();
                        } else {
                            if (gamepad1.left_trigger == 1) {
                                turnL();
                            } else {
                                if (gamepad1.right_trigger == 1) {
                                    turnR();
                                } else {
                                    stopMotors();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void forward()
    {
        frontRight.setPower(gamepad1.left_stick_x);
        backRight.setPower(gamepad1.left_stick_x);
        frontLeft.setPower(gamepad1.left_stick_x);
        backLeft.setPower(gamepad1.left_stick_x);
    }

    public void backward()
    {
        frontRight.setPower(gamepad1.left_stick_x);
        backRight.setPower(gamepad1.left_stick_x);
        frontLeft.setPower(gamepad1.left_stick_x);
        backLeft.setPower(gamepad1.left_stick_x);
    }

    public void strafeL()
    {
        frontRight.setPower(1);
        frontLeft.setPower(1);
        backRight.setPower(-1);
        backLeft.setPower(-1);
}

    public void strafeR()
    {

    }

    public void turnL()
    {

    }

    public void turnR()
    {

    }

    public void stopMotors()
    {
        frontRight.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
    }
}

package org.firstinspires.ftc.teamcode;

import android.icu.text.Transliterator;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class EndEffectorSubsystem extends SubsystemBase {
    private Motor lift1;
    private Motor lift2;

    private MotorGroup liftGroup;

    private HardwareMap hardwareMap;

    public EndEffectorSubsystem(HardwareMap hMap)
    {
        hardwareMap = hMap;
        lift1 = new Motor(hardwareMap, "lift1");
        lift2 = new Motor(hardwareMap, "lift2");

        lift1.setRunMode(Motor.RunMode.PositionControl);
        lift2.setRunMode(Motor.RunMode.PositionControl);

        liftGroup = new MotorGroup(lift1, lift2);
        liftGroup.setRunMode(Motor.RunMode.PositionControl);

        // WE HAVE TO SET POSITION COEFFICIENT HERE
    }

    public boolean isFinished() { return liftGroup.atTargetPosition(); }

    public void liftUp(int setPoint)
    {
        liftGroup.setTargetPosition(setPoint);
        liftGroup.set(0.3);
    }

}

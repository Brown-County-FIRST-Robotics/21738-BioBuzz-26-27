package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public  class driveBaseSubsystem extends SubsystemBase {

    Telemetry m_telemetry;

    private ElapsedTime runtime = new ElapsedTime();
    public DcMotor frontLeft = null;
    public DcMotor frontRight = null;
    public DcMotor backLeft = null;
    public DcMotor backRight = null;

    public DcMotor intake = null;

    GamepadEx gamepadEx;
    public boolean teleop;

    GamepadEx gamepadEx2;
    ElapsedTime m_timer = new ElapsedTime();
    double Time = 0;



    public driveBaseSubsystem(GamepadEx gamepadEx, final HardwareMap hMap) {
        this.gamepadEx = gamepadEx;
        teleop = true;

        frontLeft = hMap.get(DcMotor.class, "frontLeft");
        frontRight = hMap.get(DcMotor.class, "frontRight");
        backLeft = hMap.get(DcMotor.class, "backLeft");
        backRight = hMap.get(DcMotor.class, "backRight");
        intake = hMap.get(DcMotor.class, "intake");


    }


    @Override
    public void periodic() {
        // Setup a variable for each drive wheel to save power level for telemetry

        double axial   =  this.gamepadEx.getLeftY();
        double lateral =  this.gamepadEx.getLeftX();
        double yaw     =  this.gamepadEx.getRightX();


        double frontLeftPower  = axial + lateral + yaw;
        double frontRightPower = axial - lateral - yaw;
        double backLeftPower   = axial - lateral + yaw;
        double backRightPower  = axial + lateral - yaw;
        double intakePower = 1000;

        double max;
        max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1.0) {
            frontLeftPower  /= max;
            frontRightPower /= max;
            backLeftPower   /= max;
            backRightPower  /= max;

            if (teleop) {
                frontLeft.setPower(frontLeftPower);
                frontRight.setPower(frontRightPower);
                backLeft.setPower(backLeftPower);
                backRight.setPower(backRightPower);







            }

            if(gamepadEx.gamepad.right_bumper){
                intake.setPower(1000);
            }

        }

        }

    private double signedSquare(double x) {
        return x * Math.abs(x);
    }
}






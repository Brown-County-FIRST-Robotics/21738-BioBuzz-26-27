package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.button.Button;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*/

import java.util.concurrent.Delayed;

import kotlinx.coroutines.Delay;

@TeleOp(name="main", group="OpMode")
public class Main extends CommandOpMode {
    private static final Logger log = LoggerFactory.getLogger(Main.class);




    driveBaseSubsystem d;
    shooterSubsystem s;



    @Override
    public void initialize() {
        waitForStart();
        GamepadEx gamepadEx = new GamepadEx(gamepad1);
        GamepadEx gamepadEx2 = new GamepadEx(gamepad2);



        d = new driveBaseSubsystem(gamepadEx, hardwareMap);
        Button shooterButton = new GamepadButton(
                gamepadEx2, GamepadKeys.Button.A);

        s = new shooterSubsystem(gamepadEx, telemetry, hardwareMap);







    }

}

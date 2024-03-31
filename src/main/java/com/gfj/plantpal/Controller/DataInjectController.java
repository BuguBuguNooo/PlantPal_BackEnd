package com.gfj.plantpal.Controller;

import com.gfj.plantpal.Pojo.*;
import com.gfj.plantpal.Service.*;
import com.gfj.plantpal.WebSocketServer.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

/**
 * @author gefangjie
 */
@RestController
@RequestMapping("/data")
public class DataInjectController {
    //传感器模块-------------------------------------------------------------------------
    //温湿度传感器数据服务
    private final SensorTemHumDateService sensorTemHumDateService;
    //二氧化碳传感器数据服务
    private final SensorCO2DataService sensorCO2DataService;
    //土壤熵传感器数据服务
    private final SensorSoilEntropyDataService sensorSoilEntropyDataService;
    //土壤湿度传感器数据服务
    //控制器模块-------------------------------------------------------------------------
    private final SensorSoilMoistureDataService sensorSoilMoistureDataService;
    //电能表数据服务
    private final SensorEnergyMeterDataService sensorEnergyMeterDataService;
    //冷水机数据服务
    private final ActuatorChillerDataService actuatorChillerDataService;
    //内循环风扇数据服务
    private final ActuatorFanInDataService actuatorFanInDataService;
    //外循环风扇数据服务
    private final ActuatorFanOutDataService actuatorFanOutDataService;
    //加热器数据服务
    private final ActuatorHeaterDataService actuatorHeaterDataService;
    //加湿器数据服务
    private final ActuatorHumidifierDataService actuatorHumidifierDataService;
    //LED灯数据服务
    private final ActuatorLEDDataService actuatorLEDDataService;
    //水泵数据服务
    private final ActuatorPumpDataService actuatorPumpDataService;
    private final WebSocket webSocket;

    @Autowired
    public DataInjectController(ActuatorChillerDataService actuatorChillerDataService, SensorTemHumDateService sensorTemHumDateService, SensorCO2DataService sensorCO2DataService, SensorSoilEntropyDataService sensorSoilEntropyDataService, ActuatorPumpDataService actuatorPumpDataService, SensorSoilMoistureDataService sensorSoilMoistureDataService, SensorEnergyMeterDataService sensorEnergyMeterDataService, ActuatorFanInDataService actuatorFanInDataService, WebSocket webSocket, ActuatorFanOutDataService actuatorFanOutDataService, ActuatorHeaterDataService actuatorHeaterDataService, ActuatorHumidifierDataService actuatorHumidifierDataService, ActuatorLEDDataService actuatorLEDDataService) {
        this.actuatorChillerDataService = actuatorChillerDataService;
        this.sensorTemHumDateService = sensorTemHumDateService;
        this.sensorCO2DataService = sensorCO2DataService;
        this.sensorSoilEntropyDataService = sensorSoilEntropyDataService;
        this.actuatorPumpDataService = actuatorPumpDataService;
        this.sensorSoilMoistureDataService = sensorSoilMoistureDataService;
        this.sensorEnergyMeterDataService = sensorEnergyMeterDataService;
        this.actuatorFanInDataService = actuatorFanInDataService;
        this.webSocket = webSocket;
        this.actuatorFanOutDataService = actuatorFanOutDataService;
        this.actuatorHeaterDataService = actuatorHeaterDataService;
        this.actuatorHumidifierDataService = actuatorHumidifierDataService;
        this.actuatorLEDDataService = actuatorLEDDataService;
    }

    // sensor通用的数据处理方法
    private <T> ResponseEntity<String> processSensorData(T data, Consumer<T> dataProcessor, String sensorType) {
        if (data == null) {
            return ResponseEntity.badRequest().body("未收到数据！");
        }
        try {
            // 执行特定的数据处理逻辑
            dataProcessor.accept(data);
            // 假设所有数据类型都有getSensor方法，或者使用反射
            webSocket.appointSending(((SensorBaseData) data).getSensor(), "接收到数据: " + data.toString());

            return ResponseEntity.ok(sensorType + "数据接收成功，并通过WebSocket发送");
        } catch (Exception e) {
            System.out.println("接收单条数据时发生错误: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("处理您的请求时发生错误");
        }
    }

    // actuator通用的数据处理方法
    private <T> ResponseEntity<String> processActuatorData(T data, Consumer<T> dataProcessor, String actuatorType) {
        if (data == null) {
            return ResponseEntity.badRequest().body("未收到数据！");
        }
        try {
            // 执行特定的数据处理逻辑
            dataProcessor.accept(data);

            return ResponseEntity.ok(actuatorType + "数据接收成功，并通过WebSocket发送");
        } catch (Exception e) {
            System.out.println("接收单条数据时发生错误: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("处理您的请求时发生错误");
        }
    }

    //接收来自传感器的温湿度数据
    @PostMapping("/TemHum")
    public ResponseEntity<String> insertTemHum(@RequestBody SensorTemHumData data) {
        return processSensorData(data, sensorTemHumDateService::addData, "温湿度");
    }

    //接收来自传感器的CO2浓度数据
    @PostMapping("/CO2")
    public ResponseEntity<String> insertCO2(@RequestBody SensorCO2Data data) {
        return processSensorData(data, sensorCO2DataService::addData, "CO2");
    }

    //接收来自传感器的土壤熵数据
    @PostMapping("/Soil")
    public ResponseEntity<String> insertSoil(@RequestBody SensorSoilEntropyData data) {
        return processSensorData(data, sensorSoilEntropyDataService::addData, "土壤熵");
    }

    //接收来自传感器的土壤湿度数据
    @PostMapping("/SoilHum")
    public ResponseEntity<String> InsertSoilHum(@RequestBody SensorSoilMoistureData data) {
        return processSensorData(data, sensorSoilMoistureDataService::addData, "土壤湿度");
    }

    //接收来自电能表的总数据
    @PostMapping("/Power")
    public ResponseEntity<String> InsertPower(@RequestBody SensorEnergyMeterData data) {
        return processSensorData(data, sensorEnergyMeterDataService::addData, "电能表");
    }

    //接收来自水泵开关状态的数据
    @PostMapping("/Pump")
    public ResponseEntity<String> InsertPump(@RequestBody ActuatorPumpData data) {
        return processActuatorData(data, actuatorPumpDataService::addData, "水泵");
    }

    //接收来自LED灯的开关状态的数据
    @PostMapping("/LED")
    public ResponseEntity<String> InsertLED(@RequestBody ActuatorLEDData data) {
        return processActuatorData(data, actuatorLEDDataService::addData, "LED灯");
    }

    //接收来自冷水机开关状态的数据
    @PostMapping("/Chiller")
    public ResponseEntity<String> InsertChiller(@RequestBody ActuatorChillerData data) {
        return processActuatorData(data, actuatorChillerDataService::addData, "冷水机");
    }

    //接收来自外循环风扇开关状态的数据
    @PostMapping("/FanOut")
    public ResponseEntity<String> InsertFan(@RequestBody ActuatorFanOutData data) {
        return processActuatorData(data, actuatorFanOutDataService::addData, "外循环风扇");
    }

    //接收来自内循环风扇开关状态的数据
    @PostMapping("/FanIn")
    public ResponseEntity<String> InsertFanIn(@RequestBody ActuatorFanInData data) {
        return processActuatorData(data, actuatorFanInDataService::addData, "内循环风扇");
    }

    //接收来自加热器开关状态的数据
    @PostMapping("/Heater")
    public ResponseEntity<String> InsertHeater(@RequestBody ActuatorHeaterData data) {
        return processActuatorData(data, actuatorHeaterDataService::addData, "加热器");
    }

    //接收来自加湿器开关状态的数据
    @PostMapping("/Humidifier")
    public ResponseEntity<String> InsertHumidifier(@RequestBody ActuatorHumidifierData data) {
        return processActuatorData(data, actuatorHumidifierDataService::addData, "加湿器");
    }


}

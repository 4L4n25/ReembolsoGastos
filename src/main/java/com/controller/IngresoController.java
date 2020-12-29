package com.controller;

import com.dto.IngresoDto;
import com.service.IIngresoService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

import javax.json.JsonArray;
import java.util.List;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {
@Autowired
    private IIngresoService IngresoService;

@GetMapping
    public JSONObject ListJson(@RequestParam int page,@RequestParam int start,@RequestParam int limit)
{
    List<IngresoDto> IngresoList = (List<IngresoDto>) IngresoService.GetAll();
    JSONObject JsonStore= new JSONObject();
    JsonStore.put("total", IngresoList.size());
    JSONArray JsonDataList = new JSONArray();
    for(IngresoDto AluLop : IngresoList)
    {
        JSONObject JsonData = new JSONObject();
        JsonData.put("idIngreso",AluLop.getIdIngreso());
        JsonData.put("fechaIngreso",AluLop.getFechaIngreso());
        JsonData.put("ingreso",AluLop.getIngreso());
        JsonData.put("descripcion",AluLop.getDescripcion());
        JsonData.put("cuenta",AluLop.getCuenta());
        JsonDataList.add(JsonData)
    }
    JsonStore.put("IngresoListJson", JsonDataList);
    return JsonStore;
}

}

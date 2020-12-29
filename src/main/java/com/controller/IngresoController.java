package com.controller;

import com.domain.Ingreso;
import com.dto.IngresoDto;
import com.service.IIngresoService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        JsonDataList.add(JsonData);
    }
    JsonStore.put("IngresoListJson", JsonDataList);
    return JsonStore;
}
@PostMapping
    public ResponseEntity<Void> Save(@RequestBody IngresoDto IngresoDTO)
{
IngresoService.Save(IngresoDTO);
return new ResponseEntity<>(HttpStatus.CREATED);
}
@PutMapping
    public ResponseEntity<Void> Update(@RequestBody IngresoDto IngresoDTO)
{
    IngresoService.Update(IngresoDTO);
    return new ResponseEntity<>(HttpStatus.OK);
}
@DeleteMapping("/{IdeIngreso}")
    public ResponseEntity<Void> Delete(@PathVariable Integer IdeIngreso)
{
    IngresoService.Delete(new Ingreso(IdeIngreso));
    return new ResponseEntity<>(HttpStatus.OK);
}
@GetMapping("/{IdeIngreso}")
    public ResponseEntity<IngresoDto> GetById(@PathVariable Integer IdeIngreso)
{
    IngresoDto IngresoDTO = IngresoService.GetById(IdeIngreso);
    return new ResponseEntity<>(IngresoDTO,IngresoDTO == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
}

}

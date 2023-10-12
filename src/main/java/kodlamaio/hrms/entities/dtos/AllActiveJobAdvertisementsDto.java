package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllActiveJobAdvertisementsDto {

	private String companyName;

	private String positionName;

	private int personCount;

	private Date lastAdvertisementDate;

}

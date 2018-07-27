package domain;

import lombok.Data;


	
	@Data 
	public class ExamBean  {
		private String exam_id, score, sub_seq, record_seq,month,mem_id;


	@Override
	public String toString() {
		return "ExamBean [exam_id=" + exam_id + ", score=" + score + ", sub_seq=" + sub_seq + ", record_seq="
				+ record_seq + ", month=" + month + ", mem_id=" + mem_id + "]";
	}

	
	
}

/*
 * Generic DIS client
 */


class DISClient {
    /**
     * Method used to uniquely identify this lab group
     * @return Unique identifier of this lab group
     */
    public static LabGroup getLabGroup() {
	LabGroup lg = new LabGroup();

	/* TODO: Change the added members below as to reflect
	   your own lab group. The parameters are (in order):
	   first name, last name, personal number. */
	lg.addMember("Alexander", "Lind", "910329-1770");
	lg.addMember("Douglas", "Froling", "YYYYYY-YYYY");

	return lg;
    }
}

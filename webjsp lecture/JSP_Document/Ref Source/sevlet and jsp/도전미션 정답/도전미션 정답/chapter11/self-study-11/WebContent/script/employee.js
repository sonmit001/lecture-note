function employeeCheck() {
  if (document.frm.id.length == 0) {
    alert("���̵�  ���ּ���.");
    document.frm.id.focus();
    return false;
  }
  if (document.frm.pass.value.length == 0) {
    alert("��й�ȣ�� ���ּ���");
    document.frm.pass.focus();
    return false;
  }
  if (document.frm.name.value.length == 0) {
    alert("�̸��� �Է��ؾ� �մϴ�");
    document.frm.name.focus();
    return false;
  }
  return true;
}

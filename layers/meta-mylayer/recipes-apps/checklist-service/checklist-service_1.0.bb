SUMMARY = "Systemd unit for the Go web server"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://checklist.service"
S = "${UNPACKDIR}"
inherit systemd
SYSTEMD_SERVICE:${PN} = "checklist.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/checklist.service ${D}${systemd_system_unitdir}/
}
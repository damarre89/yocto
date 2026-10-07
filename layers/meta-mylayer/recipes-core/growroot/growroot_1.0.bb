SUMMARY = "Expand root partition on first boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://growroot.sh file://growroot.service"
S = "${UNPACKDIR}"
inherit systemd
SYSTEMD_SERVICE:${PN} = "growroot.service"
SYSTEMD_AUTO_ENABLE = "enable"
RDEPENDS:${PN} = "parted e2fsprogs-resize2fs"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${UNPACKDIR}/growroot.sh ${D}${sbindir}/growroot
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/growroot.service ${D}${systemd_system_unitdir}/
}
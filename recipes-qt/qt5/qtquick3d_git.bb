require qt5.inc
require qt5-git.inc

LICENSE = "(GPL-3.0 & BSD) | The-Qt-Company-Commercial"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
"

DEPENDS += "qtbase qtdeclarative qtquickcontrols2"

SRC_URI += " \
    git://github.com/assimp/assimp.git;name=assimp;branch=master;protocol=https;destsuffix=git/src/3rdparty/assimp/src \
"

PACKAGECONFIG ??= ""
PACKAGECONFIG[system-assimp] = "-system-quick3d-assimp,-qt-quick3d-assimp,assimp"

EXTRA_QMAKEVARS_CONFIGURE += "${PACKAGECONFIG_CONFARGS}"

FILES_${PN}-qmlplugins += " \
  ${OE_QMAKE_PATH_QML}/QtQuick3D/Helpers/meshes/*.mesh \
"

SRCREV_qtquick3d = "c9073f11ba540353aa5e3a6f8653569daf9ed606"
SRCREV_assimp = "ac8a8a5ad433afd2a10124774685f9db1edbe701"

SRCREV_FORMAT = "qtquick3d_assimp"

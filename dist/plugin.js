var capacitorveer = (function (exports, core) {
    'use strict';

    const veer = core.registerPlugin('veer', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.veerWeb()),
    });

    class veerWeb extends core.WebPlugin {
        async echo(options) {
            console.log('ECHO', options);
            return options;
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        veerWeb: veerWeb
    });

    exports.veer = veer;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map

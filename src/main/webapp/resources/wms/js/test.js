function whatYourName(name, callback) {
    console.log('name: ', name);
    callback();
}

function finishFunc() {
    console.log('finish function');
}

whatYourName('miniddo', finishFunc);
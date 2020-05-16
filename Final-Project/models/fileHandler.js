module.exports = {
    uploadFile: function (file, path, name) {
        file.mv(path + name, function (error) {
            if (error) {
                console.log('Could not upload the file');
                console.log(error);
            } else {
                console.log(name + " " + 'has been uploaded');
            }
        });
    },
    
    parseFile: function() {

    },

    deleteFile: function(fs, path, name) {
        let filePath = path+name;
        try {
            fs.unlinkSync(filePath);
        } catch (error) {
            console.log(error);
        }
    }
}
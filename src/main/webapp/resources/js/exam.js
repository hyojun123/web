var common = {
    init	: function () {
        $("#exam").off().on('click', function () {
            call.first();
        })
    }
}

var call = {
    first: function () {
        var that = this;
        $.ajax({
            url: 'http://node.nalpari.net/tests/api/init',
            success: function (result) {
                for(var key in result) {
                    console.log("Attributes : " + key + ", value = " + result[key]);
                }
            //    console.log("first : " + result);

                that.plus(result.data);
            }
        });

    },
    plus: function (data) {
        var that = this;
        $.ajax({
            type: 'GET',
            url: 'http://node.nalpari.net/tests/api/plus',
            data: {"data": data},
            success: function (result) {
                for(var key in result) {
                    console.log("Attributes : " + key + ", value = " + result[key]);
                }
             //   console.log("plus메소드 : "+result.data);
                that.minus(result.data);
            }
        });
    },

    minus: function (data) {
        var that = this;
        $.ajax({
            type: 'GET',
            url: 'http://node.nalpari.net/tests/api/minus',
            data: {"data": data},
            success: function (result) {
                for(var key in result) {
                    console.log("Attributes : " + key + ", value = " + result[key]);
                }
             //   console.log("minus메소드 : " + result.data);
                that.multi(result.data);
            }
        });
    },
    multi: function (data) {
        var that = this;
        $.ajax({
            type: 'GET',
            url: 'http://node.nalpari.net/tests/api/multi',
            data: {"data": data},
            success: function (result) {
                for(var key in result) {
                    console.log("Attributes : " + key + ", value = " + result[key]);
                }
              //  console.log("multi메소드 : " + result.data);
                that.divis(result.data);
            }
        });

    },
    divis: function (data) {
        $.ajax({
            type: 'GET',
            url: 'http://node.nalpari.net/tests/api/divis',
            data: {"data": data},
            success: function (result) {
                for(var key in result) {
                    console.log("Attributes : " + key + ", value = " + result[key]);
                }
               // console.log("divis메소드 : " + result.data);
            }
        });
    }
}


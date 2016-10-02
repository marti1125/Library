var User = Backbone.Model.extend({});

var Users = Backbone.Collection.extend({
  model: User,
  url: "/users"
});

var users = new Users();

var columns = [{
    name: "idUser",
    label: "ID",
    editable: false,
    cell: Backgrid.IntegerCell.extend({
      orderSeparator: ''
    })
  }, {
    name: "username",
    label: "Username",
    editable: false,
    cell: "string"
  }, {
    name: "",
    label: "Full Name",
    editable: false,
    cell: Backgrid.Cell.extend({
      render: function(){
          this.$el.html(this.model.get("lastname")+" "+this.model.get("motherslastname")+", "+this.model.get("name"));
          return this;
      }  
    })
  }
];

var gridUsers = new Backgrid.Grid({
  columns: columns,
  collection: users
});

$("#backgrid_user").append(gridUsers.render().el);

users.fetch({reset: true});
function fire_ajax_submit() {
  var config = {
    apiKey: "AIzaSyCdBehmah6p2QybLmHAgmd1SbhyuMBZ0k0",
    authDomain: "kabaluat-40f19.firebaseapp.com",
    databaseURL: "https://kabaluat-40f19.firebaseio.com",
    projectId: "kabaluat-40f19",
    storageBucket: "kabaluat-40f19.appspot.com",
    messagingSenderId: "450584397826"
  };
  firebase.initializeApp(config);

var db=firebase.firestore();
        var colloection = db.collection("test");
        var userID = user.uid;           // ID after created the user.
        var Email = user.email;
        var Name = user.displayName;
        colloection.doc(userID).set({
           email : "madan",
            name : "madan" // some another information for user you could save it here.
               // you could save the ID as field in document.
        }).then(()=>{
             window.location.href = "home.html";
             alert("at the end of login");
        });
}
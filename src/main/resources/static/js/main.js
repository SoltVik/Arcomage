/* Main JS */


function PlayCard(cardId, playerId, enemyId) {
    var myDiv = document.getElementById('testoutput');

    $.post("api/card/play", {cardId:cardId, playerId:playerId, enemyId:enemyId}, function(data) {
        myDiv.innerHTML = cardId;
    });
}
/*    */ package world.entity.haven;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import init.value.COMPARATOR;
/*    */ import init.value.GValueCat;
/*    */ import init.value.Value;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GValueCat<Faction>.LockJson
/*    */ {
/*    */   null(GValueCat paramGValueCat, String $anonymous0, Json $anonymous1) {
/* 88 */     super(paramGValueCat, $anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void callback(COMPARATOR comp, Value<Faction> value, String key, Json json) {
/* 92 */     WHavenType.this.add(false, comp, value, json.d(key));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\WHavenType$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
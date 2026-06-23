/*    */ package init.resources;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import init.race.Race;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ public final class ResSupplies {
/*    */   public final LIST<ResSupply> ALL;
/* 14 */   private final ResSupply[] look = new ResSupply[RESOURCES.ALL().size()];
/*    */ 
/*    */   
/*    */   private final RMAP<ResSupply> map;
/*    */ 
/*    */   
/*    */   ResSupplies() {
/* 21 */     ArrayListGrower<ResSupply> all = new ArrayListGrower();
/* 22 */     PATH p = PATHS.INIT().getFolder("resource").getFolder("supply");
/* 23 */     String[] keys = p.getFiles(); byte b; int i;
/*    */     String[] arrayOfString1;
/* 25 */     for (i = (arrayOfString1 = keys).length, b = 0; b < i; ) { String k = arrayOfString1[b];
/* 26 */       Json j = new Json(p.gets(k));
/* 27 */       ResSupply s = new ResSupply(k, j, (LISTE<ResSupply>)all);
/* 28 */       if (this.look[s.resource.index()] != null)
/* 29 */         j.error("Army supply: " + (this.look[s.resource.index()]).resource.key + " refers to the same resource: " + s.resource.key, k); 
/* 30 */       this.look[s.resource.index()] = s; b++; }
/*    */     
/* 32 */     this.map = new RMAP("ARMY_SUPPLY", (LIST)all);
/* 33 */     this.ALL = (LIST<ResSupply>)all;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ResSupply get(RESOURCE res) {
/* 39 */     return this.look[res.index()];
/*    */   }
/*    */   
/*    */   public RMAP<ResSupply> MAP() {
/* 43 */     return this.map;
/*    */   }
/*    */   
/*    */   public void setEfficiency(Race race, Json json) {
/* 47 */     this.map.getClass();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\ResSupplies.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
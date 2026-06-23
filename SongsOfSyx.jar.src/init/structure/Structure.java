/*    */ package init.structure;
/*    */ 
/*    */ import game.faction.player.PlayerColors;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ import util.text.Dic;
/*    */ 
/*    */ public final class Structure
/*    */   extends INFO
/*    */   implements MAPPED
/*    */ {
/*    */   public final String key;
/*    */   public final CharSequence nameWall;
/*    */   public final CharSequence nameCeiling;
/*    */   public final double durability;
/*    */   public final RESOURCE resource;
/*    */   public final int resAmount;
/*    */   public final PlayerColors.PlayerColor tint;
/*    */   public final COLOR miniColor;
/*    */   private final int index;
/*    */   public final double constructTime;
/*    */   
/*    */   Structure(String key, LISTE<Structure> all, Json data, Json text) {
/* 32 */     super(text);
/* 33 */     this.key = key;
/* 34 */     this.nameWall = text.text("NAME_WALL");
/* 35 */     this.nameCeiling = text.text("NAME_CEILING");
/*    */     
/* 37 */     this.constructTime = data.d("BUILD_TIME", 0.0D, 10000.0D);
/* 38 */     this.durability = data.d("DURABILITY", 0.0D, 1.0D) * 64.0D;
/* 39 */     if (data.has("RESOURCE")) {
/* 40 */       this.resource = (RESOURCE)RESOURCES.map().read(data);
/* 41 */       this.resAmount = data.i("RESOURCE_AMOUNT", 0, 16);
/*    */     } else {
/* 43 */       this.resource = null;
/* 44 */       this.resAmount = 0;
/*    */     } 
/*    */     
/* 47 */     this.tint = new PlayerColors.PlayerColor(new ColorImp(data), "BUILDING_" + key, Dic.¤¤Structures, this.name);
/* 48 */     this.miniColor = (COLOR)new ColorImp(data, "MINIMAP_COLOR");
/*    */     
/* 50 */     this.index = all.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 55 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 60 */     return this.key;
/*    */   }
/*    */   
/*    */   public TBuilding terrain() {
/* 64 */     return (SETT.TERRAIN()).BUILDINGS.get(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\structure\Structure.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
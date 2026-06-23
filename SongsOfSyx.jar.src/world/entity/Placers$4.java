/*     */ package world.entity;
/*     */ 
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import world.WORLD;
/*     */ import world.entity.haven.WHavenType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends PlacableSimpleTile
/*     */ {
/*     */   int ni;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/* 101 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.ni = 0;
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty) {
/* 111 */     CharSequence nn = (CharSequence)((WHavenType)type.get()).names.getC(this.ni++);
/*     */     
/* 113 */     Str.TMP.clear().add(nn);
/* 114 */     Str.TMP.insert(0, (CharSequence)(((WHavenType)type.get()).race.appearance()).lastNamesNoble.getC(RND.rInt(65535)));
/*     */     
/* 116 */     (WORLD.ENTITIES()).havens.create(tx, ty, (WHavenType)type.get(), inte.getD(), nn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 122 */     return (LIST<CLICKABLE>)ss;
/*     */   } public CharSequence isPlacable(int tx, int ty) {
/*     */     return null;
/*     */   }
/*     */   public PLACABLE getUndo() {
/* 127 */     return (PLACABLE)undo;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 132 */     return (SPRITE)(((WHavenType)(WORLD.ENTITIES()).havens.types.get(0)).race.appearance()).icon;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\Placers$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
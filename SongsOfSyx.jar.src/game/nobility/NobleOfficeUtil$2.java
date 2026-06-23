/*     */ package game.nobility;
/*     */ 
/*     */ import game.boosting.Boostable;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
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
/*     */   extends NobleOffice
/*     */ {
/*     */   null(ArrayListGrower<NobleOffice> $anonymous0, double $anonymous1, Boostable $anonymous2, CharSequence $anonymous3, CharSequence $anonymous4, Icon $anonymous5) {
/* 143 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*     */   }
/*     */   
/*     */   public double value(int slots) {
/* 147 */     if (blue.employment().employed() <= 0)
/* 148 */       return ((slots > 0) ? true : false); 
/* 149 */     return CLAMP.d(slots * workers / blue.employment().employed(), 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintIns<?> room() {
/* 154 */     if (blue instanceof RoomBlueprintIns)
/* 155 */       return (RoomBlueprintIns)blue; 
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverValue(GBox b, int slots) {
/* 161 */     b.add((SPRITE)this.target.icon);
/* 162 */     b.textLL(this.target.name);
/* 163 */     b.tab(6);
/* 164 */     b.add((SPRITE)GFORMAT.f0(b.text(), 2.0D));
/* 165 */     b.add((SPRITE)(UI.icons()).s.human);
/* 166 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), (slots * workers), blue.employment().employed()));
/* 167 */     b.add((SPRITE)GFORMAT.f0(b.text(), value(slots) * this.add));
/* 168 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public int popBoosted(int slots) {
/* 173 */     return slots * workers;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\NobleOfficeUtil$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
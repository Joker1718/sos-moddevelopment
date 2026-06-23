/*     */ package settlement.room.law.prison;
/*     */ 
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import view.main.VIEW;
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   ACTION a;
/*     */   
/*     */   null(SPRITE $anonymous0, final CRIME_PUNISHMENTS.PUNISHMENT p) {
/* 161 */     super($anonymous0);
/*     */     
/* 163 */     this.a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 167 */           Gui.null.access$0(Gui.null.this).makePrisoners((PrisonInstance)g.get());
/* 168 */           for (Humanoid h : (Gui.null.access$0(Gui.null.this)).list) {
/* 169 */             if (p.available(AIModule_Prisoner.DATA().clas(h.indu()))) {
/* 170 */               (AIModule_Prisoner.DATA()).punishmentSet.set(h.ai(), p);
/* 171 */               h.interrupt();
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 179 */     (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP.clear().add(Gui.¤¤setSure).insert(0, p.action), this.a, ACTION.NOP, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 184 */     GBox b = (GBox)text;
/* 185 */     GText t = b.text();
/* 186 */     t.add(Gui.¤¤setAll).insert(0, p.action);
/* 187 */     b.add((SPRITE)t);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\Gui$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
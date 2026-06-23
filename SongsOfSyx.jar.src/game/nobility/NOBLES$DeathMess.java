/*     */ package game.nobility;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class DeathMess
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Induvidual indu;
/*     */   private final int no;
/*     */   private final int ranks;
/*     */   private String text;
/*     */   private boolean replaced = false;
/*     */   
/*     */   public DeathMess(Humanoid h, Noble n) {
/* 261 */     super(NOBLES.¤¤title);
/* 262 */     this.indu = new Induvidual(h.indu().hType(), h.race());
/* 263 */     this.indu.copyFromHard(h.indu());
/* 264 */     (STATS.APPEARANCE()).dead.indu().set(this.indu, 1);
/* 265 */     this.no = (n.office() == null) ? -1 : (n.office()).index;
/* 266 */     this.ranks = n.rank();
/* 267 */     if (this.no >= 0) {
/* 268 */       Str.TMP.clear().add(NOBLES.¤¤mess);
/* 269 */       Str.TMP.insert(0, n.rankName());
/* 270 */       Str.TMP.insert(1, STATS.APPEARANCE().name(h.indu()));
/* 271 */       Str.TMP.insert(2, n.title());
/*     */     } else {
/* 273 */       Str.TMP.clear().add(NOBLES.¤¤messNo);
/* 274 */       Str.TMP.insert(0, n.rankName());
/* 275 */       Str.TMP.insert(1, STATS.APPEARANCE().name(h.indu()));
/*     */     } 
/* 277 */     this.text = String.valueOf(Str.TMP);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 285 */     paragraph(this.text);
/*     */     
/* 287 */     section.addRelBody(8, DIR.N, (SPRITE)new SPRITE.Imp(160, 256)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 291 */             STATS.APPEARANCE().portraitRender(r, NOBLES.DeathMess.this.indu, X1, Y1, 4);
/*     */           }
/*     */         });
/*     */     
/* 295 */     if (this.no >= 0) {
/* 296 */       GButt.ButtPanel b = new GButt.ButtPanel(NOBLES.¤¤replace)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction()
/*     */           {
/* 303 */             activeSet((!NOBLES.DeathMess.this.replaced && (GAME.NOBLE()).active.size() < (GAME.NOBLE()).MAX.get((BOOSTABLE_O)HCLASS_RACE.clP())));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 308 */             if (NOBLES.DeathMess.this.replaced || (GAME.NOBLE()).active.size() >= (GAME.NOBLE()).MAX.get((BOOSTABLE_O)HCLASS_RACE.clP()))
/*     */               return; 
/* 310 */             NOBLES.DeathMess.this.replaced = true; byte b; int i;
/*     */             ENTITY[] arrayOfENTITY;
/* 312 */             for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 313 */               if (e instanceof Humanoid) {
/* 314 */                 Humanoid a = (Humanoid)e;
/* 315 */                 if (a.race() == NOBLES.DeathMess.this.indu.race() && a.indu().clas() == HCLASSES.CITIZEN()) {
/* 316 */                   NobleOffice o = (NobleOffice)(GAME.NOBLE()).OFFICES.get(NOBLES.DeathMess.this.no);
/* 317 */                   a.nobleSet();
/* 318 */                   GAME.NOBLE().setOffice(a.noble(), o);
/* 319 */                   for (int j = 0; j < NOBLES.DeathMess.this.ranks; j++) {
/* 320 */                     if (GAME.NOBLE().ranksAllocated() < (GAME.NOBLE()).MAX_RANKS.get((BOOSTABLE_O)HCLASS_RACE.clP()))
/* 321 */                       GAME.NOBLE().ranksAllocate(a.noble()); 
/*     */                   } 
/* 323 */                   VIEW.messages().hide();
/*     */                   
/*     */                   return;
/*     */                 } 
/*     */               } 
/*     */               
/*     */               b++; }
/*     */           
/*     */           }
/*     */         };
/*     */       
/* 334 */       b.hoverInfoSet(NOBLES.¤¤replaceD);
/*     */       
/* 336 */       section.addRelBody(8, DIR.S, (RENDEROBJ)b);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\NOBLES$DeathMess.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
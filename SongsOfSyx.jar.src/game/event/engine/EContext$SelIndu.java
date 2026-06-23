/*     */ package game.event.engine;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SelIndu
/*     */   extends EContext.SelContext<Induvidual>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Induvidual i1;
/*     */   private Induvidual i2;
/*     */   
/*     */   private SelIndu() {
/* 413 */     super("indu");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean init(Event abs) {
/* 419 */     fix();
/* 420 */     return super.init(abs);
/*     */   }
/*     */   
/*     */   private void fix() {
/* 424 */     if (this.i1 == null)
/* 425 */       this.i1 = new Induvidual(HTYPES.SOLDIER(), FACTIONS.player().race()); 
/* 426 */     if (this.i2 == null) {
/* 427 */       this.i2 = new Induvidual(HTYPES.SOLDIER(), FACTIONS.player().race());
/*     */     }
/*     */   }
/*     */   
/*     */   public Induvidual first() {
/* 432 */     return this.i1;
/*     */   }
/*     */ 
/*     */   
/*     */   public Induvidual second() {
/* 437 */     return this.i2;
/*     */   }
/*     */ 
/*     */   
/*     */   void copy(EContext.SelContext<Induvidual> o) {
/* 442 */     fix();
/* 443 */     super.copy(o);
/*     */   }
/*     */ 
/*     */   
/*     */   SPRITE sprite() {
/* 448 */     if (this.i1 != null) {
/* 449 */       return (SPRITE)new SPRITE.Imp(120, 192)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 452 */             STATS.APPEARANCE().portraitRender(r, EContext.SelIndu.this.i1, X1, Y1, 3);
/*     */           }
/*     */         };
/*     */     }
/*     */     
/* 457 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   ESelection.ESelectionType<Induvidual> sel(Event abs) {
/* 462 */     return abs.selection.indu;
/*     */   }
/*     */ 
/*     */   
/*     */   void set(Induvidual first, Induvidual second) {
/* 467 */     if (first != null)
/* 468 */       this.i1.copyFromHard(first); 
/* 469 */     if (second != null) {
/* 470 */       this.i2.copyFromHard(second);
/*     */     }
/*     */   }
/*     */   
/*     */   int max() {
/* 475 */     return SETT.ENTITIES().Imax();
/*     */   }
/*     */ 
/*     */   
/*     */   Induvidual get(int index) {
/* 480 */     ENTITY e = SETT.ENTITIES().getAllEnts()[index];
/* 481 */     if (e != null && e instanceof Humanoid) {
/* 482 */       return ((Humanoid)e).indu();
/*     */     }
/* 484 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void markSet(Induvidual t, int id) {
/* 489 */     (STATS.EVENT()).mark.set(t, id);
/*     */   }
/*     */ 
/*     */   
/*     */   int markGet(Induvidual t) {
/* 494 */     return (STATS.EVENT()).mark.get(t);
/*     */   }
/*     */ 
/*     */   
/*     */   void eventSet(Induvidual t, int b) {
/* 499 */     STATS.EVENT().set(t, (b == 1));
/*     */   }
/*     */ 
/*     */   
/*     */   boolean eventGet(Induvidual t) {
/* 504 */     return STATS.EVENT().has(t);
/*     */   }
/*     */ 
/*     */   
/*     */   int tot() {
/* 509 */     return (STATS.POP()).POP.data().get(null);
/*     */   }
/*     */ 
/*     */   
/*     */   Class<?> cl() {
/* 514 */     return Induvidual.class;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EContext$SelIndu.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
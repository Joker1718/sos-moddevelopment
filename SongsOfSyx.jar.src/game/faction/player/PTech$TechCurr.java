/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.tech.TechCurrency;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.admin.AdminData;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TechCurr
/*     */ {
/*     */   public final TechCurrency cu;
/*     */   private int allocated;
/* 468 */   private double frozen = 0.0D;
/* 469 */   private double penalty = 0.0D;
/*     */   private boolean forgetting = false;
/* 471 */   private double forgetTimer = 50.0D;
/* 472 */   private double askTimer = -10.0D;
/* 473 */   private final HistoryInt total = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/*     */   
/*     */   TechCurr(TechCurrency cu) {
/* 476 */     this.cu = cu;
/*     */   }
/*     */   
/*     */   public int allocated() {
/* 480 */     return this.allocated;
/*     */   }
/*     */   
/*     */   public int frozen() {
/* 484 */     return (int)Math.ceil(this.frozen);
/*     */   }
/*     */   
/*     */   public int total() {
/* 488 */     return (int)this.cu.bo.get((BOOSTABLE_O)HCLASS_RACE.clP());
/*     */   }
/*     */   
/*     */   public int available() {
/* 492 */     return total() - frozen() - allocated();
/*     */   }
/*     */   
/*     */   public double penalty() {
/* 496 */     return this.penalty;
/*     */   }
/*     */   
/*     */   public HISTORY_INT produced() {
/* 500 */     this.total.set(total());
/* 501 */     return (HISTORY_INT)this.total;
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 505 */     GBox b = (GBox)box;
/* 506 */     box.title(this.cu.bo.name);
/*     */ 
/*     */     
/* 509 */     this.cu.bo.hoverDetailed(box, (BOOSTABLE_O)HCLASS_RACE.clP(), Dic.¤¤Produced, true);
/* 510 */     b.NL();
/*     */     
/* 512 */     b.textLL(PTech.¤¤allocated);
/* 513 */     b.tab(6);
/* 514 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -this.allocated));
/* 515 */     b.NL();
/*     */     
/* 517 */     b.textLL(PTech.¤¤frozen);
/* 518 */     b.tab(6);
/* 519 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -frozen()));
/* 520 */     b.NL();
/*     */     
/* 522 */     b.sep();
/*     */     
/* 524 */     b.textLL(PTech.¤¤available);
/* 525 */     b.tab(6);
/* 526 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), available()));
/* 527 */     b.NL();
/*     */     
/* 529 */     b.textLL(PTech.¤¤penalty);
/* 530 */     b.tab(6);
/* 531 */     b.add((SPRITE)GFORMAT.percInv(b.text(), this.penalty));
/* 532 */     b.NL();
/*     */     
/* 534 */     b.sep();
/*     */     
/* 536 */     for (RoomBlueprint bb : SETT.ROOMS().all()) {
/*     */ 
/*     */       
/* 539 */       if (bb instanceof RoomBlueprintIns && bb instanceof AdminData.ROOM_ADMIN_HOLDER) {
/* 540 */         AdminData d = ((AdminData.ROOM_ADMIN_HOLDER)bb).admin();
/* 541 */         if (d.target == this.cu.bo) {
/* 542 */           b.title(((RoomBlueprintIns)bb).info.names);
/*     */ 
/*     */           
/* 545 */           b.textL(Dic.¤¤Produced);
/* 546 */           b.tab(6);
/* 547 */           b.add((SPRITE)GFORMAT.f0(b.text(), d.value()));
/* 548 */           b.NL();
/*     */           
/* 550 */           b.textL(Dic.¤¤Target);
/* 551 */           b.tab(6);
/* 552 */           b.add((SPRITE)GFORMAT.f0(b.text(), d.projection()));
/* 553 */           b.NL();
/*     */           
/* 555 */           b.NL();
/* 556 */           b.textL(Dic.¤¤Employees);
/* 557 */           b.tab(6);
/* 558 */           b.add((SPRITE)GFORMAT.i(b.text(), bb.employment().employed()));
/* 559 */           b.NL();
/*     */           
/* 561 */           b.textL(Dic.¤¤ProductionRate);
/* 562 */           b.tab(6);
/* 563 */           b.add((SPRITE)GFORMAT.f0(b.text(), d.perEmployee()));
/* 564 */           b.NL(6);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void save(FilePutter file) {
/* 574 */     file.i(this.allocated);
/* 575 */     file.d(this.frozen);
/* 576 */     file.d(this.penalty);
/* 577 */     file.bool(this.forgetting);
/* 578 */     file.d(this.forgetTimer);
/* 579 */     file.d(this.askTimer);
/* 580 */     this.total.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 585 */     this.allocated = file.i();
/* 586 */     this.frozen = file.d();
/* 587 */     this.penalty = file.d();
/* 588 */     this.forgetting = file.bool();
/* 589 */     this.forgetTimer = file.d();
/* 590 */     this.askTimer = file.d();
/* 591 */     this.total.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void clear() {
/* 596 */     this.allocated = 0;
/* 597 */     this.frozen = 0.0D;
/* 598 */     this.penalty = 0.0D;
/* 599 */     this.forgetting = false;
/* 600 */     this.forgetTimer = 50.0D;
/* 601 */     this.askTimer = -10.0D;
/* 602 */     this.total.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTech$TechCurr.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
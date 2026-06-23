/*     */ package game.battle.thread.general;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.BattleThread;
/*     */ import game.battle.thread.general.offence.Strategos2000UpdaterOffense;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.interrupter.IDebugPanel;
/*     */ 
/*     */ public class Strategos2000
/*     */   extends BattleThread
/*     */ {
/*     */   private final StrategosUtil context;
/*     */   private Strategos2000Updater current;
/*     */   private final Strategos2000Updater offense;
/*     */   private int oldDivs;
/*     */   private boolean debug = false;
/*  25 */   private double prevUpdate = 0.0D;
/*     */   
/*     */   public Strategos2000() {
/*  28 */     super(0.008333333333333333D);
/*  29 */     this.context = new StrategosUtil();
/*     */     
/*  31 */     this.offense = (Strategos2000Updater)new Strategos2000UpdaterOffense(this.context);
/*  32 */     this.current = this.offense;
/*     */     
/*  34 */     IDebugPanel.add("Battle General Debug", new ACTION() {
/*  35 */           ON_TOP_RENDERABLE ren = new ON_TOP_RENDERABLE()
/*     */             {
/*     */               public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */               {
/*  39 */                 RenderData.RenderIterator it = data.onScreenTiles();
/*     */                 
/*  41 */                 if ((Strategos2000.null.access$0(Strategos2000.null.this)).current == null) {
/*     */                   return;
/*     */                 }
/*  44 */                 while (it.has()) {
/*  45 */                   (Strategos2000.null.access$0(Strategos2000.null.this)).current.render(r, it);
/*  46 */                   it.next();
/*     */                 } 
/*     */                 
/*  49 */                 (Strategos2000.null.access$0(Strategos2000.null.this)).current.render(r, shadowBatch, data);
/*     */                 
/*  51 */                 if (!(Strategos2000.null.access$0(Strategos2000.null.this)).debug) {
/*  52 */                   remove();
/*     */                 }
/*     */               }
/*     */             };
/*     */           
/*     */           public void exe() {
/*  58 */             Strategos2000.this.debug = !Strategos2000.this.debug;
/*  59 */             this.ren.add();
/*     */           }
/*     */         });
/*     */     
/*  63 */     IDebugPanel.add("battle general pause", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  67 */             Strategos2000.this.stop();
/*     */           }
/*     */         });
/*  70 */     IDebugPanel.add("battle general unpause", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  74 */             Strategos2000.this.stop();
/*  75 */             Strategos2000.this.start();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  82 */     file.mark(this.offense);
/*  83 */     this.offense.save(file);
/*  84 */     file.mark(this.offense);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  89 */     file.check(this.offense);
/*  90 */     this.offense.load(file);
/*  91 */     file.check(this.offense);
/*     */   }
/*     */ 
/*     */   
/*     */   public enum State
/*     */   {
/*  97 */     ATTACK;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init() {
/* 103 */     this.offense.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doThreadJob() {
/* 108 */     int newDivs = 0;
/* 109 */     for (int di = 0; di < this.context.getArmy().divisions().size(); di++) {
/* 110 */       if (((Div)this.context.getArmy().divisions().get(di)).active())
/* 111 */         newDivs++; 
/*     */     } 
/* 113 */     if (newDivs == 0 && 
/* 114 */       this.oldDivs > 0) {
/* 115 */       this.offense.clear();
/*     */     }
/*     */     
/* 118 */     this.oldDivs = newDivs;
/*     */ 
/*     */     
/* 121 */     if (this.prevUpdate - TIME.currentSecond() > -2.0D) {
/*     */       return;
/*     */     }
/* 124 */     this.prevUpdate = TIME.currentSecond() + 2.0D; do {
/*     */     
/* 126 */     } while (this.thread.working() && 
/* 127 */       this.offense.update());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\Strategos2000.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
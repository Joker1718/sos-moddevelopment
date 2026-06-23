/*     */ package game.battle.thread.status;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.BattleThread;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.interrupter.IDebugPanel;
/*     */ 
/*     */ public final class BattleStatus
/*     */   extends BattleThread
/*     */ {
/*  22 */   private BattleContext current = new BattleContext();
/*  23 */   private volatile BattleContext nextnext = new BattleContext();
/*  24 */   private volatile BattleContext next = this.nextnext;
/*  25 */   private final Updater updater = new Updater();
/*     */   
/*     */   public BattleStatus() {
/*  28 */     super(0.5D);
/*  29 */     IDebugPanel.add("Battle Status Debug", new ACTION()
/*     */         {
/*  31 */           ON_TOP_RENDERABLE ren = new ON_TOP_RENDERABLE()
/*     */             {
/*     */               public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */               {
/*  35 */                 RenderData.RenderIterator it = data.onScreenTiles();
/*  36 */                 if ((BattleStatus.null.access$0(BattleStatus.null.this)).current == null) {
/*     */                   return;
/*     */                 }
/*  39 */                 while (it.has()) {
/*  40 */                   int p = (BattleStatus.null.access$0(BattleStatus.null.this)).current.map.soldiers(GAME.ARMIES().player()).get(it.tile());
/*  41 */                   int e = (BattleStatus.null.access$0(BattleStatus.null.this)).current.map.soldiers(GAME.ARMIES().enemy()).get(it.tile());
/*  42 */                   if (p != 0 || e != 0) {
/*     */                     
/*  44 */                     Str.TMP.clear().add(p).add('/').add(e);
/*  45 */                     (UI.FONT()).S.render((SPRITE_RENDERER)r, (CharSequence)Str.TMP, it.x(), it.y());
/*     */                   } 
/*     */                   
/*  48 */                   it.next();
/*     */                 } 
/*  50 */                 if (!BattleStatus.null.this.debug)
/*  51 */                   remove(); 
/*     */               }
/*     */             };
/*     */           boolean debug = false;
/*     */           public void exe() {
/*  56 */             this.debug = !this.debug;
/*  57 */             this.ren.add();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void stop() {
/*  70 */     this.updater.stop = true;
/*  71 */     super.stop();
/*  72 */     this.updater.stop = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init() {
/*  87 */     this.updater.init(this.current);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doThreadJob() {
/*  93 */     if (this.next == null) {
/*  94 */       this.next = this.nextnext;
/*     */       
/*     */       return;
/*     */     } 
/*  98 */     this.updater.init(this.next);
/*  99 */     BattleContext c = this.current;
/* 100 */     this.current = this.next;
/* 101 */     this.nextnext = c;
/* 102 */     this.next = null;
/*     */   }
/*     */   
/*     */   public static DivStatus status(Div d) {
/* 106 */     return (GAME.BATTLE_THREADS()).status.current.statuses[d.index()];
/*     */   }
/*     */   
/*     */   public static DivsTileMap map() {
/* 110 */     return (GAME.BATTLE_THREADS()).status.current.map;
/*     */   }
/*     */   
/*     */   public static DivsQuadMap quads() {
/* 114 */     return (GAME.BATTLE_THREADS()).status.current.quads;
/*     */   }
/*     */   
/*     */   public static DivsSpaceMap space() {
/* 118 */     return (GAME.BATTLE_THREADS()).status.current.space;
/*     */   }
/*     */   
/*     */   public static DivArmyMap army() {
/* 122 */     return (GAME.BATTLE_THREADS()).status.current.army;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\BattleStatus.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
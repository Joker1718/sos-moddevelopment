/*     */ package game.events.general;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.event.engine.Event;
/*     */ import game.event.engine.EventCollection;
/*     */ import game.events.EVENTS;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Tree;
/*     */ import view.interrupter.IDebugPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EventGeneral
/*     */   extends EVENTS.EventResource
/*     */ {
/*     */   private final EventCollection coll;
/*     */   private final double eventsPerSecondLow;
/*     */   private final double eventsPerSecondHigh;
/*     */   private final Tree<Event> spawnSort;
/*  28 */   private double timer = 0.0D;
/*     */   
/*     */   public EventGeneral() throws IOException {
/*  31 */     super("ENGINE");
/*     */     
/*  33 */     double d = (new Json((PATHS.EVENT()).init.gets("_CONFIG"))).d("DAYS_BETWEEN_EVENTS_POP_0", 0.0D, 1000.0D);
/*  34 */     this.eventsPerSecondLow = 1.0D / d * TIME.secondsPerDay();
/*     */     
/*  36 */     d = (new Json((PATHS.EVENT()).init.gets("_CONFIG"))).d("DAYS_BETWEEN_EVENTS_POP_5000", 0.0D, 1000.0D);
/*  37 */     this.eventsPerSecondHigh = 1.0D / d * TIME.secondsPerDay();
/*     */     
/*  39 */     this.coll = new EventCollection(PATHS.EVENT());
/*     */     
/*  41 */     this.spawnSort = new Tree<Event>(this.coll.all.size())
/*     */       {
/*     */         protected boolean isGreaterThan(Event current, Event cmp)
/*     */         {
/*  45 */           return (GAME.EVENT().acc(current) > GAME.EVENT().acc(cmp));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  50 */     IDebugPanel.add("Spawn next event", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  54 */             EventGeneral.this.spawn();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  62 */     file.d(this.timer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  67 */     this.timer = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  72 */     this.timer = 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  78 */     if (GAME.EVENT().current() != null) {
/*     */       return;
/*     */     }
/*  81 */     if (this.timer >= this.coll.all.size()) {
/*  82 */       if (!spawn()) {
/*  83 */         this.timer -= 5.0D;
/*     */       } else {
/*  85 */         this.timer -= (int)this.timer;
/*     */       } 
/*     */     }
/*  88 */     int no = (int)this.timer;
/*     */     
/*  90 */     double d = POP.tot(null, null) / 10000.0D;
/*  91 */     d = CLAMP.d(d, 0.0D, 1.0D);
/*  92 */     d *= this.eventsPerSecondHigh - this.eventsPerSecondLow;
/*     */ 
/*     */     
/*  95 */     d = this.eventsPerSecondLow + d;
/*     */     
/*  97 */     this.timer += ds * d * this.coll.all.size();
/*  98 */     int nn = (int)this.timer;
/*     */     
/* 100 */     for (; no < nn && no < this.coll.all.size(); no++) {
/*     */       
/* 102 */       Event e = (Event)this.coll.all.get(no);
/* 103 */       GAME.EVENT().accInc(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean spawn() {
/* 113 */     this.spawnSort.clear();
/* 114 */     for (Event e : this.coll.all) {
/* 115 */       if (GAME.EVENT().acc(e) > 0.0D) {
/* 116 */         this.spawnSort.add(e);
/*     */       }
/*     */     } 
/*     */     
/* 120 */     int m = 0;
/*     */     
/* 122 */     while (m++ < 5 && this.spawnSort.hasMore()) {
/* 123 */       Event e = (Event)this.spawnSort.pollGreatest();
/* 124 */       if (GAME.EVENT().trySet(e)) {
/* 125 */         return true;
/*     */       }
/*     */     } 
/* 128 */     return !this.spawnSort.hasMore();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\general\EventGeneral.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package game.events;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.debug.Profiler;
/*     */ import game.events.advice.EventAdvisor;
/*     */ import game.events.citizen.EventCitizen;
/*     */ import game.events.disaster.EventAccident;
/*     */ import game.events.disaster.EventDisease;
/*     */ import game.events.disaster.EventDiseaseMild;
/*     */ import game.events.disaster.EventTemperature;
/*     */ import game.events.faction.EventWorld;
/*     */ import game.events.general.EventGeneral;
/*     */ import game.events.killer.EventKiller;
/*     */ import game.events.slave.EventUprising;
/*     */ import game.events.world.EventWorldRebellion;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SuperSaver;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ public final class EVENTS
/*     */   extends GAME.GameResource
/*     */ {
/*  28 */   public final EventCitizen riot = new EventCitizen();
/*  29 */   public final EventUprising uprising = new EventUprising();
/*  30 */   public final EventDisease disease = new EventDisease();
/*  31 */   public final EventDiseaseMild diseaseM = new EventDiseaseMild();
/*  32 */   public final EventKiller killer = new EventKiller();
/*  33 */   public final EventTemperature temperature = new EventTemperature();
/*  34 */   public final EventAdvisor advice = new EventAdvisor();
/*  35 */   public final EventAccident accident = new EventAccident();
/*  36 */   public final EventWorld world = new EventWorld();
/*  37 */   public final EventWorldRebellion rebellion = new EventWorldRebellion();
/*  38 */   public final EventGeneral general = new EventGeneral();
/*     */   
/*  40 */   private final SuperSaver<EventResource> saver = new SuperSaver<EventResource>(getClass(), (LIST)all)
/*     */     {
/*     */       protected void save(EVENTS.EventResource t, FilePutter f)
/*     */       {
/*  44 */         t.save(f);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void load(EVENTS.EventResource t, FileGetter f) throws IOException {
/*  49 */         t.load(f);
/*     */       }
/*     */ 
/*     */       
/*     */       protected String key(EVENTS.EventResource t) {
/*  54 */         return t.key;
/*     */       }
/*     */ 
/*     */       
/*     */       protected void clear(EVENTS.EventResource t) {
/*  59 */         t.clear();
/*     */       }
/*     */     };
/*     */   
/*     */   public EVENTS() throws IOException {
/*  64 */     super("EVENTS", false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  69 */     this.saver.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  74 */     this.saver.load(file);
/*     */   }
/*     */   
/*     */   public void generate() {
/*  78 */     this.saver.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFail() {
/*  83 */     this.saver.clear();
/*     */   }
/*     */   
/*  86 */   private static LinkedList<EventResource> all = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<EventResource> all() {
/*  98 */     return (LIST<EventResource>)all;
/*     */   }
/*     */   
/*     */   public static abstract class EventResource
/*     */   {
/*     */     private boolean supress;
/*     */     public final String key;
/*     */     
/*     */     protected EventResource(String key) {
/* 107 */       EVENTS.all.add(this);
/* 108 */       this.key = key;
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract void update(double param1Double);
/*     */ 
/*     */     
/*     */     protected abstract void save(FilePutter param1FilePutter);
/*     */ 
/*     */     
/*     */     protected abstract void load(FileGetter param1FileGetter) throws IOException;
/*     */     
/*     */     protected abstract void clear();
/*     */     
/*     */     public void supress(boolean supress) {
/* 123 */       this.supress = supress;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 130 */     if (!SETT.exists())
/*     */       return; 
/* 132 */     prof.logStart(EVENTS.class);
/* 133 */     for (EventResource e : all) {
/* 134 */       if (!e.supress)
/* 135 */         e.update(ds); 
/* 136 */     }  prof.logEnd(EVENTS.class);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\EVENTS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
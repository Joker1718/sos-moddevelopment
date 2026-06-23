/*    */ package settlement.stats;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.stat.DataRaces;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.stat.StatCollection;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
/*    */ 
/*    */ public final class StatsInit
/*    */ {
/* 20 */   public final PATH pd = PATHS.INIT().getFolder("stats");
/* 21 */   public final PATH pt = PATHS.TEXT().getFolder("stats");
/*    */   
/* 23 */   public final KeyMap<SAVABLE> savers = new KeyMap();
/*    */   
/* 25 */   public final LinkedList<StatUpdatableI> updatable = new LinkedList();
/*    */   
/* 27 */   public final LinkedList<StatDisposable> disposable = new LinkedList();
/* 28 */   public final LinkedList<StatCollection> holders = new LinkedList();
/* 29 */   public final LinkedList<StatUpdatable> upers = new LinkedList();
/* 30 */   public final ArrayListGrower<Addable> addable = new ArrayListGrower();
/*    */   
/* 32 */   public final LinkedList<StatInitable> onArrival = new LinkedList();
/* 33 */   public final LinkedList<STAT> onArrivalStats = new LinkedList();
/* 34 */   public final LinkedList<ACTION.ACTION_O<Induvidual>> onArrivalActions = new LinkedList();
/* 35 */   public final LinkedList<StatInitable> onConstruct = new LinkedList();
/* 36 */   public final LinkedList<INT_O.INT_OE<Induvidual>> copier = new LinkedList();
/*    */ 
/*    */   
/* 39 */   public final LinkedList<STAT> stats = new LinkedList();
/*    */   
/* 41 */   public final LinkedList<DataRaces> datas = new LinkedList();
/*    */   
/* 43 */   public final KeyMap<StatCollection> collMap = new KeyMap();
/* 44 */   public final KeyMap<STAT> statMap = new KeyMap();
/*    */ 
/*    */ 
/*    */   
/*    */   public StatCollection coll;
/*    */ 
/*    */ 
/*    */   
/* 52 */   public final DataO<Induvidual> count = new DataO<Induvidual>("STATS")
/*    */     {
/*    */       protected long[] data(Induvidual t) {
/* 55 */         return t.data;
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */   
/* 61 */   public final Json dText = new Json(PATHS.TEXT().getFolder("stats").gets("NAMES"));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(String key, StatCollection collection) {
/* 69 */     this.coll = collection;
/* 70 */     this.collMap.put(key, collection);
/*    */   }
/*    */   
/*    */   public static interface Addable
/*    */   {
/*    */     default void addH(Induvidual i) {
/* 76 */       if (i.added())
/* 77 */         addPrivate(i); 
/*    */     }
/*    */     default void removeH(Induvidual i) {
/* 80 */       if (i.added())
/* 81 */         removePrivate(i); 
/*    */     }
/*    */     
/*    */     void addPrivate(Induvidual param1Induvidual);
/*    */     
/*    */     void removePrivate(Induvidual param1Induvidual);
/*    */   }
/*    */   
/*    */   public static interface StatDisposable {
/*    */     void dispose(Humanoid param1Humanoid);
/*    */   }
/*    */   
/*    */   public static interface StatInitable {
/*    */     void init(Induvidual param1Induvidual);
/*    */   }
/*    */   
/*    */   public static interface StatUpdatable {
/*    */     void update(double param1Double);
/*    */   }
/*    */   
/*    */   public static interface StatUpdatableI {
/*    */     void update16(Humanoid param1Humanoid, int param1Int1, boolean param1Boolean, int param1Int2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\StatsInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
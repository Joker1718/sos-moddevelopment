/*    */ package settlement.thing.halfEntity.caravan;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import init.trade.TRADE_TYPE;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.thing.halfEntity.Factory;
/*    */ import settlement.thing.halfEntity.HalfEntity;
/*    */ import settlement.trade.TradableData;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ public class Caravans
/*    */   extends Factory<Caravan> {
/* 19 */   private final Type export = new TypeWithDraw();
/* 20 */   private final Type delivery = new TypeDeliver();
/*    */   
/* 22 */   final TradableData[] deliveries = new TradableData[RESOURCES.ALL().size()];
/* 23 */   final TradableData[] withdrawals = new TradableData[RESOURCES.ALL().size()];
/*    */ 
/*    */   
/*    */   public Caravans(LISTE<Factory<?>> all) {
/* 27 */     super(all);
/* 28 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 29 */       this.deliveries[r.index()] = new TradableData();
/* 30 */       this.withdrawals[r.index()] = new TradableData();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {
/* 36 */     RESOURCES.map().saver().save((SAVABLE[])this.deliveries, file);
/* 37 */     RESOURCES.map().saver().save((SAVABLE[])this.withdrawals, file);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 42 */     RESOURCES.map().loader().load((SAVABLE[])this.deliveries, file);
/* 43 */     RESOURCES.map().loader().load((SAVABLE[])this.withdrawals, file);
/*    */   } protected void clear() {
/*    */     byte b;
/*    */     int i;
/*    */     TradableData[] arrayOfTradableData;
/* 48 */     for (i = (arrayOfTradableData = this.deliveries).length, b = 0; b < i; ) { TradableData t = arrayOfTradableData[b];
/* 49 */       t.clear(); b++; }
/* 50 */      for (i = (arrayOfTradableData = this.withdrawals).length, b = 0; b < i; ) { TradableData t = arrayOfTradableData[b];
/* 51 */       t.clear();
/*    */       b++; }
/*    */   
/*    */   }
/*    */   public int deliveries(RESOURCE res, TRADE_TYPE t) {
/* 56 */     return this.deliveries[res.index()].get(t);
/*    */   }
/*    */   
/*    */   public int withdrawals(RESOURCE res, TRADE_TYPE t) {
/* 60 */     return this.withdrawals[res.index()].get(t);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Caravan make() {
/* 65 */     return new Caravan();
/*    */   }
/*    */   
/*    */   public boolean createFetcher(RESOURCE res, int amount, TRADE_TYPE ttype) {
/* 69 */     return create(res, amount, this.export, ttype);
/*    */   }
/*    */   
/*    */   public boolean createDelivery(RESOURCE res, int amount, TRADE_TYPE ttype) {
/* 73 */     if (create(res, amount, this.delivery, ttype))
/* 74 */       return true; 
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   private boolean create(RESOURCE res, int amount, Type type, TRADE_TYPE ttype) {
/* 79 */     COORDINATE coo = (SETT.ENTRY()).points.randomReachable();
/* 80 */     if (coo == null) {
/* 81 */       return false;
/*    */     }
/* 83 */     Caravan c = (Caravan)create();
/* 84 */     if (c.init(coo.x(), coo.y(), type, res, amount, ttype)) {
/* 85 */       return true;
/*    */     }
/* 87 */     type.cancel(c, false);
/*    */     
/* 89 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\caravan\Caravans.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package game.faction;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.statistics.HISTORY_COLLECTION;
/*     */ import util.statistics.HistoryTradable;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public abstract class FResources
/*     */   extends FactionResource
/*     */ {
/*  20 */   private static CharSequence ¤¤worn = "¤Furniture";
/*  21 */   private static CharSequence ¤¤theft = "¤Theft";
/*     */   
/*     */   static {
/*  24 */     D.ts(FResources.class);
/*     */   }
/*     */   
/*  27 */   private final HistoryTradable[] all = new HistoryTradable[RTYPE.all.size() * 2 + 1];
/*     */   public final TIMECYCLE time;
/*     */   
/*     */   public FResources(int saved, TIMECYCLE time) {
/*  31 */     for (int i = 0; i < this.all.length; i++)
/*  32 */       this.all[i] = new HistoryTradable(saved, time, false); 
/*  33 */     this.time = time;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getAvailable(TRADABLE paramTRADABLE);
/*     */ 
/*     */ 
/*     */   
/*     */   public HISTORY_COLLECTION<TRADABLE> in(RTYPE t) {
/*  43 */     return (HISTORY_COLLECTION<TRADABLE>)this.all[t.ordinal()];
/*     */   }
/*     */   
/*     */   public HISTORY_COLLECTION<TRADABLE> out(RTYPE t) {
/*  47 */     return (HISTORY_COLLECTION<TRADABLE>)this.all[RTYPE.all.size() + t.ordinal()];
/*     */   }
/*     */   
/*     */   public HISTORY_COLLECTION<TRADABLE> total() {
/*  51 */     return (HISTORY_COLLECTION<TRADABLE>)this.all[this.all.length - 1];
/*     */   }
/*     */   
/*     */   public void inc(TRADABLE res, RTYPE type, int am) {
/*  55 */     if (am > 0) {
/*  56 */       this.all[type.ordinal()].inc(res, am);
/*     */     } else {
/*  58 */       this.all[RTYPE.all.size() + type.ordinal()].inc(res, -am);
/*  59 */     }  this.all[this.all.length - 1].inc(res, am);
/*     */   }
/*     */ 
/*     */   
/*     */   public void inc(RESOURCE res, RTYPE type, int am) {
/*  64 */     inc((TRADABLE)TR.get(res), type, am);
/*     */   }
/*     */   
/*     */   public void dec(TRADABLE res, RTYPE type, int am) {
/*  68 */     inc(res, type, -am);
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) { byte b;
/*     */     int i;
/*     */     HistoryTradable[] arrayOfHistoryTradable;
/*  74 */     for (i = (arrayOfHistoryTradable = this.all).length, b = 0; b < i; ) { HistoryTradable rr = arrayOfHistoryTradable[b];
/*  75 */       rr.save(file);
/*     */       b++; }
/*     */      } protected void load(FileGetter file) throws IOException { byte b;
/*     */     int i;
/*     */     HistoryTradable[] arrayOfHistoryTradable;
/*  80 */     for (i = (arrayOfHistoryTradable = this.all).length, b = 0; b < i; ) { HistoryTradable rr = arrayOfHistoryTradable[b];
/*  81 */       rr.load(file);
/*     */       b++; }
/*     */      } public void clear() { byte b;
/*     */     int i;
/*     */     HistoryTradable[] arrayOfHistoryTradable;
/*  86 */     for (i = (arrayOfHistoryTradable = this.all).length, b = 0; b < i; ) { HistoryTradable historyTradable = arrayOfHistoryTradable[b];
/*  87 */       historyTradable.clear();
/*     */       b++; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Faction f) {}
/*     */ 
/*     */   
/*     */   public enum RTYPE
/*     */   {
/*  99 */     PRODUCED((String)Dic.¤¤Production),
/* 100 */     CONSUMED((String)Dic.¤¤Consumed),
/* 101 */     TRADE((String)Dic.¤¤Trade),
/* 102 */     TAX((String)Dic.¤¤taxes),
/* 103 */     CONSTRUCTION((String)Dic.¤¤construction),
/* 104 */     FURNISH((String)FResources.¤¤worn),
/* 105 */     EQUIPPED((String)Dic.¤¤Equipped),
/* 106 */     MAINTENANCE((String)Dic.¤¤Maintenance),
/* 107 */     SPOILAGE((String)Dic.¤¤Spoilage),
/* 108 */     ARMY_SUPPLY(String.valueOf(Dic.¤¤Supplies) + ": " + String.valueOf(Dic.¤¤Supplies)),
/* 109 */     SPOILS(String.valueOf(Dic.¤¤Battle) + ": " + String.valueOf(Dic.¤¤Battle)),
/* 110 */     DIPLOMACY((String)Dic.¤¤Diplomacy),
/* 111 */     THEFT((String)FResources.¤¤theft);
/*     */ 
/*     */ 
/*     */     
/* 115 */     public static final LIST<RTYPE> all = (LIST<RTYPE>)new ArrayList((Object[])values()); public final CharSequence name;
/*     */     static {
/*     */     
/*     */     }
/*     */     RTYPE(CharSequence name) {
/* 120 */       this.name = name;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FResources.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
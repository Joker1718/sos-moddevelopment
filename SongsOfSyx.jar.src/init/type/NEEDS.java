/*     */ package init.type;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.RMAP;
/*     */ import util.text.D;
/*     */ 
/*     */ public class NEEDS {
/*     */   private static NEEDS self;
/*     */   private final BoostableCat bCat;
/*     */   private final BoostableCat bCatE;
/*     */   private final ArrayListGrower<NEED> ALL;
/*     */   
/*     */   NEEDS() {
/*  21 */     D.gInit(this);
/*     */ 
/*     */     
/*  24 */     this.bCat = new BoostableCat("RATES_", D.g("Service", "Service Needs"), "", 4, (SPRITE)(UI.icons()).s.house);
/*  25 */     this.bCatE = new BoostableCat("RATES_", D.g("Basic Needs"), "", 4, (SPRITE)(UI.icons()).s.house);
/*     */     
/*  27 */     this.ALL = new ArrayListGrower();
/*  28 */     this.ALLNE = new ArrayListGrower();
/*  29 */     this.ALLE = new ArrayListGrower();
/*     */ 
/*     */     
/*  32 */     this.f = PATHS.STATS().folder("need");
/*     */ 
/*     */     
/*  35 */     self = this;
/*     */ 
/*     */     
/*  38 */     PATHS.ResFolder f = PATHS.STATS().folder("need"); byte b; int i;
/*     */     String[] arrayOfString;
/*  40 */     for (i = (arrayOfString = f.init.getFiles()).length, b = 0; b < i; ) { String k = arrayOfString[b]; b++; }
/*     */ 
/*     */ 
/*     */     
/*  44 */     this.types = new Types();
/*     */     
/*  46 */     ArrayListGrower<NEED> events = new ArrayListGrower();
/*     */     
/*  48 */     for (NEED n : this.ALL) {
/*  49 */       if (n.event > 1.0D)
/*  50 */         events.add(n); 
/*  51 */       if (n instanceof NEED_E)
/*     */         continue; 
/*  53 */       this.ALLNE.add(n);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  58 */     int days = events.size() * 2 + 1;
/*  59 */     int day = 0;
/*  60 */     for (NEED n : events)
/*     */     {
/*  62 */       day += 2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     this.coll = new RMAP("NEED", (LIST)this.ALL);
/*     */   }
/*     */   private final ArrayListGrower<NEED> ALLNE; private final ArrayListGrower<NEED_E> ALLE; private final RMAP<NEED> coll; private final Types types; private final PATHS.ResFolder f;
/*  71 */   private static CharSequence ¤¤event = "Small Event";
/*     */   static {
/*  73 */     D.ts(NEEDS.class);
/*     */   }
/*     */   
/*     */   private static class Event
/*     */     extends BoosterImp {
/*     */     private final int day;
/*     */     private final int days;
/*     */     
/*     */     public Event(int day, int days, NEED need) {
/*  82 */       super(new BSourceInfo(NEEDS.¤¤event, (SPRITE)(UI.icons()).s.arrowUp), 1.0D, need.event, true);
/*  83 */       this.day = day;
/*  84 */       this.days = days;
/*  85 */       add(need.rate);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Faction f) {
/*  90 */       return ((TIME.days().bitsSinceStart() % this.days == this.day) ? true : false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<NEED> ALL() {
/*  97 */     return (LIST<NEED>)self.ALL;
/*     */   }
/*     */   
/*     */   public static LIST<NEED> ALLSIMPLE() {
/* 101 */     return (LIST<NEED>)self.ALLNE;
/*     */   }
/*     */   
/*     */   public static LIST<NEED_E> ALLE() {
/* 105 */     return (LIST<NEED_E>)self.ALLE;
/*     */   }
/*     */ 
/*     */   
/*     */   public static BoostableCat bCat() {
/* 110 */     return self.bCat;
/*     */   }
/*     */   
/*     */   public static BoostableCat bCatE() {
/* 114 */     return self.bCatE;
/*     */   }
/*     */   
/*     */   public static Types TYPES() {
/* 118 */     return self.types;
/*     */   }
/*     */   
/*     */   public static RMAP<NEED> MAP() {
/* 122 */     return self.coll;
/*     */   }
/*     */   public final class Types { public final NEED_E HUNGER; public final NEED_E THIRST; public final NEED_E SHOPPING; public final NEED SKINNYDIP; public final NEED TEMPLE; public final NEED SHRINE;
/*     */     public Types() {
/* 126 */       this.HUNGER = new NEED_E("_HUNGER", NEEDS.this.f, (LISTE<NEED>)NEEDS.this.ALL, (LISTE<NEED_E>)NEEDS.this.ALLE, NEEDS.this.bCatE);
/* 127 */       this.THIRST = new NEED_E("_THIRST", NEEDS.this.f, (LISTE<NEED>)NEEDS.this.ALL, (LISTE<NEED_E>)NEEDS.this.ALLE, NEEDS.this.bCatE);
/* 128 */       this.SHOPPING = new NEED_E("_SHOPPING", NEEDS.this.f, (LISTE<NEED>)NEEDS.this.ALL, (LISTE<NEED_E>)NEEDS.this.ALLE, NEEDS.this.bCatE);
/* 129 */       this.SKINNYDIP = new NEED("_SKINNYDIP", NEEDS.this.f, (LISTE<NEED>)NEEDS.this.ALL, NEEDS.this.bCat, (SPRITE)(UI.icons()).s.drop, false);
/* 130 */       this.TEMPLE = new NEED("_TEMPLE", NEEDS.this.f, (LISTE<NEED>)NEEDS.this.ALL, NEEDS.this.bCat, (SPRITE)(UI.icons()).s.temple, false);
/* 131 */       this.SHRINE = new NEED("_SHRINE", NEEDS.this.f, (LISTE<NEED>)NEEDS.this.ALL, NEEDS.this.bCat, (SPRITE)(UI.icons()).s.shrine, false);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\NEEDS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
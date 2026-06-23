/*     */ package settlement.thing.halfEntity.caravan;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.export.ExportFetcher;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ class TypeWithDraw
/*     */   extends Type
/*     */ {
/*  15 */   private static short STATE_EXPORT = 0;
/*  16 */   private static short STATE_OTHER = 1;
/*  17 */   private static short STATE_RETURN = 2;
/*     */   
/*  19 */   private static CharSequence ¤¤verb = "¤fetching";
/*     */   
/*     */   static {
/*  22 */     D.ts(TypeWithDraw.class);
/*     */   }
/*     */   
/*     */   TypeWithDraw() {
/*  26 */     super(¤¤verb);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean init(Caravan c, int amount) {
/*  31 */     c.reservedGlobally = (short)amount;
/*  32 */     c.amountCarried = 0;
/*  33 */     (SETT.HALFENTS()).caravans.withdrawals[c.res.index()].inc(c.tType(), c.reservedGlobally);
/*  34 */     if (fetch(c))
/*  35 */       return true; 
/*  36 */     (SETT.HALFENTS()).caravans.withdrawals[c.res.index()].inc(c.tType(), -c.reservedGlobally);
/*  37 */     c.reservedGlobally = 0;
/*  38 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean fetch(Caravan c) {
/*  43 */     c.path.clear();
/*     */     
/*  45 */     c.tmp = 1;
/*     */     
/*  47 */     c.reserved = 0;
/*  48 */     int target = c.reservedGlobally - c.amountCarried;
/*     */     
/*  50 */     ExportFetcher f = (SETT.ROOMS()).EXPORT.FETCHER;
/*  51 */     COORDINATE coo = f.getReservableSpot(c.ctx(), c.cty(), c.res);
/*  52 */     if (coo != null) {
/*  53 */       int am = f.reservable(c.res, coo);
/*  54 */       if (am > target) {
/*  55 */         am = target;
/*     */       }
/*  57 */       if (c.path.request(c.ctx(), c.cty(), coo.x(), coo.y(), false)) {
/*  58 */         c.reserved = (short)am;
/*  59 */         f.reserve(c.res, coo, am);
/*  60 */         c.move();
/*  61 */         c.state = STATE_EXPORT;
/*  62 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/*  66 */     if ((SETT.PATH()).finders.resource.find((c.res()).bit, (c.res()).bit, (c.res()).bit, c.ctx(), c.cty(), c.path, 2147483647) != null) {
/*  67 */       c.reserved = 1;
/*  68 */       if (target - 1 > 0)
/*     */       {
/*  70 */         c.reserved = (short)(c.reserved + (SETT.PATH()).finders.resource.reserveExtra(true, true, c.res, c.path.destX(), c.path.destY(), target - 1));
/*     */       }
/*  72 */       c.move();
/*  73 */       c.state = STATE_OTHER;
/*  74 */       return true;
/*     */     } 
/*     */     
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean pickup(Caravan c) {
/*  82 */     if (c.reserved <= 0) {
/*  83 */       return false;
/*     */     }
/*  85 */     ExportFetcher f = (SETT.ROOMS()).EXPORT.FETCHER;
/*  86 */     if (c.state == STATE_EXPORT) {
/*     */       
/*  88 */       coo.set(c.path.destX(), c.path.destY());
/*  89 */       int am = f.reserved(c.res, (COORDINATE)coo);
/*  90 */       if (am > 0) {
/*  91 */         int max = 1;
/*  92 */         if (max > am)
/*  93 */           max = am; 
/*  94 */         if (max > c.reserved)
/*  95 */           max = c.reserved; 
/*  96 */         f.finish(c.res, (COORDINATE)coo, max, c.tType());
/*  97 */         c.amountCarried = (short)(c.amountCarried + max);
/*  98 */         c.reserved = (short)(c.reserved - max);
/*  99 */         return true;
/*     */       }
/*     */     
/* 102 */     } else if (c.state == STATE_OTHER) {
/* 103 */       if ((SETT.PATH()).finders.resource.pickup(c.res, c.path.destX(), c.path.destY(), 1) == 1) {
/* 104 */         c.reserved = (short)(c.reserved - 1);
/* 105 */         c.amountCarried = (short)(c.amountCarried + 1);
/* 106 */         FACTIONS.player().res().inc(c.res, (c.tType()).rtype, -1);
/* 107 */         return true;
/*     */       } 
/*     */     } else {
/* 110 */       throw new RuntimeException("" + c.state);
/*     */     } 
/* 112 */     c.reserved = 0;
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update(Caravan c, double ds) {
/* 120 */     if (c.state == STATE_RETURN) {
/* 121 */       return false;
/*     */     }
/* 123 */     if (pickup(c)) {
/* 124 */       return true;
/*     */     }
/* 126 */     if (c.amountCarried < c.reservedGlobally && 
/* 127 */       fetch(c)) {
/* 128 */       return true;
/*     */     }
/*     */     
/* 131 */     if ((SETT.PATH()).finders.entryPoints.find(c.ctx(), c.cty(), c.path, 2147483647)) {
/* 132 */       c.move();
/* 133 */       c.state = STATE_RETURN;
/* 134 */       return true;
/*     */     } 
/*     */     
/* 137 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel(Caravan c, boolean dump) {
/* 143 */     ExportFetcher f = (SETT.ROOMS()).EXPORT.FETCHER;
/* 144 */     if (c.reserved > 0) {
/* 145 */       if (c.state == STATE_EXPORT) {
/* 146 */         coo.set(c.path.destX(), c.path.destY());
/* 147 */         int am = f.reserved(c.res, (COORDINATE)coo);
/* 148 */         if (am > 0) {
/* 149 */           if (am > c.reserved)
/* 150 */             am = c.reserved; 
/* 151 */           FACTIONS.player().res().inc(c.res, (c.tType()).rtype, -am);
/* 152 */           f.finish(c.res, (COORDINATE)coo, am, c.tType());
/* 153 */           c.amountCarried = (short)(c.amountCarried + am);
/* 154 */           c.reserved = (short)(c.reserved - am);
/* 155 */           c.reservedGlobally = (short)(c.reservedGlobally - am);
/*     */         }
/*     */       
/* 158 */       } else if (c.state == STATE_OTHER) {
/* 159 */         int am = (SETT.PATH()).finders.resource.pickup(c.res, c.path.destX(), c.path.destY(), c.reserved);
/* 160 */         FACTIONS.player().res().inc(c.res, (c.tType()).rtype, -am);
/* 161 */         c.amountCarried = (short)(c.amountCarried + am);
/* 162 */         c.reserved = (short)(c.reserved - am);
/* 163 */         c.reservedGlobally = (short)(c.reservedGlobally - am);
/*     */       } 
/*     */       
/* 166 */       c.reserved = 0;
/*     */     } 
/* 168 */     (SETT.HALFENTS()).caravans.withdrawals[c.res.index()].inc(c.tType(), -c.reservedGlobally);
/* 169 */     c.reservedGlobally = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(Caravan c) {
/* 175 */     (SETT.HALFENTS()).caravans.withdrawals[c.res.index()].inc(c.tType(), c.reservedGlobally);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box, Caravan c) {
/* 180 */     box.text(this.name);
/* 181 */     if (c.reservedGlobally - c.amountCarried > 0) {
/* 182 */       box.setResource(c.res, (c.reservedGlobally - c.amountCarried));
/* 183 */       box.text((c.tType()).name);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\caravan\TypeWithDraw.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
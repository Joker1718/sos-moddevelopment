/*     */ package settlement.thing.halfEntity.caravan;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.importt.ImportThingy;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ class TypeDeliver
/*     */   extends Type
/*     */ {
/*  17 */   private static short STATE_EXPORT = 0;
/*  18 */   private static short STATE_THRONE = 1;
/*  19 */   private static short STATE_RETURN = 2;
/*     */   
/*  21 */   static CharSequence ¤¤name = "¤delivering";
/*     */   static {
/*  23 */     D.ts(TypeDeliver.class);
/*     */   }
/*     */   TypeDeliver() {
/*  26 */     super(¤¤name);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean init(Caravan c, int amount) {
/*  31 */     c.amountCarried = (short)amount;
/*  32 */     c.reservedGlobally = (short)amount;
/*  33 */     c.state = STATE_EXPORT;
/*  34 */     c.reserved = 0;
/*  35 */     c.path.clear();
/*  36 */     (SETT.HALFENTS()).caravans.deliveries[c.res.index()].inc(c.tType(), amount);
/*     */     
/*  38 */     if (findImport(c)) {
/*  39 */       c.state = STATE_EXPORT;
/*  40 */       return true;
/*     */     } 
/*     */     
/*  43 */     if (findDump(c)) {
/*  44 */       c.state = STATE_THRONE;
/*  45 */       return true;
/*     */     } 
/*     */     
/*  48 */     (SETT.HALFENTS()).caravans.deliveries[c.res.index()].inc(c.tType(), -amount);
/*  49 */     return false;
/*     */   }
/*     */   
/*     */   private boolean findImport(Caravan c) {
/*  53 */     ImportThingy f = (SETT.ROOMS()).IMPORT.UNLOADER;
/*  54 */     COORDINATE coo = f.getReservableSpot(c.ctx(), c.cty(), c.res);
/*  55 */     if (coo != null) {
/*     */       
/*  57 */       int am = f.reservable(c.res, coo);
/*  58 */       if (am > c.amountCarried)
/*  59 */         am = c.amountCarried; 
/*  60 */       c.reserved = (short)am;
/*  61 */       f.reserve(c.res, coo, am);
/*  62 */       c.path.request(c.ctx(), c.cty(), coo.x(), coo.y(), false);
/*  63 */       if (c.path.isSuccessful()) {
/*  64 */         c.move();
/*  65 */         return true;
/*     */       } 
/*  67 */       f.reserve(c.res, coo, -am);
/*  68 */       c.reserved = 0;
/*     */     } 
/*     */     
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   private boolean findDump(Caravan c) {
/*  75 */     COORDINATE coo = (SETT.PATH()).finders.rndCoo.find(THRONE.coo().x(), THRONE.coo().y(), 8);
/*  76 */     c.path.request(c.ctx(), c.cty(), coo.x(), coo.y(), false);
/*     */     
/*  78 */     if (c.path.isSuccessful()) {
/*  79 */       c.move();
/*  80 */       return true;
/*     */     } 
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   private boolean findReturn(Caravan c) {
/*  86 */     if ((SETT.PATH()).finders.entryPoints.find(c.ctx(), c.cty(), c.path, 2147483647)) {
/*  87 */       c.move();
/*  88 */       return true;
/*     */     } 
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean deliverExport(Caravan c) {
/*  95 */     if (c.reserved <= 0) {
/*  96 */       return false;
/*     */     }
/*  98 */     ImportThingy f = (SETT.ROOMS()).IMPORT.UNLOADER;
/*  99 */     coo.set(c.path.destX(), c.path.destY());
/* 100 */     int am = f.reserved(c.res, (COORDINATE)coo);
/* 101 */     if (am <= 0) {
/* 102 */       c.reserved = 0;
/* 103 */       return false;
/*     */     } 
/*     */     
/* 106 */     f.finish(c.res, (COORDINATE)coo, 1, c.tType());
/* 107 */     c.amountCarried = (short)(c.amountCarried - 1);
/* 108 */     c.reserved = (short)(c.reserved - 1);
/* 109 */     (SETT.HALFENTS()).caravans.deliveries[c.res.index()].inc(c.tType(), -1);
/* 110 */     FACTIONS.player().res().inc(c.res(), (c.tType()).rtype, 1);
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update(Caravan c, double ds) {
/* 117 */     if (c.state == STATE_RETURN) {
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (c.amountCarried <= 0) {
/* 122 */       c.state = STATE_RETURN;
/* 123 */       if (findReturn(c))
/* 124 */         return true; 
/* 125 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 129 */     if (c.state == STATE_EXPORT) {
/*     */       
/* 131 */       if (deliverExport(c)) {
/* 132 */         return true;
/*     */       }
/* 134 */       if (c.amountCarried > 0) {
/* 135 */         if (findImport(c)) {
/* 136 */           return true;
/*     */         }
/* 138 */         c.state = STATE_THRONE;
/* 139 */         if (findDump(c)) {
/* 140 */           return true;
/*     */         }
/*     */       } 
/* 143 */       c.state = STATE_RETURN;
/* 144 */       if (findReturn(c))
/* 145 */         return true; 
/* 146 */       return false;
/*     */     } 
/* 148 */     if (c.state == STATE_THRONE) {
/* 149 */       (SETT.THINGS()).resources.create(c.ctx(), c.cty(), c.res, 1);
/* 150 */       FACTIONS.player().res().inc(c.res(), (c.tType()).rtype, 1);
/* 151 */       c.amountCarried = (short)(c.amountCarried - 1);
/* 152 */       (SETT.HALFENTS()).caravans.deliveries[c.res.index()].inc(c.tType(), -1);
/* 153 */       return true;
/*     */     } 
/* 155 */     throw new RuntimeException("state " + c.state);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel(Caravan c, boolean dump) {
/* 162 */     if (c.state == STATE_EXPORT && c.reserved > 0) {
/* 163 */       ImportThingy f = (SETT.ROOMS()).IMPORT.UNLOADER;
/* 164 */       int am = f.reserved(c.res, (COORDINATE)coo);
/* 165 */       am = CLAMP.i(am, 0, c.reserved);
/* 166 */       if (am > 0) {
/* 167 */         f.finish(c.res, (COORDINATE)coo, am, c.tType());
/* 168 */         c.amountCarried = (short)(c.amountCarried - am);
/*     */       } 
/* 170 */       c.reserved = 0;
/*     */     } 
/*     */     
/* 173 */     if (dump && c.amountCarried > 0) {
/* 174 */       (SETT.THINGS()).resources.createPrecise(c.ctx(), c.cty(), c.res, c.amountCarried);
/* 175 */       FACTIONS.player().res().inc(c.res(), (c.tType()).rtype, c.amountCarried);
/* 176 */       c.amountCarried = 0;
/*     */     } 
/* 178 */     (SETT.HALFENTS()).caravans.deliveries[c.res.index()].inc(c.tType(), -c.reservedGlobally);
/* 179 */     c.reservedGlobally = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box, Caravan c) {
/* 184 */     box.text(this.name);
/* 185 */     if (c.amountCarried > 0) {
/* 186 */       box.setResource(c.res, c.amountCarried);
/* 187 */       box.text((c.tType()).name);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(Caravan c) {
/* 193 */     (SETT.HALFENTS()).caravans.deliveries[c.res.index()].inc(c.tType(), c.reservedGlobally);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\caravan\TypeDeliver.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
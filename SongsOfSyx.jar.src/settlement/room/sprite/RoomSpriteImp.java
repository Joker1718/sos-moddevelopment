/*     */ package settlement.room.sprite;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.sprite.game.Sheets;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ public abstract class RoomSpriteImp implements RoomSprite {
/*     */   protected final Sheets[] sheets;
/*     */   public final boolean rotates;
/*     */   private int sData;
/*     */   protected double animationSpeed;
/*     */   
/*     */   public RoomSpriteImp(SheetType type, Json json, String key) throws IOException {
/*     */     int i;
/*  23 */     this.sData = 0;
/*  24 */     this.animationSpeed = 1.0D;
/*     */ 
/*     */     
/*  27 */     if (json.jsonsIs(key)) {
/*  28 */       Json[] js = json.jsons(key, 1);
/*  29 */       this.sheets = new Sheets[js.length];
/*  30 */       for (int k = 0; k < js.length; k++) {
/*  31 */         this.sheets[k] = new Sheets(type, js[k]);
/*     */       }
/*     */     } else {
/*  34 */       this.sheets = new Sheets[] {
/*  35 */           new Sheets(type, json.json(key))
/*     */         };
/*     */     } 
/*  38 */     boolean rot = false; byte b; int j; Sheets[] arrayOfSheets;
/*  39 */     for (j = (arrayOfSheets = this.sheets).length, b = 0; b < j; ) { Sheets s = arrayOfSheets[b];
/*  40 */       for (SheetPair ss : s.sheets)
/*  41 */         i = rot | ss.s.hasRotation & ss.d.rotates;  b++; }
/*     */     
/*  43 */     this.rotates = i;
/*     */   }
/*     */   public RoomSpriteImp(RoomSprite others) throws IOException {
/*     */     this.sData = 0;
/*     */     this.animationSpeed = 1.0D;
/*  48 */     RoomSpriteImp other = (RoomSpriteImp)others;
/*  49 */     if (other.type() != type())
/*  50 */       throw new RuntimeException(); 
/*  51 */     this.sheets = other.sheets;
/*  52 */     this.rotates = other.rotates;
/*  53 */     this.animationSpeed = other.animationSpeed;
/*     */   } public RoomSpriteImp(SheetType type) throws IOException {
/*     */     this.sData = 0;
/*     */     this.animationSpeed = 1.0D;
/*  57 */     this.sheets = new Sheets[] { new Sheets(type.dummy(), SheetData.DUMMY) };
/*  58 */     this.rotates = false;
/*  59 */     this.animationSpeed = 1.0D;
/*     */   }
/*     */   
/*     */   public Sheets sheet(RenderData.RenderIterator it) {
/*  63 */     if (this.sheets.length == 1)
/*  64 */       return this.sheets[0]; 
/*  65 */     Room r = (SETT.ROOMS()).map.get(it.tx(), it.ty());
/*  66 */     if (r == null)
/*  67 */       return this.sheets[0]; 
/*  68 */     return this.sheets[CLAMP.i(r.upgrade(it.tx(), it.ty()), 0, this.sheets.length - 1)];
/*     */   }
/*     */   
/*     */   public SheetPair sheetPair(RenderData.RenderIterator it, int ran) {
/*  72 */     Sheets a = sheet(it);
/*  73 */     if (a == null)
/*  74 */       return null; 
/*  75 */     return a.get(ran);
/*     */   }
/*     */   
/*     */   public SheetPair get(RenderData.RenderIterator it, int random) {
/*  79 */     Sheets a = sheet(it);
/*  80 */     if (a == null)
/*  81 */       return null; 
/*  82 */     return a.get(random);
/*     */   }
/*     */   
/*     */   public int frame(SheetPair a, RenderData.RenderIterator it) {
/*  86 */     if (a == null)
/*  87 */       return 0; 
/*  88 */     return a.d.frame(it.ran(), this.animationSpeed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean joins(int paramInt1, int paramInt2, int paramInt3, int paramInt4, DIR paramDIR, FurnisherItem paramFurnisherItem);
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {}
/*     */ 
/*     */   
/*     */   public int sData() {
/* 101 */     return this.sData;
/*     */   }
/*     */   
/*     */   public RoomSpriteImp sData(int d) {
/* 105 */     this.sData = d;
/* 106 */     return this;
/*     */   }
/*     */   
/*     */   public abstract SheetType type();
/*     */   
/*     */   protected int getData2(RenderData.RenderIterator it) {
/* 112 */     return (SETT.ROOMS()).fData.spriteData2.get(it.tile());
/*     */   }
/*     */   
/*     */   public void animate(double speed) {
/* 116 */     this.animationSpeed = speed;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSpriteImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
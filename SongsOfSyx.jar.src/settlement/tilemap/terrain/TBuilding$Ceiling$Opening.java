/*      */ package settlement.tilemap.terrain;
/*      */ 
/*      */ import settlement.main.SETT;
/*      */ import settlement.path.AVAILABILITY;
/*      */ import settlement.thing.pointlight.LOS;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.color.COLOR;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.sprite.TILE_SHEET;
/*      */ import util.rendering.RenderData;
/*      */ import util.rendering.ShadowBatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Opening
/*      */   extends TBuilding.BuildingComponent
/*      */   implements TerrainDiagonal.Diagonalizer
/*      */ {
/*      */   private static final int SET = 16;
/*      */   private final TILE_SHEET sheet;
/*      */   private final TILE_SHEET shadow;
/*  980 */   private final int CORNERS = 64;
/*  981 */   private final int SINGLES = 128;
/*  982 */   private final int DIA = 4096;
/*  983 */   private final int FAT = 8192;
/*      */   
/*      */   private Opening(String key, Terrain t) {
/*  986 */     super(key + "_OPENING", t, (TBuilding.Ceiling.access$0(paramCeiling)).structure.nameCeiling, (TBuilding.Ceiling.access$0(paramCeiling)).iconCeiling, (TBuilding.Ceiling.access$0(paramCeiling)).structure.miniColor, (TBuilding.Ceiling.access$0(paramCeiling)).structure.resource);
/*  987 */     this.sheet = (TBuilding.Ceiling.access$0(paramCeiling)).spriteOpening;
/*  988 */     this.shadow = (TBuilding.Ceiling.access$0(paramCeiling)).spriteWall;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean place(int x, int y) {
/*  993 */     if (!isPlacable(x, y)) {
/*  994 */       return TBuilding.Ceiling.this.place(x, y);
/*      */     }
/*      */     
/*  997 */     boolean dia = (this.shared.get(x, y) instanceof TerrainDiagonal.Diagonalizer && ((TerrainDiagonal.Diagonalizer)this.shared.get(x, y)).getDia(x, y));
/*  998 */     placeRaw(x, y);
/*      */     
/* 1000 */     int res = 0;
/*      */     
/* 1002 */     if (isFat(x, y)) {
/* 1003 */       res |= 0x2000;
/* 1004 */       for (DIR d : DIR.ORTHO) {
/* 1005 */         if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/* 1006 */           res |= d.mask() | d.next(2).mask(); 
/*      */       } 
/*      */     } else {
/* 1009 */       for (DIR d : DIR.ORTHO) {
/* 1010 */         if (!isFat(x + d.x(), y + d.y()) && joins(x, y, d)) {
/* 1011 */           res |= d.mask();
/*      */         }
/*      */       } 
/*      */     } 
/* 1015 */     int cor = 0;
/* 1016 */     for (DIR d : DIR.NORTHO) {
/* 1017 */       if (!joins(x, y, d) && (res & d.next(1).mask()) != 0 && (res & d.next(-1).mask()) != 0)
/* 1018 */         cor |= d.mask(); 
/*      */     } 
/* 1020 */     res |= cor << 8;
/*      */     
/* 1022 */     if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.N)) {
/* 1023 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.N);
/* 1024 */       if (t != this && t != (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall && t.wallIsWally() && !t.roofIs()) {
/* 1025 */         if ((res & DIR.NW.mask()) != 0)
/* 1026 */           res |= 0x20; 
/* 1027 */         if ((res & DIR.NE.mask()) != 0)
/* 1028 */           res |= 0x10; 
/*      */       } 
/*      */     } 
/* 1031 */     if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.W)) {
/* 1032 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.W);
/* 1033 */       if (t != this && t != (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall && t.wallIsWally() && !t.roofIs()) {
/* 1034 */         if ((res & DIR.SW.mask()) != 0)
/* 1035 */           res |= 0x80; 
/* 1036 */         if ((res & DIR.NW.mask()) != 0) {
/* 1037 */           res |= 0x40;
/*      */         }
/*      */       } 
/*      */     } 
/* 1041 */     this.shared.data.set(x, y, res);
/* 1042 */     setDia(x, y, dia);
/* 1043 */     return false;
/*      */   }
/*      */   
/*      */   private boolean isFat(int x, int y) {
/* 1047 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 1048 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 1049 */       if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/* 1050 */         return true; 
/*      */     } 
/* 1052 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 1059 */     int tile = data & 0xF;
/* 1060 */     int cor = data >> 8 & 0xF;
/* 1061 */     (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).structure.tint.color.bind();
/* 1062 */     if (tile == 0) {
/*      */ 
/*      */       
/* 1065 */       this.sheet.render(r, 128 + (i.ran() & 0xF), i.x(), i.y());
/* 1066 */       s.setHeight(3).setDistance2Ground(0.0D);
/* 1067 */       (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, 256, i.x(), i.y());
/*      */     }
/*      */     else {
/*      */       
/* 1071 */       int j = tile + (i.ran() & 0x1) * 16;
/* 1072 */       if (tile != 15 && (data & 0x1000) != 0)
/* 1073 */         j += 32; 
/* 1074 */       if (tile != 15)
/* 1075 */         this.sheet.render(r, j, i.x(), i.y()); 
/* 1076 */       s.setHeight(12).setDistance2Ground(0.0D);
/* 1077 */       if (tile == 15) {
/* 1078 */         (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, 272, i.x(), i.y());
/*      */       } else {
/* 1080 */         (TBuilding.Ceiling.access$0(TBuilding.Ceiling.this)).wall.getClass(); this.shadow.render((SPRITE_RENDERER)s, tile + (((data & 0x1000) != 0) ? 64 : 0), i.x(), i.y());
/*      */       } 
/* 1082 */       if (cor != 0) {
/* 1083 */         int c = cor + 64 + (((data & 0x2000) != 0) ? 16 : 0);
/* 1084 */         this.sheet.render(r, c + (((data & 0x1000) != 0) ? 32 : 0), i.x(), i.y());
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1092 */     COLOR.unbind();
/*      */     
/* 1094 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean joins(int tx, int ty, DIR d) {
/* 1099 */     return TBuilding.jwall.is(tx, ty, d);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 1105 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public AVAILABILITY getAvailability(int x, int y) {
/* 1110 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPlacable(int tx, int ty) {
/* 1116 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 1117 */       DIR d = (DIR)DIR.ALL.get(i);
/* 1118 */       if (!TBuilding.jwall.is(tx, ty, d)) {
/* 1119 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 1123 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean wallJoiner() {
/* 1128 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean wallIsWally() {
/* 1133 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean roofIs() {
/* 1138 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDia(int x, int y, boolean dia) {
/* 1143 */     if (!is(x, y))
/*      */       return; 
/* 1145 */     int data = this.shared.data.get(x, y);
/* 1146 */     if (dia) {
/* 1147 */       data |= 0x1000;
/*      */     } else {
/* 1149 */       data &= 0xFFFFEFFF;
/* 1150 */     }  this.shared.data.set(x, y, data);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getDia(int tx, int ty) {
/* 1155 */     if (!is(tx, ty))
/* 1156 */       return false; 
/* 1157 */     return ((this.shared.data.get(tx, ty) & 0x1000) != 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public int heightStart(int tx, int ty) {
/* 1162 */     return 3;
/*      */   }
/*      */ 
/*      */   
/*      */   public int heightEnd(int tx, int ty) {
/* 1167 */     return 5;
/*      */   }
/*      */ 
/*      */   
/*      */   public LOS los(int tx, int ty) {
/* 1172 */     return LOS.CEILING;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void unplace(int tx, int ty) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean wantsFloorUnderneath(int tx, int ty) {
/* 1183 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBuilding$Ceiling$Opening.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
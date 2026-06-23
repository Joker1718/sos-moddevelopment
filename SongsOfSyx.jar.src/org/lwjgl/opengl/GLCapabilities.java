/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.util.Set;
/*      */ import java.util.function.IntFunction;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.FunctionProvider;
/*      */ import org.lwjgl.system.ThreadLocalUtil;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class GLCapabilities
/*      */ {
/*      */   static final int ADDRESS_BUFFER_SIZE = 2236;
/*      */   public final long glEnable;
/*      */   public final long glDisable;
/*      */   public final long glAccum;
/*      */   public final long glAlphaFunc;
/*      */   public final long glAreTexturesResident;
/*      */   public final long glArrayElement;
/*      */   public final long glBegin;
/*      */   public final long glBindTexture;
/*      */   public final long glBitmap;
/*      */   public final long glBlendFunc;
/*      */   public final long glCallList;
/*      */   public final long glCallLists;
/*      */   public final long glClear;
/*      */   public final long glClearAccum;
/*      */   public final long glClearColor;
/*      */   public final long glClearDepth;
/*      */   public final long glClearIndex;
/*      */   public final long glClearStencil;
/*      */   public final long glClipPlane;
/*      */   public final long glColor3b;
/*      */   public final long glColor3s;
/*      */   public final long glColor3i;
/*      */   public final long glColor3f;
/*      */   public final long glColor3d;
/*      */   public final long glColor3ub;
/*      */   public final long glColor3us;
/*      */   public final long glColor3ui;
/*      */   public final long glColor3bv;
/*      */   public final long glColor3sv;
/*      */   public final long glColor3iv;
/*      */   public final long glColor3fv;
/*      */   public final long glColor3dv;
/*      */   public final long glColor3ubv;
/*      */   public final long glColor3usv;
/*      */   public final long glColor3uiv;
/*      */   public final long glColor4b;
/*      */   public final long glColor4s;
/*      */   public final long glColor4i;
/*      */   public final long glColor4f;
/*      */   public final long glColor4d;
/*      */   public final long glColor4ub;
/*      */   public final long glColor4us;
/*      */   public final long glColor4ui;
/*      */   public final long glColor4bv;
/*      */   public final long glColor4sv;
/*      */   public final long glColor4iv;
/*      */   public final long glColor4fv;
/*      */   public final long glColor4dv;
/*      */   public final long glColor4ubv;
/*      */   public final long glColor4usv;
/*      */   public final long glColor4uiv;
/*      */   public final long glColorMask;
/*      */   public final long glColorMaterial;
/*      */   public final long glColorPointer;
/*      */   public final long glCopyPixels;
/*      */   public final long glCullFace;
/*      */   public final long glDeleteLists;
/*      */   public final long glDepthFunc;
/*      */   public final long glDepthMask;
/*      */   public final long glDepthRange;
/*      */   public final long glDisableClientState;
/*      */   public final long glDrawArrays;
/*      */   public final long glDrawBuffer;
/*      */   public final long glDrawElements;
/*      */   public final long glDrawPixels;
/*      */   public final long glEdgeFlag;
/*      */   public final long glEdgeFlagv;
/*      */   public final long glEdgeFlagPointer;
/*      */   public final long glEnableClientState;
/*      */   public final long glEnd;
/*      */   public final long glEvalCoord1f;
/*      */   public final long glEvalCoord1fv;
/*      */   public final long glEvalCoord1d;
/*      */   public final long glEvalCoord1dv;
/*      */   public final long glEvalCoord2f;
/*      */   public final long glEvalCoord2fv;
/*      */   public final long glEvalCoord2d;
/*      */   public final long glEvalCoord2dv;
/*      */   public final long glEvalMesh1;
/*      */   public final long glEvalMesh2;
/*      */   public final long glEvalPoint1;
/*      */   public final long glEvalPoint2;
/*      */   public final long glFeedbackBuffer;
/*      */   public final long glFinish;
/*      */   public final long glFlush;
/*      */   public final long glFogi;
/*      */   public final long glFogiv;
/*      */   public final long glFogf;
/*      */   public final long glFogfv;
/*      */   public final long glFrontFace;
/*      */   public final long glGenLists;
/*      */   public final long glGenTextures;
/*      */   public final long glDeleteTextures;
/*      */   public final long glGetClipPlane;
/*      */   public final long glGetBooleanv;
/*      */   public final long glGetFloatv;
/*      */   public final long glGetIntegerv;
/*      */   public final long glGetDoublev;
/*      */   public final long glGetError;
/*      */   public final long glGetLightiv;
/*      */   public final long glGetLightfv;
/*      */   public final long glGetMapiv;
/*      */   public final long glGetMapfv;
/*      */   public final long glGetMapdv;
/*      */   public final long glGetMaterialiv;
/*      */   public final long glGetMaterialfv;
/*      */   public final long glGetPixelMapfv;
/*      */   public final long glGetPixelMapusv;
/*      */   public final long glGetPixelMapuiv;
/*      */   public final long glGetPointerv;
/*      */   public final long glGetPolygonStipple;
/*      */   public final long glGetString;
/*      */   public final long glGetTexEnviv;
/*      */   public final long glGetTexEnvfv;
/*      */   public final long glGetTexGeniv;
/*      */   public final long glGetTexGenfv;
/*      */   public final long glGetTexGendv;
/*      */   public final long glGetTexImage;
/*      */   public final long glGetTexLevelParameteriv;
/*      */   public final long glGetTexLevelParameterfv;
/*      */   public final long glGetTexParameteriv;
/*      */   public final long glGetTexParameterfv;
/*      */   public final long glHint;
/*      */   public final long glIndexi;
/*      */   public final long glIndexub;
/*      */   public final long glIndexs;
/*      */   public final long glIndexf;
/*      */   public final long glIndexd;
/*      */   public final long glIndexiv;
/*      */   public final long glIndexubv;
/*      */   public final long glIndexsv;
/*      */   public final long glIndexfv;
/*      */   public final long glIndexdv;
/*      */   public final long glIndexMask;
/*      */   public final long glIndexPointer;
/*      */   public final long glInitNames;
/*      */   public final long glInterleavedArrays;
/*      */   public final long glIsEnabled;
/*      */   public final long glIsList;
/*      */   public final long glIsTexture;
/*      */   public final long glLightModeli;
/*      */   public final long glLightModelf;
/*      */   public final long glLightModeliv;
/*      */   public final long glLightModelfv;
/*      */   public final long glLighti;
/*      */   public final long glLightf;
/*      */   public final long glLightiv;
/*      */   public final long glLightfv;
/*      */   public final long glLineStipple;
/*      */   public final long glLineWidth;
/*      */   public final long glListBase;
/*      */   public final long glLoadMatrixf;
/*      */   public final long glLoadMatrixd;
/*      */   public final long glLoadIdentity;
/*      */   public final long glLoadName;
/*      */   public final long glLogicOp;
/*      */   public final long glMap1f;
/*      */   public final long glMap1d;
/*      */   public final long glMap2f;
/*      */   public final long glMap2d;
/*      */   public final long glMapGrid1f;
/*      */   public final long glMapGrid1d;
/*      */   public final long glMapGrid2f;
/*      */   public final long glMapGrid2d;
/*      */   public final long glMateriali;
/*      */   public final long glMaterialf;
/*      */   public final long glMaterialiv;
/*      */   public final long glMaterialfv;
/*      */   public final long glMatrixMode;
/*      */   public final long glMultMatrixf;
/*      */   public final long glMultMatrixd;
/*      */   public final long glFrustum;
/*      */   public final long glNewList;
/*      */   public final long glEndList;
/*      */   public final long glNormal3f;
/*      */   public final long glNormal3b;
/*      */   public final long glNormal3s;
/*      */   public final long glNormal3i;
/*      */   public final long glNormal3d;
/*      */   public final long glNormal3fv;
/*      */   public final long glNormal3bv;
/*      */   public final long glNormal3sv;
/*      */   public final long glNormal3iv;
/*      */   public final long glNormal3dv;
/*      */   public final long glNormalPointer;
/*      */   public final long glOrtho;
/*      */   public final long glPassThrough;
/*      */   public final long glPixelMapfv;
/*      */   public final long glPixelMapusv;
/*      */   public final long glPixelMapuiv;
/*      */   public final long glPixelStorei;
/*      */   public final long glPixelStoref;
/*      */   public final long glPixelTransferi;
/*      */   public final long glPixelTransferf;
/*      */   public final long glPixelZoom;
/*      */   public final long glPointSize;
/*      */   public final long glPolygonMode;
/*      */   public final long glPolygonOffset;
/*      */   public final long glPolygonStipple;
/*      */   public final long glPushAttrib;
/*      */   public final long glPushClientAttrib;
/*      */   public final long glPopAttrib;
/*      */   public final long glPopClientAttrib;
/*      */   public final long glPopMatrix;
/*      */   public final long glPopName;
/*      */   public final long glPrioritizeTextures;
/*      */   public final long glPushMatrix;
/*      */   public final long glPushName;
/*      */   public final long glRasterPos2i;
/*      */   public final long glRasterPos2s;
/*      */   public final long glRasterPos2f;
/*      */   public final long glRasterPos2d;
/*      */   public final long glRasterPos2iv;
/*      */   public final long glRasterPos2sv;
/*      */   public final long glRasterPos2fv;
/*      */   public final long glRasterPos2dv;
/*      */   public final long glRasterPos3i;
/*      */   public final long glRasterPos3s;
/*      */   public final long glRasterPos3f;
/*      */   public final long glRasterPos3d;
/*      */   public final long glRasterPos3iv;
/*      */   public final long glRasterPos3sv;
/*      */   public final long glRasterPos3fv;
/*      */   public final long glRasterPos3dv;
/*      */   public final long glRasterPos4i;
/*      */   public final long glRasterPos4s;
/*      */   public final long glRasterPos4f;
/*      */   public final long glRasterPos4d;
/*      */   public final long glRasterPos4iv;
/*      */   public final long glRasterPos4sv;
/*      */   public final long glRasterPos4fv;
/*      */   public final long glRasterPos4dv;
/*      */   public final long glReadBuffer;
/*      */   public final long glReadPixels;
/*      */   public final long glRecti;
/*      */   public final long glRects;
/*      */   public final long glRectf;
/*      */   public final long glRectd;
/*      */   public final long glRectiv;
/*      */   public final long glRectsv;
/*      */   public final long glRectfv;
/*      */   public final long glRectdv;
/*      */   public final long glRenderMode;
/*      */   public final long glRotatef;
/*      */   public final long glRotated;
/*      */   public final long glScalef;
/*      */   public final long glScaled;
/*      */   public final long glScissor;
/*      */   public final long glSelectBuffer;
/*      */   public final long glShadeModel;
/*      */   public final long glStencilFunc;
/*      */   public final long glStencilMask;
/*      */   public final long glStencilOp;
/*      */   public final long glTexCoord1f;
/*      */   public final long glTexCoord1s;
/*      */   public final long glTexCoord1i;
/*      */   public final long glTexCoord1d;
/*      */   public final long glTexCoord1fv;
/*      */   public final long glTexCoord1sv;
/*      */   public final long glTexCoord1iv;
/*      */   public final long glTexCoord1dv;
/*      */   public final long glTexCoord2f;
/*      */   public final long glTexCoord2s;
/*      */   public final long glTexCoord2i;
/*      */   public final long glTexCoord2d;
/*      */   public final long glTexCoord2fv;
/*      */   public final long glTexCoord2sv;
/*      */   public final long glTexCoord2iv;
/*      */   public final long glTexCoord2dv;
/*      */   public final long glTexCoord3f;
/*      */   public final long glTexCoord3s;
/*      */   public final long glTexCoord3i;
/*      */   public final long glTexCoord3d;
/*      */   public final long glTexCoord3fv;
/*      */   public final long glTexCoord3sv;
/*      */   public final long glTexCoord3iv;
/*      */   public final long glTexCoord3dv;
/*      */   public final long glTexCoord4f;
/*      */   public final long glTexCoord4s;
/*      */   public final long glTexCoord4i;
/*      */   public final long glTexCoord4d;
/*      */   public final long glTexCoord4fv;
/*      */   public final long glTexCoord4sv;
/*      */   public final long glTexCoord4iv;
/*      */   public final long glTexCoord4dv;
/*      */   public final long glTexCoordPointer;
/*      */   public final long glTexEnvi;
/*      */   public final long glTexEnviv;
/*      */   public final long glTexEnvf;
/*      */   public final long glTexEnvfv;
/*      */   public final long glTexGeni;
/*      */   public final long glTexGeniv;
/*      */   public final long glTexGenf;
/*      */   public final long glTexGenfv;
/*      */   public final long glTexGend;
/*      */   public final long glTexGendv;
/*      */   public final long glTexImage1D;
/*      */   public final long glTexImage2D;
/*      */   public final long glCopyTexImage1D;
/*      */   public final long glCopyTexImage2D;
/*      */   public final long glCopyTexSubImage1D;
/*      */   public final long glCopyTexSubImage2D;
/*      */   public final long glTexParameteri;
/*      */   public final long glTexParameteriv;
/*      */   public final long glTexParameterf;
/*      */   public final long glTexParameterfv;
/*      */   public final long glTexSubImage1D;
/*      */   public final long glTexSubImage2D;
/*      */   public final long glTranslatef;
/*      */   public final long glTranslated;
/*      */   public final long glVertex2f;
/*      */   public final long glVertex2s;
/*      */   public final long glVertex2i;
/*      */   public final long glVertex2d;
/*      */   public final long glVertex2fv;
/*      */   public final long glVertex2sv;
/*      */   public final long glVertex2iv;
/*      */   public final long glVertex2dv;
/*      */   public final long glVertex3f;
/*      */   public final long glVertex3s;
/*      */   public final long glVertex3i;
/*      */   public final long glVertex3d;
/*      */   public final long glVertex3fv;
/*      */   public final long glVertex3sv;
/*      */   public final long glVertex3iv;
/*      */   public final long glVertex3dv;
/*      */   public final long glVertex4f;
/*      */   public final long glVertex4s;
/*      */   public final long glVertex4i;
/*      */   public final long glVertex4d;
/*      */   public final long glVertex4fv;
/*      */   public final long glVertex4sv;
/*      */   public final long glVertex4iv;
/*      */   public final long glVertex4dv;
/*      */   public final long glVertexPointer;
/*      */   public final long glViewport;
/*      */   public final long glTexImage3D;
/*      */   public final long glTexSubImage3D;
/*      */   public final long glCopyTexSubImage3D;
/*      */   public final long glDrawRangeElements;
/*      */   public final long glCompressedTexImage3D;
/*      */   public final long glCompressedTexImage2D;
/*      */   public final long glCompressedTexImage1D;
/*      */   public final long glCompressedTexSubImage3D;
/*      */   public final long glCompressedTexSubImage2D;
/*      */   public final long glCompressedTexSubImage1D;
/*      */   public final long glGetCompressedTexImage;
/*      */   public final long glSampleCoverage;
/*      */   public final long glActiveTexture;
/*      */   public final long glClientActiveTexture;
/*      */   public final long glMultiTexCoord1f;
/*      */   public final long glMultiTexCoord1s;
/*      */   public final long glMultiTexCoord1i;
/*      */   public final long glMultiTexCoord1d;
/*      */   public final long glMultiTexCoord1fv;
/*      */   public final long glMultiTexCoord1sv;
/*      */   public final long glMultiTexCoord1iv;
/*      */   public final long glMultiTexCoord1dv;
/*      */   public final long glMultiTexCoord2f;
/*      */   public final long glMultiTexCoord2s;
/*      */   public final long glMultiTexCoord2i;
/*      */   public final long glMultiTexCoord2d;
/*      */   public final long glMultiTexCoord2fv;
/*      */   public final long glMultiTexCoord2sv;
/*      */   public final long glMultiTexCoord2iv;
/*      */   public final long glMultiTexCoord2dv;
/*      */   public final long glMultiTexCoord3f;
/*      */   public final long glMultiTexCoord3s;
/*      */   public final long glMultiTexCoord3i;
/*      */   public final long glMultiTexCoord3d;
/*      */   public final long glMultiTexCoord3fv;
/*      */   public final long glMultiTexCoord3sv;
/*      */   public final long glMultiTexCoord3iv;
/*      */   public final long glMultiTexCoord3dv;
/*      */   public final long glMultiTexCoord4f;
/*      */   public final long glMultiTexCoord4s;
/*      */   public final long glMultiTexCoord4i;
/*      */   public final long glMultiTexCoord4d;
/*      */   public final long glMultiTexCoord4fv;
/*      */   public final long glMultiTexCoord4sv;
/*      */   public final long glMultiTexCoord4iv;
/*      */   public final long glMultiTexCoord4dv;
/*      */   public final long glLoadTransposeMatrixf;
/*      */   public final long glLoadTransposeMatrixd;
/*      */   public final long glMultTransposeMatrixf;
/*      */   public final long glMultTransposeMatrixd;
/*      */   public final long glBlendColor;
/*      */   public final long glBlendEquation;
/*      */   public final long glFogCoordf;
/*      */   public final long glFogCoordd;
/*      */   public final long glFogCoordfv;
/*      */   public final long glFogCoorddv;
/*      */   public final long glFogCoordPointer;
/*      */   public final long glMultiDrawArrays;
/*      */   public final long glMultiDrawElements;
/*      */   public final long glPointParameterf;
/*      */   public final long glPointParameteri;
/*      */   public final long glPointParameterfv;
/*      */   public final long glPointParameteriv;
/*      */   public final long glSecondaryColor3b;
/*      */   public final long glSecondaryColor3s;
/*      */   public final long glSecondaryColor3i;
/*      */   public final long glSecondaryColor3f;
/*      */   public final long glSecondaryColor3d;
/*      */   public final long glSecondaryColor3ub;
/*      */   public final long glSecondaryColor3us;
/*      */   public final long glSecondaryColor3ui;
/*      */   public final long glSecondaryColor3bv;
/*      */   public final long glSecondaryColor3sv;
/*      */   public final long glSecondaryColor3iv;
/*      */   public final long glSecondaryColor3fv;
/*      */   public final long glSecondaryColor3dv;
/*      */   public final long glSecondaryColor3ubv;
/*      */   public final long glSecondaryColor3usv;
/*      */   public final long glSecondaryColor3uiv;
/*      */   public final long glSecondaryColorPointer;
/*      */   public final long glBlendFuncSeparate;
/*      */   public final long glWindowPos2i;
/*      */   public final long glWindowPos2s;
/*      */   public final long glWindowPos2f;
/*      */   public final long glWindowPos2d;
/*      */   public final long glWindowPos2iv;
/*      */   public final long glWindowPos2sv;
/*      */   public final long glWindowPos2fv;
/*      */   public final long glWindowPos2dv;
/*      */   public final long glWindowPos3i;
/*      */   public final long glWindowPos3s;
/*      */   public final long glWindowPos3f;
/*      */   public final long glWindowPos3d;
/*      */   public final long glWindowPos3iv;
/*      */   public final long glWindowPos3sv;
/*      */   public final long glWindowPos3fv;
/*      */   public final long glWindowPos3dv;
/*      */   public final long glBindBuffer;
/*      */   public final long glDeleteBuffers;
/*      */   public final long glGenBuffers;
/*      */   public final long glIsBuffer;
/*      */   public final long glBufferData;
/*      */   public final long glBufferSubData;
/*      */   public final long glGetBufferSubData;
/*      */   public final long glMapBuffer;
/*      */   public final long glUnmapBuffer;
/*      */   public final long glGetBufferParameteriv;
/*      */   public final long glGetBufferPointerv;
/*      */   public final long glGenQueries;
/*      */   public final long glDeleteQueries;
/*      */   public final long glIsQuery;
/*      */   public final long glBeginQuery;
/*      */   public final long glEndQuery;
/*      */   public final long glGetQueryiv;
/*      */   public final long glGetQueryObjectiv;
/*      */   public final long glGetQueryObjectuiv;
/*      */   public final long glCreateProgram;
/*      */   public final long glDeleteProgram;
/*      */   public final long glIsProgram;
/*      */   public final long glCreateShader;
/*      */   public final long glDeleteShader;
/*      */   public final long glIsShader;
/*      */   public final long glAttachShader;
/*      */   public final long glDetachShader;
/*      */   public final long glShaderSource;
/*      */   public final long glCompileShader;
/*      */   public final long glLinkProgram;
/*      */   public final long glUseProgram;
/*      */   public final long glValidateProgram;
/*      */   public final long glUniform1f;
/*      */   public final long glUniform2f;
/*      */   public final long glUniform3f;
/*      */   public final long glUniform4f;
/*      */   public final long glUniform1i;
/*      */   public final long glUniform2i;
/*      */   public final long glUniform3i;
/*      */   public final long glUniform4i;
/*      */   public final long glUniform1fv;
/*      */   public final long glUniform2fv;
/*      */   public final long glUniform3fv;
/*      */   public final long glUniform4fv;
/*      */   public final long glUniform1iv;
/*      */   public final long glUniform2iv;
/*      */   public final long glUniform3iv;
/*      */   public final long glUniform4iv;
/*      */   public final long glUniformMatrix2fv;
/*      */   public final long glUniformMatrix3fv;
/*      */   public final long glUniformMatrix4fv;
/*      */   public final long glGetShaderiv;
/*      */   public final long glGetProgramiv;
/*      */   public final long glGetShaderInfoLog;
/*      */   public final long glGetProgramInfoLog;
/*      */   public final long glGetAttachedShaders;
/*      */   public final long glGetUniformLocation;
/*      */   public final long glGetActiveUniform;
/*      */   public final long glGetUniformfv;
/*      */   public final long glGetUniformiv;
/*      */   public final long glGetShaderSource;
/*      */   public final long glVertexAttrib1f;
/*      */   public final long glVertexAttrib1s;
/*      */   public final long glVertexAttrib1d;
/*      */   public final long glVertexAttrib2f;
/*      */   public final long glVertexAttrib2s;
/*      */   public final long glVertexAttrib2d;
/*      */   public final long glVertexAttrib3f;
/*      */   public final long glVertexAttrib3s;
/*      */   public final long glVertexAttrib3d;
/*      */   public final long glVertexAttrib4f;
/*      */   public final long glVertexAttrib4s;
/*      */   public final long glVertexAttrib4d;
/*      */   public final long glVertexAttrib4Nub;
/*      */   public final long glVertexAttrib1fv;
/*      */   public final long glVertexAttrib1sv;
/*      */   public final long glVertexAttrib1dv;
/*      */   public final long glVertexAttrib2fv;
/*      */   public final long glVertexAttrib2sv;
/*      */   public final long glVertexAttrib2dv;
/*      */   public final long glVertexAttrib3fv;
/*      */   public final long glVertexAttrib3sv;
/*      */   public final long glVertexAttrib3dv;
/*      */   public final long glVertexAttrib4fv;
/*      */   public final long glVertexAttrib4sv;
/*      */   public final long glVertexAttrib4dv;
/*      */   public final long glVertexAttrib4iv;
/*      */   public final long glVertexAttrib4bv;
/*      */   public final long glVertexAttrib4ubv;
/*      */   public final long glVertexAttrib4usv;
/*      */   public final long glVertexAttrib4uiv;
/*      */   public final long glVertexAttrib4Nbv;
/*      */   public final long glVertexAttrib4Nsv;
/*      */   public final long glVertexAttrib4Niv;
/*      */   public final long glVertexAttrib4Nubv;
/*      */   public final long glVertexAttrib4Nusv;
/*      */   public final long glVertexAttrib4Nuiv;
/*      */   public final long glVertexAttribPointer;
/*      */   public final long glEnableVertexAttribArray;
/*      */   public final long glDisableVertexAttribArray;
/*      */   public final long glBindAttribLocation;
/*      */   public final long glGetActiveAttrib;
/*      */   public final long glGetAttribLocation;
/*      */   public final long glGetVertexAttribiv;
/*      */   public final long glGetVertexAttribfv;
/*      */   public final long glGetVertexAttribdv;
/*      */   public final long glGetVertexAttribPointerv;
/*      */   public final long glDrawBuffers;
/*      */   public final long glBlendEquationSeparate;
/*      */   public final long glStencilOpSeparate;
/*      */   public final long glStencilFuncSeparate;
/*      */   public final long glStencilMaskSeparate;
/*      */   public final long glUniformMatrix2x3fv;
/*      */   public final long glUniformMatrix3x2fv;
/*      */   public final long glUniformMatrix2x4fv;
/*      */   public final long glUniformMatrix4x2fv;
/*      */   public final long glUniformMatrix3x4fv;
/*      */   public final long glUniformMatrix4x3fv;
/*      */   public final long glGetStringi;
/*      */   public final long glClearBufferiv;
/*      */   public final long glClearBufferuiv;
/*      */   public final long glClearBufferfv;
/*      */   public final long glClearBufferfi;
/*      */   public final long glVertexAttribI1i;
/*      */   public final long glVertexAttribI2i;
/*      */   public final long glVertexAttribI3i;
/*      */   public final long glVertexAttribI4i;
/*      */   public final long glVertexAttribI1ui;
/*      */   public final long glVertexAttribI2ui;
/*      */   public final long glVertexAttribI3ui;
/*      */   public final long glVertexAttribI4ui;
/*      */   public final long glVertexAttribI1iv;
/*      */   public final long glVertexAttribI2iv;
/*      */   public final long glVertexAttribI3iv;
/*      */   public final long glVertexAttribI4iv;
/*      */   public final long glVertexAttribI1uiv;
/*      */   public final long glVertexAttribI2uiv;
/*      */   public final long glVertexAttribI3uiv;
/*      */   public final long glVertexAttribI4uiv;
/*      */   public final long glVertexAttribI4bv;
/*      */   public final long glVertexAttribI4sv;
/*      */   public final long glVertexAttribI4ubv;
/*      */   public final long glVertexAttribI4usv;
/*      */   public final long glVertexAttribIPointer;
/*      */   public final long glGetVertexAttribIiv;
/*      */   public final long glGetVertexAttribIuiv;
/*      */   public final long glUniform1ui;
/*      */   public final long glUniform2ui;
/*      */   public final long glUniform3ui;
/*      */   public final long glUniform4ui;
/*      */   public final long glUniform1uiv;
/*      */   public final long glUniform2uiv;
/*      */   public final long glUniform3uiv;
/*      */   public final long glUniform4uiv;
/*      */   public final long glGetUniformuiv;
/*      */   public final long glBindFragDataLocation;
/*      */   public final long glGetFragDataLocation;
/*      */   public final long glBeginConditionalRender;
/*      */   public final long glEndConditionalRender;
/*      */   public final long glMapBufferRange;
/*      */   public final long glFlushMappedBufferRange;
/*      */   public final long glClampColor;
/*      */   public final long glIsRenderbuffer;
/*      */   public final long glBindRenderbuffer;
/*      */   public final long glDeleteRenderbuffers;
/*      */   public final long glGenRenderbuffers;
/*      */   public final long glRenderbufferStorage;
/*      */   public final long glRenderbufferStorageMultisample;
/*      */   public final long glGetRenderbufferParameteriv;
/*      */   public final long glIsFramebuffer;
/*      */   public final long glBindFramebuffer;
/*      */   public final long glDeleteFramebuffers;
/*      */   public final long glGenFramebuffers;
/*      */   public final long glCheckFramebufferStatus;
/*      */   public final long glFramebufferTexture1D;
/*      */   public final long glFramebufferTexture2D;
/*      */   public final long glFramebufferTexture3D;
/*      */   public final long glFramebufferTextureLayer;
/*      */   public final long glFramebufferRenderbuffer;
/*      */   public final long glGetFramebufferAttachmentParameteriv;
/*      */   public final long glBlitFramebuffer;
/*      */   public final long glGenerateMipmap;
/*      */   public final long glTexParameterIiv;
/*      */   public final long glTexParameterIuiv;
/*      */   public final long glGetTexParameterIiv;
/*      */   public final long glGetTexParameterIuiv;
/*      */   public final long glColorMaski;
/*      */   public final long glGetBooleani_v;
/*      */   public final long glGetIntegeri_v;
/*      */   public final long glEnablei;
/*      */   public final long glDisablei;
/*      */   public final long glIsEnabledi;
/*      */   public final long glBindBufferRange;
/*      */   public final long glBindBufferBase;
/*      */   public final long glBeginTransformFeedback;
/*      */   public final long glEndTransformFeedback;
/*      */   public final long glTransformFeedbackVaryings;
/*      */   public final long glGetTransformFeedbackVarying;
/*      */   public final long glBindVertexArray;
/*      */   public final long glDeleteVertexArrays;
/*      */   public final long glGenVertexArrays;
/*      */   public final long glIsVertexArray;
/*      */   public final long glDrawArraysInstanced;
/*      */   public final long glDrawElementsInstanced;
/*      */   public final long glCopyBufferSubData;
/*      */   public final long glPrimitiveRestartIndex;
/*      */   public final long glTexBuffer;
/*      */   public final long glGetUniformIndices;
/*      */   public final long glGetActiveUniformsiv;
/*      */   public final long glGetActiveUniformName;
/*      */   public final long glGetUniformBlockIndex;
/*      */   public final long glGetActiveUniformBlockiv;
/*      */   public final long glGetActiveUniformBlockName;
/*      */   public final long glUniformBlockBinding;
/*      */   public final long glGetBufferParameteri64v;
/*      */   public final long glDrawElementsBaseVertex;
/*      */   public final long glDrawRangeElementsBaseVertex;
/*      */   public final long glDrawElementsInstancedBaseVertex;
/*      */   public final long glMultiDrawElementsBaseVertex;
/*      */   public final long glProvokingVertex;
/*      */   public final long glTexImage2DMultisample;
/*      */   public final long glTexImage3DMultisample;
/*      */   public final long glGetMultisamplefv;
/*      */   public final long glSampleMaski;
/*      */   public final long glFramebufferTexture;
/*      */   public final long glFenceSync;
/*      */   public final long glIsSync;
/*      */   public final long glDeleteSync;
/*      */   public final long glClientWaitSync;
/*      */   public final long glWaitSync;
/*      */   public final long glGetInteger64v;
/*      */   public final long glGetInteger64i_v;
/*      */   public final long glGetSynciv;
/*      */   public final long glBindFragDataLocationIndexed;
/*      */   public final long glGetFragDataIndex;
/*      */   public final long glGenSamplers;
/*      */   public final long glDeleteSamplers;
/*      */   public final long glIsSampler;
/*      */   public final long glBindSampler;
/*      */   public final long glSamplerParameteri;
/*      */   public final long glSamplerParameterf;
/*      */   public final long glSamplerParameteriv;
/*      */   public final long glSamplerParameterfv;
/*      */   public final long glSamplerParameterIiv;
/*      */   public final long glSamplerParameterIuiv;
/*      */   public final long glGetSamplerParameteriv;
/*      */   public final long glGetSamplerParameterfv;
/*      */   public final long glGetSamplerParameterIiv;
/*      */   public final long glGetSamplerParameterIuiv;
/*      */   public final long glQueryCounter;
/*      */   public final long glGetQueryObjecti64v;
/*      */   public final long glGetQueryObjectui64v;
/*      */   public final long glVertexAttribDivisor;
/*      */   public final long glVertexP2ui;
/*      */   public final long glVertexP3ui;
/*      */   public final long glVertexP4ui;
/*      */   public final long glVertexP2uiv;
/*      */   public final long glVertexP3uiv;
/*      */   public final long glVertexP4uiv;
/*      */   public final long glTexCoordP1ui;
/*      */   public final long glTexCoordP2ui;
/*      */   public final long glTexCoordP3ui;
/*      */   public final long glTexCoordP4ui;
/*      */   public final long glTexCoordP1uiv;
/*      */   public final long glTexCoordP2uiv;
/*      */   public final long glTexCoordP3uiv;
/*      */   public final long glTexCoordP4uiv;
/*      */   public final long glMultiTexCoordP1ui;
/*      */   public final long glMultiTexCoordP2ui;
/*      */   public final long glMultiTexCoordP3ui;
/*      */   public final long glMultiTexCoordP4ui;
/*      */   public final long glMultiTexCoordP1uiv;
/*      */   public final long glMultiTexCoordP2uiv;
/*      */   public final long glMultiTexCoordP3uiv;
/*      */   public final long glMultiTexCoordP4uiv;
/*      */   public final long glNormalP3ui;
/*      */   public final long glNormalP3uiv;
/*      */   public final long glColorP3ui;
/*      */   public final long glColorP4ui;
/*      */   public final long glColorP3uiv;
/*      */   public final long glColorP4uiv;
/*      */   public final long glSecondaryColorP3ui;
/*      */   public final long glSecondaryColorP3uiv;
/*      */   public final long glVertexAttribP1ui;
/*      */   public final long glVertexAttribP2ui;
/*      */   public final long glVertexAttribP3ui;
/*      */   public final long glVertexAttribP4ui;
/*      */   public final long glVertexAttribP1uiv;
/*      */   public final long glVertexAttribP2uiv;
/*      */   public final long glVertexAttribP3uiv;
/*      */   public final long glVertexAttribP4uiv;
/*      */   public final long glBlendEquationi;
/*      */   public final long glBlendEquationSeparatei;
/*      */   public final long glBlendFunci;
/*      */   public final long glBlendFuncSeparatei;
/*      */   public final long glDrawArraysIndirect;
/*      */   public final long glDrawElementsIndirect;
/*      */   public final long glUniform1d;
/*      */   public final long glUniform2d;
/*      */   public final long glUniform3d;
/*      */   public final long glUniform4d;
/*      */   public final long glUniform1dv;
/*      */   public final long glUniform2dv;
/*      */   public final long glUniform3dv;
/*      */   public final long glUniform4dv;
/*      */   public final long glUniformMatrix2dv;
/*      */   public final long glUniformMatrix3dv;
/*      */   public final long glUniformMatrix4dv;
/*      */   public final long glUniformMatrix2x3dv;
/*      */   public final long glUniformMatrix2x4dv;
/*      */   public final long glUniformMatrix3x2dv;
/*      */   public final long glUniformMatrix3x4dv;
/*      */   public final long glUniformMatrix4x2dv;
/*      */   public final long glUniformMatrix4x3dv;
/*      */   public final long glGetUniformdv;
/*      */   public final long glMinSampleShading;
/*      */   public final long glGetSubroutineUniformLocation;
/*      */   public final long glGetSubroutineIndex;
/*      */   public final long glGetActiveSubroutineUniformiv;
/*      */   public final long glGetActiveSubroutineUniformName;
/*      */   public final long glGetActiveSubroutineName;
/*      */   public final long glUniformSubroutinesuiv;
/*      */   public final long glGetUniformSubroutineuiv;
/*      */   public final long glGetProgramStageiv;
/*      */   public final long glPatchParameteri;
/*      */   public final long glPatchParameterfv;
/*      */   public final long glBindTransformFeedback;
/*      */   public final long glDeleteTransformFeedbacks;
/*      */   public final long glGenTransformFeedbacks;
/*      */   public final long glIsTransformFeedback;
/*      */   public final long glPauseTransformFeedback;
/*      */   public final long glResumeTransformFeedback;
/*      */   public final long glDrawTransformFeedback;
/*      */   public final long glDrawTransformFeedbackStream;
/*      */   public final long glBeginQueryIndexed;
/*      */   public final long glEndQueryIndexed;
/*      */   public final long glGetQueryIndexediv;
/*      */   public final long glReleaseShaderCompiler;
/*      */   public final long glShaderBinary;
/*      */   public final long glGetShaderPrecisionFormat;
/*      */   public final long glDepthRangef;
/*      */   public final long glClearDepthf;
/*      */   public final long glGetProgramBinary;
/*      */   public final long glProgramBinary;
/*      */   public final long glProgramParameteri;
/*      */   public final long glUseProgramStages;
/*      */   public final long glActiveShaderProgram;
/*      */   public final long glCreateShaderProgramv;
/*      */   public final long glBindProgramPipeline;
/*      */   public final long glDeleteProgramPipelines;
/*      */   public final long glGenProgramPipelines;
/*      */   public final long glIsProgramPipeline;
/*      */   public final long glGetProgramPipelineiv;
/*      */   public final long glProgramUniform1i;
/*      */   public final long glProgramUniform2i;
/*      */   public final long glProgramUniform3i;
/*      */   public final long glProgramUniform4i;
/*      */   public final long glProgramUniform1ui;
/*      */   public final long glProgramUniform2ui;
/*      */   public final long glProgramUniform3ui;
/*      */   public final long glProgramUniform4ui;
/*      */   public final long glProgramUniform1f;
/*      */   public final long glProgramUniform2f;
/*      */   public final long glProgramUniform3f;
/*      */   public final long glProgramUniform4f;
/*      */   public final long glProgramUniform1d;
/*      */   public final long glProgramUniform2d;
/*      */   public final long glProgramUniform3d;
/*      */   public final long glProgramUniform4d;
/*      */   public final long glProgramUniform1iv;
/*      */   public final long glProgramUniform2iv;
/*      */   public final long glProgramUniform3iv;
/*      */   public final long glProgramUniform4iv;
/*      */   public final long glProgramUniform1uiv;
/*      */   public final long glProgramUniform2uiv;
/*      */   public final long glProgramUniform3uiv;
/*      */   public final long glProgramUniform4uiv;
/*      */   public final long glProgramUniform1fv;
/*      */   public final long glProgramUniform2fv;
/*      */   public final long glProgramUniform3fv;
/*      */   public final long glProgramUniform4fv;
/*      */   public final long glProgramUniform1dv;
/*      */   public final long glProgramUniform2dv;
/*      */   public final long glProgramUniform3dv;
/*      */   public final long glProgramUniform4dv;
/*      */   public final long glProgramUniformMatrix2fv;
/*      */   public final long glProgramUniformMatrix3fv;
/*      */   public final long glProgramUniformMatrix4fv;
/*      */   public final long glProgramUniformMatrix2dv;
/*      */   public final long glProgramUniformMatrix3dv;
/*      */   public final long glProgramUniformMatrix4dv;
/*      */   public final long glProgramUniformMatrix2x3fv;
/*      */   public final long glProgramUniformMatrix3x2fv;
/*      */   public final long glProgramUniformMatrix2x4fv;
/*      */   public final long glProgramUniformMatrix4x2fv;
/*      */   public final long glProgramUniformMatrix3x4fv;
/*      */   public final long glProgramUniformMatrix4x3fv;
/*      */   public final long glProgramUniformMatrix2x3dv;
/*      */   public final long glProgramUniformMatrix3x2dv;
/*      */   public final long glProgramUniformMatrix2x4dv;
/*      */   public final long glProgramUniformMatrix4x2dv;
/*      */   public final long glProgramUniformMatrix3x4dv;
/*      */   public final long glProgramUniformMatrix4x3dv;
/*      */   public final long glValidateProgramPipeline;
/*      */   public final long glGetProgramPipelineInfoLog;
/*      */   public final long glVertexAttribL1d;
/*      */   public final long glVertexAttribL2d;
/*      */   public final long glVertexAttribL3d;
/*      */   public final long glVertexAttribL4d;
/*      */   public final long glVertexAttribL1dv;
/*      */   public final long glVertexAttribL2dv;
/*      */   public final long glVertexAttribL3dv;
/*      */   public final long glVertexAttribL4dv;
/*      */   public final long glVertexAttribLPointer;
/*      */   public final long glGetVertexAttribLdv;
/*      */   public final long glViewportArrayv;
/*      */   public final long glViewportIndexedf;
/*      */   public final long glViewportIndexedfv;
/*      */   public final long glScissorArrayv;
/*      */   public final long glScissorIndexed;
/*      */   public final long glScissorIndexedv;
/*      */   public final long glDepthRangeArrayv;
/*      */   public final long glDepthRangeIndexed;
/*      */   public final long glGetFloati_v;
/*      */   public final long glGetDoublei_v;
/*      */   public final long glGetActiveAtomicCounterBufferiv;
/*      */   public final long glTexStorage1D;
/*      */   public final long glTexStorage2D;
/*      */   public final long glTexStorage3D;
/*      */   public final long glDrawTransformFeedbackInstanced;
/*      */   public final long glDrawTransformFeedbackStreamInstanced;
/*      */   public final long glDrawArraysInstancedBaseInstance;
/*      */   public final long glDrawElementsInstancedBaseInstance;
/*      */   public final long glDrawElementsInstancedBaseVertexBaseInstance;
/*      */   public final long glBindImageTexture;
/*      */   public final long glMemoryBarrier;
/*      */   public final long glGetInternalformativ;
/*      */   public final long glClearBufferData;
/*      */   public final long glClearBufferSubData;
/*      */   public final long glDispatchCompute;
/*      */   public final long glDispatchComputeIndirect;
/*      */   public final long glCopyImageSubData;
/*      */   public final long glDebugMessageControl;
/*      */   public final long glDebugMessageInsert;
/*      */   public final long glDebugMessageCallback;
/*      */   public final long glGetDebugMessageLog;
/*      */   public final long glPushDebugGroup;
/*      */   public final long glPopDebugGroup;
/*      */   public final long glObjectLabel;
/*      */   public final long glGetObjectLabel;
/*      */   public final long glObjectPtrLabel;
/*      */   public final long glGetObjectPtrLabel;
/*      */   public final long glFramebufferParameteri;
/*      */   public final long glGetFramebufferParameteriv;
/*      */   public final long glGetInternalformati64v;
/*      */   public final long glInvalidateTexSubImage;
/*      */   public final long glInvalidateTexImage;
/*      */   public final long glInvalidateBufferSubData;
/*      */   public final long glInvalidateBufferData;
/*      */   public final long glInvalidateFramebuffer;
/*      */   public final long glInvalidateSubFramebuffer;
/*      */   public final long glMultiDrawArraysIndirect;
/*      */   public final long glMultiDrawElementsIndirect;
/*      */   public final long glGetProgramInterfaceiv;
/*      */   public final long glGetProgramResourceIndex;
/*      */   public final long glGetProgramResourceName;
/*      */   public final long glGetProgramResourceiv;
/*      */   public final long glGetProgramResourceLocation;
/*      */   public final long glGetProgramResourceLocationIndex;
/*      */   public final long glShaderStorageBlockBinding;
/*      */   public final long glTexBufferRange;
/*      */   public final long glTexStorage2DMultisample;
/*      */   public final long glTexStorage3DMultisample;
/*      */   public final long glTextureView;
/*      */   public final long glBindVertexBuffer;
/*      */   public final long glVertexAttribFormat;
/*      */   public final long glVertexAttribIFormat;
/*      */   public final long glVertexAttribLFormat;
/*      */   public final long glVertexAttribBinding;
/*      */   public final long glVertexBindingDivisor;
/*      */   public final long glBufferStorage;
/*      */   public final long glClearTexSubImage;
/*      */   public final long glClearTexImage;
/*      */   public final long glBindBuffersBase;
/*      */   public final long glBindBuffersRange;
/*      */   public final long glBindTextures;
/*      */   public final long glBindSamplers;
/*      */   public final long glBindImageTextures;
/*      */   public final long glBindVertexBuffers;
/*      */   public final long glClipControl;
/*      */   public final long glCreateTransformFeedbacks;
/*      */   public final long glTransformFeedbackBufferBase;
/*      */   public final long glTransformFeedbackBufferRange;
/*      */   public final long glGetTransformFeedbackiv;
/*      */   public final long glGetTransformFeedbacki_v;
/*      */   public final long glGetTransformFeedbacki64_v;
/*      */   public final long glCreateBuffers;
/*      */   public final long glNamedBufferStorage;
/*      */   public final long glNamedBufferData;
/*      */   public final long glNamedBufferSubData;
/*      */   public final long glCopyNamedBufferSubData;
/*      */   public final long glClearNamedBufferData;
/*      */   public final long glClearNamedBufferSubData;
/*      */   public final long glMapNamedBuffer;
/*      */   public final long glMapNamedBufferRange;
/*      */   public final long glUnmapNamedBuffer;
/*      */   public final long glFlushMappedNamedBufferRange;
/*      */   public final long glGetNamedBufferParameteriv;
/*      */   public final long glGetNamedBufferParameteri64v;
/*      */   public final long glGetNamedBufferPointerv;
/*      */   public final long glGetNamedBufferSubData;
/*      */   public final long glCreateFramebuffers;
/*      */   public final long glNamedFramebufferRenderbuffer;
/*      */   public final long glNamedFramebufferParameteri;
/*      */   public final long glNamedFramebufferTexture;
/*      */   public final long glNamedFramebufferTextureLayer;
/*      */   public final long glNamedFramebufferDrawBuffer;
/*      */   public final long glNamedFramebufferDrawBuffers;
/*      */   public final long glNamedFramebufferReadBuffer;
/*      */   public final long glInvalidateNamedFramebufferData;
/*      */   public final long glInvalidateNamedFramebufferSubData;
/*      */   public final long glClearNamedFramebufferiv;
/*      */   public final long glClearNamedFramebufferuiv;
/*      */   public final long glClearNamedFramebufferfv;
/*      */   public final long glClearNamedFramebufferfi;
/*      */   public final long glBlitNamedFramebuffer;
/*      */   public final long glCheckNamedFramebufferStatus;
/*      */   public final long glGetNamedFramebufferParameteriv;
/*      */   public final long glGetNamedFramebufferAttachmentParameteriv;
/*      */   public final long glCreateRenderbuffers;
/*      */   public final long glNamedRenderbufferStorage;
/*      */   public final long glNamedRenderbufferStorageMultisample;
/*      */   public final long glGetNamedRenderbufferParameteriv;
/*      */   public final long glCreateTextures;
/*      */   public final long glTextureBuffer;
/*      */   public final long glTextureBufferRange;
/*      */   public final long glTextureStorage1D;
/*      */   public final long glTextureStorage2D;
/*      */   public final long glTextureStorage3D;
/*      */   public final long glTextureStorage2DMultisample;
/*      */   public final long glTextureStorage3DMultisample;
/*      */   public final long glTextureSubImage1D;
/*      */   public final long glTextureSubImage2D;
/*      */   public final long glTextureSubImage3D;
/*      */   public final long glCompressedTextureSubImage1D;
/*      */   public final long glCompressedTextureSubImage2D;
/*      */   public final long glCompressedTextureSubImage3D;
/*      */   public final long glCopyTextureSubImage1D;
/*      */   public final long glCopyTextureSubImage2D;
/*      */   public final long glCopyTextureSubImage3D;
/*      */   public final long glTextureParameterf;
/*      */   public final long glTextureParameterfv;
/*      */   public final long glTextureParameteri;
/*      */   public final long glTextureParameterIiv;
/*      */   public final long glTextureParameterIuiv;
/*      */   public final long glTextureParameteriv;
/*      */   public final long glGenerateTextureMipmap;
/*      */   public final long glBindTextureUnit;
/*      */   public final long glGetTextureImage;
/*      */   public final long glGetCompressedTextureImage;
/*      */   public final long glGetTextureLevelParameterfv;
/*      */   public final long glGetTextureLevelParameteriv;
/*      */   public final long glGetTextureParameterfv;
/*      */   public final long glGetTextureParameterIiv;
/*      */   public final long glGetTextureParameterIuiv;
/*      */   public final long glGetTextureParameteriv;
/*      */   public final long glCreateVertexArrays;
/*      */   public final long glDisableVertexArrayAttrib;
/*      */   public final long glEnableVertexArrayAttrib;
/*      */   public final long glVertexArrayElementBuffer;
/*      */   public final long glVertexArrayVertexBuffer;
/*      */   public final long glVertexArrayVertexBuffers;
/*      */   public final long glVertexArrayAttribFormat;
/*      */   public final long glVertexArrayAttribIFormat;
/*      */   public final long glVertexArrayAttribLFormat;
/*      */   public final long glVertexArrayAttribBinding;
/*      */   public final long glVertexArrayBindingDivisor;
/*      */   public final long glGetVertexArrayiv;
/*      */   public final long glGetVertexArrayIndexediv;
/*      */   public final long glGetVertexArrayIndexed64iv;
/*      */   public final long glCreateSamplers;
/*      */   public final long glCreateProgramPipelines;
/*      */   public final long glCreateQueries;
/*      */   public final long glGetQueryBufferObjectiv;
/*      */   public final long glGetQueryBufferObjectuiv;
/*      */   public final long glGetQueryBufferObjecti64v;
/*      */   public final long glGetQueryBufferObjectui64v;
/*      */   public final long glMemoryBarrierByRegion;
/*      */   public final long glGetTextureSubImage;
/*      */   public final long glGetCompressedTextureSubImage;
/*      */   public final long glTextureBarrier;
/*      */   public final long glGetGraphicsResetStatus;
/*      */   public final long glGetnMapdv;
/*      */   public final long glGetnMapfv;
/*      */   public final long glGetnMapiv;
/*      */   public final long glGetnPixelMapfv;
/*      */   public final long glGetnPixelMapuiv;
/*      */   public final long glGetnPixelMapusv;
/*      */   public final long glGetnPolygonStipple;
/*      */   public final long glGetnTexImage;
/*      */   public final long glReadnPixels;
/*      */   public final long glGetnColorTable;
/*      */   public final long glGetnConvolutionFilter;
/*      */   public final long glGetnSeparableFilter;
/*      */   public final long glGetnHistogram;
/*      */   public final long glGetnMinmax;
/*      */   public final long glGetnCompressedTexImage;
/*      */   public final long glGetnUniformfv;
/*      */   public final long glGetnUniformdv;
/*      */   public final long glGetnUniformiv;
/*      */   public final long glGetnUniformuiv;
/*      */   public final long glMultiDrawArraysIndirectCount;
/*      */   public final long glMultiDrawElementsIndirectCount;
/*      */   public final long glPolygonOffsetClamp;
/*      */   public final long glSpecializeShader;
/*      */   public final long glDebugMessageEnableAMD;
/*      */   public final long glDebugMessageInsertAMD;
/*      */   public final long glDebugMessageCallbackAMD;
/*      */   public final long glGetDebugMessageLogAMD;
/*      */   public final long glBlendFuncIndexedAMD;
/*      */   public final long glBlendFuncSeparateIndexedAMD;
/*      */   public final long glBlendEquationIndexedAMD;
/*      */   public final long glBlendEquationSeparateIndexedAMD;
/*      */   public final long glRenderbufferStorageMultisampleAdvancedAMD;
/*      */   public final long glNamedRenderbufferStorageMultisampleAdvancedAMD;
/*      */   public final long glUniform1i64NV;
/*      */   public final long glUniform2i64NV;
/*      */   public final long glUniform3i64NV;
/*      */   public final long glUniform4i64NV;
/*      */   public final long glUniform1i64vNV;
/*      */   public final long glUniform2i64vNV;
/*      */   public final long glUniform3i64vNV;
/*      */   public final long glUniform4i64vNV;
/*      */   public final long glUniform1ui64NV;
/*      */   public final long glUniform2ui64NV;
/*      */   public final long glUniform3ui64NV;
/*      */   public final long glUniform4ui64NV;
/*      */   public final long glUniform1ui64vNV;
/*      */   public final long glUniform2ui64vNV;
/*      */   public final long glUniform3ui64vNV;
/*      */   public final long glUniform4ui64vNV;
/*      */   public final long glGetUniformi64vNV;
/*      */   public final long glGetUniformui64vNV;
/*      */   public final long glProgramUniform1i64NV;
/*      */   public final long glProgramUniform2i64NV;
/*      */   public final long glProgramUniform3i64NV;
/*      */   public final long glProgramUniform4i64NV;
/*      */   public final long glProgramUniform1i64vNV;
/*      */   public final long glProgramUniform2i64vNV;
/*      */   public final long glProgramUniform3i64vNV;
/*      */   public final long glProgramUniform4i64vNV;
/*      */   public final long glProgramUniform1ui64NV;
/*      */   public final long glProgramUniform2ui64NV;
/*      */   public final long glProgramUniform3ui64NV;
/*      */   public final long glProgramUniform4ui64NV;
/*      */   public final long glProgramUniform1ui64vNV;
/*      */   public final long glProgramUniform2ui64vNV;
/*      */   public final long glProgramUniform3ui64vNV;
/*      */   public final long glProgramUniform4ui64vNV;
/*      */   public final long glVertexAttribParameteriAMD;
/*      */   public final long glQueryObjectParameteruiAMD;
/*      */   public final long glGetPerfMonitorGroupsAMD;
/*      */   public final long glGetPerfMonitorCountersAMD;
/*      */   public final long glGetPerfMonitorGroupStringAMD;
/*      */   public final long glGetPerfMonitorCounterStringAMD;
/*      */   public final long glGetPerfMonitorCounterInfoAMD;
/*      */   public final long glGenPerfMonitorsAMD;
/*      */   public final long glDeletePerfMonitorsAMD;
/*      */   public final long glSelectPerfMonitorCountersAMD;
/*      */   public final long glBeginPerfMonitorAMD;
/*      */   public final long glEndPerfMonitorAMD;
/*      */   public final long glGetPerfMonitorCounterDataAMD;
/*      */   public final long glSetMultisamplefvAMD;
/*      */   public final long glTexStorageSparseAMD;
/*      */   public final long glTextureStorageSparseAMD;
/*      */   public final long glStencilOpValueAMD;
/*      */   public final long glTessellationFactorAMD;
/*      */   public final long glTessellationModeAMD;
/*      */   public final long glGetTextureHandleARB;
/*      */   public final long glGetTextureSamplerHandleARB;
/*      */   public final long glMakeTextureHandleResidentARB;
/*      */   public final long glMakeTextureHandleNonResidentARB;
/*      */   public final long glGetImageHandleARB;
/*      */   public final long glMakeImageHandleResidentARB;
/*      */   public final long glMakeImageHandleNonResidentARB;
/*      */   public final long glUniformHandleui64ARB;
/*      */   public final long glUniformHandleui64vARB;
/*      */   public final long glProgramUniformHandleui64ARB;
/*      */   public final long glProgramUniformHandleui64vARB;
/*      */   public final long glIsTextureHandleResidentARB;
/*      */   public final long glIsImageHandleResidentARB;
/*      */   public final long glVertexAttribL1ui64ARB;
/*      */   public final long glVertexAttribL1ui64vARB;
/*      */   public final long glGetVertexAttribLui64vARB;
/*      */   public final long glNamedBufferStorageEXT;
/*      */   public final long glCreateSyncFromCLeventARB;
/*      */   public final long glClearNamedBufferDataEXT;
/*      */   public final long glClearNamedBufferSubDataEXT;
/*      */   public final long glClampColorARB;
/*      */   public final long glDispatchComputeGroupSizeARB;
/*      */   public final long glDebugMessageControlARB;
/*      */   public final long glDebugMessageInsertARB;
/*      */   public final long glDebugMessageCallbackARB;
/*      */   public final long glGetDebugMessageLogARB;
/*      */   public final long glDrawBuffersARB;
/*      */   public final long glBlendEquationiARB;
/*      */   public final long glBlendEquationSeparateiARB;
/*      */   public final long glBlendFunciARB;
/*      */   public final long glBlendFuncSeparateiARB;
/*      */   public final long glDrawArraysInstancedARB;
/*      */   public final long glDrawElementsInstancedARB;
/*      */   public final long glPrimitiveBoundingBoxARB;
/*      */   public final long glNamedFramebufferParameteriEXT;
/*      */   public final long glGetNamedFramebufferParameterivEXT;
/*      */   public final long glProgramParameteriARB;
/*      */   public final long glFramebufferTextureARB;
/*      */   public final long glFramebufferTextureLayerARB;
/*      */   public final long glFramebufferTextureFaceARB;
/*      */   public final long glSpecializeShaderARB;
/*      */   public final long glProgramUniform1dEXT;
/*      */   public final long glProgramUniform2dEXT;
/*      */   public final long glProgramUniform3dEXT;
/*      */   public final long glProgramUniform4dEXT;
/*      */   public final long glProgramUniform1dvEXT;
/*      */   public final long glProgramUniform2dvEXT;
/*      */   public final long glProgramUniform3dvEXT;
/*      */   public final long glProgramUniform4dvEXT;
/*      */   public final long glProgramUniformMatrix2dvEXT;
/*      */   public final long glProgramUniformMatrix3dvEXT;
/*      */   public final long glProgramUniformMatrix4dvEXT;
/*      */   public final long glProgramUniformMatrix2x3dvEXT;
/*      */   public final long glProgramUniformMatrix2x4dvEXT;
/*      */   public final long glProgramUniformMatrix3x2dvEXT;
/*      */   public final long glProgramUniformMatrix3x4dvEXT;
/*      */   public final long glProgramUniformMatrix4x2dvEXT;
/*      */   public final long glProgramUniformMatrix4x3dvEXT;
/*      */   public final long glUniform1i64ARB;
/*      */   public final long glUniform1i64vARB;
/*      */   public final long glProgramUniform1i64ARB;
/*      */   public final long glProgramUniform1i64vARB;
/*      */   public final long glUniform2i64ARB;
/*      */   public final long glUniform2i64vARB;
/*      */   public final long glProgramUniform2i64ARB;
/*      */   public final long glProgramUniform2i64vARB;
/*      */   public final long glUniform3i64ARB;
/*      */   public final long glUniform3i64vARB;
/*      */   public final long glProgramUniform3i64ARB;
/*      */   public final long glProgramUniform3i64vARB;
/*      */   public final long glUniform4i64ARB;
/*      */   public final long glUniform4i64vARB;
/*      */   public final long glProgramUniform4i64ARB;
/*      */   public final long glProgramUniform4i64vARB;
/*      */   public final long glUniform1ui64ARB;
/*      */   public final long glUniform1ui64vARB;
/*      */   public final long glProgramUniform1ui64ARB;
/*      */   public final long glProgramUniform1ui64vARB;
/*      */   public final long glUniform2ui64ARB;
/*      */   public final long glUniform2ui64vARB;
/*      */   public final long glProgramUniform2ui64ARB;
/*      */   public final long glProgramUniform2ui64vARB;
/*      */   public final long glUniform3ui64ARB;
/*      */   public final long glUniform3ui64vARB;
/*      */   public final long glProgramUniform3ui64ARB;
/*      */   public final long glProgramUniform3ui64vARB;
/*      */   public final long glUniform4ui64ARB;
/*      */   public final long glUniform4ui64vARB;
/*      */   public final long glProgramUniform4ui64ARB;
/*      */   public final long glProgramUniform4ui64vARB;
/*      */   public final long glGetUniformi64vARB;
/*      */   public final long glGetUniformui64vARB;
/*      */   public final long glGetnUniformi64vARB;
/*      */   public final long glGetnUniformui64vARB;
/*      */   public final long glColorTable;
/*      */   public final long glCopyColorTable;
/*      */   public final long glColorTableParameteriv;
/*      */   public final long glColorTableParameterfv;
/*      */   public final long glGetColorTable;
/*      */   public final long glGetColorTableParameteriv;
/*      */   public final long glGetColorTableParameterfv;
/*      */   public final long glColorSubTable;
/*      */   public final long glCopyColorSubTable;
/*      */   public final long glConvolutionFilter1D;
/*      */   public final long glConvolutionFilter2D;
/*      */   public final long glCopyConvolutionFilter1D;
/*      */   public final long glCopyConvolutionFilter2D;
/*      */   public final long glGetConvolutionFilter;
/*      */   public final long glSeparableFilter2D;
/*      */   public final long glGetSeparableFilter;
/*      */   public final long glConvolutionParameteri;
/*      */   public final long glConvolutionParameteriv;
/*      */   public final long glConvolutionParameterf;
/*      */   public final long glConvolutionParameterfv;
/*      */   public final long glGetConvolutionParameteriv;
/*      */   public final long glGetConvolutionParameterfv;
/*      */   public final long glHistogram;
/*      */   public final long glResetHistogram;
/*      */   public final long glGetHistogram;
/*      */   public final long glGetHistogramParameteriv;
/*      */   public final long glGetHistogramParameterfv;
/*      */   public final long glMinmax;
/*      */   public final long glResetMinmax;
/*      */   public final long glGetMinmax;
/*      */   public final long glGetMinmaxParameteriv;
/*      */   public final long glGetMinmaxParameterfv;
/*      */   public final long glMultiDrawArraysIndirectCountARB;
/*      */   public final long glMultiDrawElementsIndirectCountARB;
/*      */   public final long glVertexAttribDivisorARB;
/*      */   public final long glVertexArrayVertexAttribDivisorEXT;
/*      */   public final long glCurrentPaletteMatrixARB;
/*      */   public final long glMatrixIndexuivARB;
/*      */   public final long glMatrixIndexubvARB;
/*      */   public final long glMatrixIndexusvARB;
/*      */   public final long glMatrixIndexPointerARB;
/*      */   public final long glSampleCoverageARB;
/*      */   public final long glActiveTextureARB;
/*      */   public final long glClientActiveTextureARB;
/*      */   public final long glMultiTexCoord1fARB;
/*      */   public final long glMultiTexCoord1sARB;
/*      */   public final long glMultiTexCoord1iARB;
/*      */   public final long glMultiTexCoord1dARB;
/*      */   public final long glMultiTexCoord1fvARB;
/*      */   public final long glMultiTexCoord1svARB;
/*      */   public final long glMultiTexCoord1ivARB;
/*      */   public final long glMultiTexCoord1dvARB;
/*      */   public final long glMultiTexCoord2fARB;
/*      */   public final long glMultiTexCoord2sARB;
/*      */   public final long glMultiTexCoord2iARB;
/*      */   public final long glMultiTexCoord2dARB;
/*      */   public final long glMultiTexCoord2fvARB;
/*      */   public final long glMultiTexCoord2svARB;
/*      */   public final long glMultiTexCoord2ivARB;
/*      */   public final long glMultiTexCoord2dvARB;
/*      */   public final long glMultiTexCoord3fARB;
/*      */   public final long glMultiTexCoord3sARB;
/*      */   public final long glMultiTexCoord3iARB;
/*      */   public final long glMultiTexCoord3dARB;
/*      */   public final long glMultiTexCoord3fvARB;
/*      */   public final long glMultiTexCoord3svARB;
/*      */   public final long glMultiTexCoord3ivARB;
/*      */   public final long glMultiTexCoord3dvARB;
/*      */   public final long glMultiTexCoord4fARB;
/*      */   public final long glMultiTexCoord4sARB;
/*      */   public final long glMultiTexCoord4iARB;
/*      */   public final long glMultiTexCoord4dARB;
/*      */   public final long glMultiTexCoord4fvARB;
/*      */   public final long glMultiTexCoord4svARB;
/*      */   public final long glMultiTexCoord4ivARB;
/*      */   public final long glMultiTexCoord4dvARB;
/*      */   public final long glGenQueriesARB;
/*      */   public final long glDeleteQueriesARB;
/*      */   public final long glIsQueryARB;
/*      */   public final long glBeginQueryARB;
/*      */   public final long glEndQueryARB;
/*      */   public final long glGetQueryivARB;
/*      */   public final long glGetQueryObjectivARB;
/*      */   public final long glGetQueryObjectuivARB;
/*      */   public final long glMaxShaderCompilerThreadsARB;
/*      */   public final long glPointParameterfARB;
/*      */   public final long glPointParameterfvARB;
/*      */   public final long glGetGraphicsResetStatusARB;
/*      */   public final long glGetnMapdvARB;
/*      */   public final long glGetnMapfvARB;
/*      */   public final long glGetnMapivARB;
/*      */   public final long glGetnPixelMapfvARB;
/*      */   public final long glGetnPixelMapuivARB;
/*      */   public final long glGetnPixelMapusvARB;
/*      */   public final long glGetnPolygonStippleARB;
/*      */   public final long glGetnTexImageARB;
/*      */   public final long glReadnPixelsARB;
/*      */   public final long glGetnColorTableARB;
/*      */   public final long glGetnConvolutionFilterARB;
/*      */   public final long glGetnSeparableFilterARB;
/*      */   public final long glGetnHistogramARB;
/*      */   public final long glGetnMinmaxARB;
/*      */   public final long glGetnCompressedTexImageARB;
/*      */   public final long glGetnUniformfvARB;
/*      */   public final long glGetnUniformivARB;
/*      */   public final long glGetnUniformuivARB;
/*      */   public final long glGetnUniformdvARB;
/*      */   public final long glFramebufferSampleLocationsfvARB;
/*      */   public final long glNamedFramebufferSampleLocationsfvARB;
/*      */   public final long glEvaluateDepthValuesARB;
/*      */   public final long glMinSampleShadingARB;
/*      */   public final long glDeleteObjectARB;
/*      */   public final long glGetHandleARB;
/*      */   public final long glDetachObjectARB;
/*      */   public final long glCreateShaderObjectARB;
/*      */   public final long glShaderSourceARB;
/*      */   public final long glCompileShaderARB;
/*      */   public final long glCreateProgramObjectARB;
/*      */   public final long glAttachObjectARB;
/*      */   public final long glLinkProgramARB;
/*      */   public final long glUseProgramObjectARB;
/*      */   public final long glValidateProgramARB;
/*      */   public final long glUniform1fARB;
/*      */   public final long glUniform2fARB;
/*      */   public final long glUniform3fARB;
/*      */   public final long glUniform4fARB;
/*      */   public final long glUniform1iARB;
/*      */   public final long glUniform2iARB;
/*      */   public final long glUniform3iARB;
/*      */   public final long glUniform4iARB;
/*      */   public final long glUniform1fvARB;
/*      */   public final long glUniform2fvARB;
/*      */   public final long glUniform3fvARB;
/*      */   public final long glUniform4fvARB;
/*      */   public final long glUniform1ivARB;
/*      */   public final long glUniform2ivARB;
/*      */   public final long glUniform3ivARB;
/*      */   public final long glUniform4ivARB;
/*      */   public final long glUniformMatrix2fvARB;
/*      */   public final long glUniformMatrix3fvARB;
/*      */   public final long glUniformMatrix4fvARB;
/*      */   public final long glGetObjectParameterfvARB;
/*      */   public final long glGetObjectParameterivARB;
/*      */   public final long glGetInfoLogARB;
/*      */   public final long glGetAttachedObjectsARB;
/*      */   public final long glGetUniformLocationARB;
/*      */   public final long glGetActiveUniformARB;
/*      */   public final long glGetUniformfvARB;
/*      */   public final long glGetUniformivARB;
/*      */   public final long glGetShaderSourceARB;
/*      */   public final long glNamedStringARB;
/*      */   public final long glDeleteNamedStringARB;
/*      */   public final long glCompileShaderIncludeARB;
/*      */   public final long glIsNamedStringARB;
/*      */   public final long glGetNamedStringARB;
/*      */   public final long glGetNamedStringivARB;
/*      */   public final long glBufferPageCommitmentARB;
/*      */   public final long glNamedBufferPageCommitmentEXT;
/*      */   public final long glNamedBufferPageCommitmentARB;
/*      */   public final long glTexPageCommitmentARB;
/*      */   public final long glTexturePageCommitmentEXT;
/*      */   public final long glTexBufferARB;
/*      */   public final long glTextureBufferRangeEXT;
/*      */   public final long glCompressedTexImage3DARB;
/*      */   public final long glCompressedTexImage2DARB;
/*      */   public final long glCompressedTexImage1DARB;
/*      */   public final long glCompressedTexSubImage3DARB;
/*      */   public final long glCompressedTexSubImage2DARB;
/*      */   public final long glCompressedTexSubImage1DARB;
/*      */   public final long glGetCompressedTexImageARB;
/*      */   public final long glTextureStorage1DEXT;
/*      */   public final long glTextureStorage2DEXT;
/*      */   public final long glTextureStorage3DEXT;
/*      */   public final long glTextureStorage2DMultisampleEXT;
/*      */   public final long glTextureStorage3DMultisampleEXT;
/*      */   public final long glLoadTransposeMatrixfARB;
/*      */   public final long glLoadTransposeMatrixdARB;
/*      */   public final long glMultTransposeMatrixfARB;
/*      */   public final long glMultTransposeMatrixdARB;
/*      */   public final long glVertexArrayVertexAttribLOffsetEXT;
/*      */   public final long glVertexArrayBindVertexBufferEXT;
/*      */   public final long glVertexArrayVertexAttribFormatEXT;
/*      */   public final long glVertexArrayVertexAttribIFormatEXT;
/*      */   public final long glVertexArrayVertexAttribLFormatEXT;
/*      */   public final long glVertexArrayVertexAttribBindingEXT;
/*      */   public final long glVertexArrayVertexBindingDivisorEXT;
/*      */   public final long glWeightfvARB;
/*      */   public final long glWeightbvARB;
/*      */   public final long glWeightubvARB;
/*      */   public final long glWeightsvARB;
/*      */   public final long glWeightusvARB;
/*      */   public final long glWeightivARB;
/*      */   public final long glWeightuivARB;
/*      */   public final long glWeightdvARB;
/*      */   public final long glWeightPointerARB;
/*      */   public final long glVertexBlendARB;
/*      */   public final long glBindBufferARB;
/*      */   public final long glDeleteBuffersARB;
/*      */   public final long glGenBuffersARB;
/*      */   public final long glIsBufferARB;
/*      */   public final long glBufferDataARB;
/*      */   public final long glBufferSubDataARB;
/*      */   public final long glGetBufferSubDataARB;
/*      */   public final long glMapBufferARB;
/*      */   public final long glUnmapBufferARB;
/*      */   public final long glGetBufferParameterivARB;
/*      */   public final long glGetBufferPointervARB;
/*      */   public final long glVertexAttrib1sARB;
/*      */   public final long glVertexAttrib1fARB;
/*      */   public final long glVertexAttrib1dARB;
/*      */   public final long glVertexAttrib2sARB;
/*      */   public final long glVertexAttrib2fARB;
/*      */   public final long glVertexAttrib2dARB;
/*      */   public final long glVertexAttrib3sARB;
/*      */   public final long glVertexAttrib3fARB;
/*      */   public final long glVertexAttrib3dARB;
/*      */   public final long glVertexAttrib4sARB;
/*      */   public final long glVertexAttrib4fARB;
/*      */   public final long glVertexAttrib4dARB;
/*      */   public final long glVertexAttrib4NubARB;
/*      */   public final long glVertexAttrib1svARB;
/*      */   public final long glVertexAttrib1fvARB;
/*      */   public final long glVertexAttrib1dvARB;
/*      */   public final long glVertexAttrib2svARB;
/*      */   public final long glVertexAttrib2fvARB;
/*      */   public final long glVertexAttrib2dvARB;
/*      */   public final long glVertexAttrib3svARB;
/*      */   public final long glVertexAttrib3fvARB;
/*      */   public final long glVertexAttrib3dvARB;
/*      */   public final long glVertexAttrib4fvARB;
/*      */   public final long glVertexAttrib4bvARB;
/*      */   public final long glVertexAttrib4svARB;
/*      */   public final long glVertexAttrib4ivARB;
/*      */   public final long glVertexAttrib4ubvARB;
/*      */   public final long glVertexAttrib4usvARB;
/*      */   public final long glVertexAttrib4uivARB;
/*      */   public final long glVertexAttrib4dvARB;
/*      */   public final long glVertexAttrib4NbvARB;
/*      */   public final long glVertexAttrib4NsvARB;
/*      */   public final long glVertexAttrib4NivARB;
/*      */   public final long glVertexAttrib4NubvARB;
/*      */   public final long glVertexAttrib4NusvARB;
/*      */   public final long glVertexAttrib4NuivARB;
/*      */   public final long glVertexAttribPointerARB;
/*      */   public final long glEnableVertexAttribArrayARB;
/*      */   public final long glDisableVertexAttribArrayARB;
/*      */   public final long glProgramStringARB;
/*      */   public final long glBindProgramARB;
/*      */   public final long glDeleteProgramsARB;
/*      */   public final long glGenProgramsARB;
/*      */   public final long glProgramEnvParameter4dARB;
/*      */   public final long glProgramEnvParameter4dvARB;
/*      */   public final long glProgramEnvParameter4fARB;
/*      */   public final long glProgramEnvParameter4fvARB;
/*      */   public final long glProgramLocalParameter4dARB;
/*      */   public final long glProgramLocalParameter4dvARB;
/*      */   public final long glProgramLocalParameter4fARB;
/*      */   public final long glProgramLocalParameter4fvARB;
/*      */   public final long glGetProgramEnvParameterfvARB;
/*      */   public final long glGetProgramEnvParameterdvARB;
/*      */   public final long glGetProgramLocalParameterfvARB;
/*      */   public final long glGetProgramLocalParameterdvARB;
/*      */   public final long glGetProgramivARB;
/*      */   public final long glGetProgramStringARB;
/*      */   public final long glGetVertexAttribfvARB;
/*      */   public final long glGetVertexAttribdvARB;
/*      */   public final long glGetVertexAttribivARB;
/*      */   public final long glGetVertexAttribPointervARB;
/*      */   public final long glIsProgramARB;
/*      */   public final long glBindAttribLocationARB;
/*      */   public final long glGetActiveAttribARB;
/*      */   public final long glGetAttribLocationARB;
/*      */   public final long glWindowPos2iARB;
/*      */   public final long glWindowPos2sARB;
/*      */   public final long glWindowPos2fARB;
/*      */   public final long glWindowPos2dARB;
/*      */   public final long glWindowPos2ivARB;
/*      */   public final long glWindowPos2svARB;
/*      */   public final long glWindowPos2fvARB;
/*      */   public final long glWindowPos2dvARB;
/*      */   public final long glWindowPos3iARB;
/*      */   public final long glWindowPos3sARB;
/*      */   public final long glWindowPos3fARB;
/*      */   public final long glWindowPos3dARB;
/*      */   public final long glWindowPos3ivARB;
/*      */   public final long glWindowPos3svARB;
/*      */   public final long glWindowPos3fvARB;
/*      */   public final long glWindowPos3dvARB;
/*      */   public final long glUniformBufferEXT;
/*      */   public final long glGetUniformBufferSizeEXT;
/*      */   public final long glGetUniformOffsetEXT;
/*      */   public final long glBlendColorEXT;
/*      */   public final long glBlendEquationSeparateEXT;
/*      */   public final long glBlendFuncSeparateEXT;
/*      */   public final long glBlendEquationEXT;
/*      */   public final long glLockArraysEXT;
/*      */   public final long glUnlockArraysEXT;
/*      */   public final long glLabelObjectEXT;
/*      */   public final long glGetObjectLabelEXT;
/*      */   public final long glInsertEventMarkerEXT;
/*      */   public final long glPushGroupMarkerEXT;
/*      */   public final long glPopGroupMarkerEXT;
/*      */   public final long glDepthBoundsEXT;
/*      */   public final long glClientAttribDefaultEXT;
/*      */   public final long glPushClientAttribDefaultEXT;
/*      */   public final long glMatrixLoadfEXT;
/*      */   public final long glMatrixLoaddEXT;
/*      */   public final long glMatrixMultfEXT;
/*      */   public final long glMatrixMultdEXT;
/*      */   public final long glMatrixLoadIdentityEXT;
/*      */   public final long glMatrixRotatefEXT;
/*      */   public final long glMatrixRotatedEXT;
/*      */   public final long glMatrixScalefEXT;
/*      */   public final long glMatrixScaledEXT;
/*      */   public final long glMatrixTranslatefEXT;
/*      */   public final long glMatrixTranslatedEXT;
/*      */   public final long glMatrixOrthoEXT;
/*      */   public final long glMatrixFrustumEXT;
/*      */   public final long glMatrixPushEXT;
/*      */   public final long glMatrixPopEXT;
/*      */   public final long glTextureParameteriEXT;
/*      */   public final long glTextureParameterivEXT;
/*      */   public final long glTextureParameterfEXT;
/*      */   public final long glTextureParameterfvEXT;
/*      */   public final long glTextureImage1DEXT;
/*      */   public final long glTextureImage2DEXT;
/*      */   public final long glTextureSubImage1DEXT;
/*      */   public final long glTextureSubImage2DEXT;
/*      */   public final long glCopyTextureImage1DEXT;
/*      */   public final long glCopyTextureImage2DEXT;
/*      */   public final long glCopyTextureSubImage1DEXT;
/*      */   public final long glCopyTextureSubImage2DEXT;
/*      */   public final long glGetTextureImageEXT;
/*      */   public final long glGetTextureParameterfvEXT;
/*      */   public final long glGetTextureParameterivEXT;
/*      */   public final long glGetTextureLevelParameterfvEXT;
/*      */   public final long glGetTextureLevelParameterivEXT;
/*      */   public final long glTextureImage3DEXT;
/*      */   public final long glTextureSubImage3DEXT;
/*      */   public final long glCopyTextureSubImage3DEXT;
/*      */   public final long glBindMultiTextureEXT;
/*      */   public final long glMultiTexCoordPointerEXT;
/*      */   public final long glMultiTexEnvfEXT;
/*      */   public final long glMultiTexEnvfvEXT;
/*      */   public final long glMultiTexEnviEXT;
/*      */   public final long glMultiTexEnvivEXT;
/*      */   public final long glMultiTexGendEXT;
/*      */   public final long glMultiTexGendvEXT;
/*      */   public final long glMultiTexGenfEXT;
/*      */   public final long glMultiTexGenfvEXT;
/*      */   public final long glMultiTexGeniEXT;
/*      */   public final long glMultiTexGenivEXT;
/*      */   public final long glGetMultiTexEnvfvEXT;
/*      */   public final long glGetMultiTexEnvivEXT;
/*      */   public final long glGetMultiTexGendvEXT;
/*      */   public final long glGetMultiTexGenfvEXT;
/*      */   public final long glGetMultiTexGenivEXT;
/*      */   public final long glMultiTexParameteriEXT;
/*      */   public final long glMultiTexParameterivEXT;
/*      */   public final long glMultiTexParameterfEXT;
/*      */   public final long glMultiTexParameterfvEXT;
/*      */   public final long glMultiTexImage1DEXT;
/*      */   public final long glMultiTexImage2DEXT;
/*      */   public final long glMultiTexSubImage1DEXT;
/*      */   public final long glMultiTexSubImage2DEXT;
/*      */   public final long glCopyMultiTexImage1DEXT;
/*      */   public final long glCopyMultiTexImage2DEXT;
/*      */   public final long glCopyMultiTexSubImage1DEXT;
/*      */   public final long glCopyMultiTexSubImage2DEXT;
/*      */   public final long glGetMultiTexImageEXT;
/*      */   public final long glGetMultiTexParameterfvEXT;
/*      */   public final long glGetMultiTexParameterivEXT;
/*      */   public final long glGetMultiTexLevelParameterfvEXT;
/*      */   public final long glGetMultiTexLevelParameterivEXT;
/*      */   public final long glMultiTexImage3DEXT;
/*      */   public final long glMultiTexSubImage3DEXT;
/*      */   public final long glCopyMultiTexSubImage3DEXT;
/*      */   public final long glEnableClientStateIndexedEXT;
/*      */   public final long glDisableClientStateIndexedEXT;
/*      */   public final long glEnableClientStateiEXT;
/*      */   public final long glDisableClientStateiEXT;
/*      */   public final long glGetFloatIndexedvEXT;
/*      */   public final long glGetDoubleIndexedvEXT;
/*      */   public final long glGetPointerIndexedvEXT;
/*      */   public final long glGetFloati_vEXT;
/*      */   public final long glGetDoublei_vEXT;
/*      */   public final long glGetPointeri_vEXT;
/*      */   public final long glEnableIndexedEXT;
/*      */   public final long glDisableIndexedEXT;
/*      */   public final long glIsEnabledIndexedEXT;
/*      */   public final long glGetIntegerIndexedvEXT;
/*      */   public final long glGetBooleanIndexedvEXT;
/*      */   public final long glNamedProgramStringEXT;
/*      */   public final long glNamedProgramLocalParameter4dEXT;
/*      */   public final long glNamedProgramLocalParameter4dvEXT;
/*      */   public final long glNamedProgramLocalParameter4fEXT;
/*      */   public final long glNamedProgramLocalParameter4fvEXT;
/*      */   public final long glGetNamedProgramLocalParameterdvEXT;
/*      */   public final long glGetNamedProgramLocalParameterfvEXT;
/*      */   public final long glGetNamedProgramivEXT;
/*      */   public final long glGetNamedProgramStringEXT;
/*      */   public final long glCompressedTextureImage3DEXT;
/*      */   public final long glCompressedTextureImage2DEXT;
/*      */   public final long glCompressedTextureImage1DEXT;
/*      */   public final long glCompressedTextureSubImage3DEXT;
/*      */   public final long glCompressedTextureSubImage2DEXT;
/*      */   public final long glCompressedTextureSubImage1DEXT;
/*      */   public final long glGetCompressedTextureImageEXT;
/*      */   public final long glCompressedMultiTexImage3DEXT;
/*      */   public final long glCompressedMultiTexImage2DEXT;
/*      */   public final long glCompressedMultiTexImage1DEXT;
/*      */   public final long glCompressedMultiTexSubImage3DEXT;
/*      */   public final long glCompressedMultiTexSubImage2DEXT;
/*      */   public final long glCompressedMultiTexSubImage1DEXT;
/*      */   public final long glGetCompressedMultiTexImageEXT;
/*      */   public final long glMatrixLoadTransposefEXT;
/*      */   public final long glMatrixLoadTransposedEXT;
/*      */   public final long glMatrixMultTransposefEXT;
/*      */   public final long glMatrixMultTransposedEXT;
/*      */   public final long glNamedBufferDataEXT;
/*      */   public final long glNamedBufferSubDataEXT;
/*      */   public final long glMapNamedBufferEXT;
/*      */   public final long glUnmapNamedBufferEXT;
/*      */   public final long glGetNamedBufferParameterivEXT;
/*      */   public final long glGetNamedBufferSubDataEXT;
/*      */   public final long glProgramUniform1fEXT;
/*      */   public final long glProgramUniform2fEXT;
/*      */   public final long glProgramUniform3fEXT;
/*      */   public final long glProgramUniform4fEXT;
/*      */   public final long glProgramUniform1iEXT;
/*      */   public final long glProgramUniform2iEXT;
/*      */   public final long glProgramUniform3iEXT;
/*      */   public final long glProgramUniform4iEXT;
/*      */   public final long glProgramUniform1fvEXT;
/*      */   public final long glProgramUniform2fvEXT;
/*      */   public final long glProgramUniform3fvEXT;
/*      */   public final long glProgramUniform4fvEXT;
/*      */   public final long glProgramUniform1ivEXT;
/*      */   public final long glProgramUniform2ivEXT;
/*      */   public final long glProgramUniform3ivEXT;
/*      */   public final long glProgramUniform4ivEXT;
/*      */   public final long glProgramUniformMatrix2fvEXT;
/*      */   public final long glProgramUniformMatrix3fvEXT;
/*      */   public final long glProgramUniformMatrix4fvEXT;
/*      */   public final long glProgramUniformMatrix2x3fvEXT;
/*      */   public final long glProgramUniformMatrix3x2fvEXT;
/*      */   public final long glProgramUniformMatrix2x4fvEXT;
/*      */   public final long glProgramUniformMatrix4x2fvEXT;
/*      */   public final long glProgramUniformMatrix3x4fvEXT;
/*      */   public final long glProgramUniformMatrix4x3fvEXT;
/*      */   public final long glTextureBufferEXT;
/*      */   public final long glMultiTexBufferEXT;
/*      */   public final long glTextureParameterIivEXT;
/*      */   public final long glTextureParameterIuivEXT;
/*      */   public final long glGetTextureParameterIivEXT;
/*      */   public final long glGetTextureParameterIuivEXT;
/*      */   public final long glMultiTexParameterIivEXT;
/*      */   public final long glMultiTexParameterIuivEXT;
/*      */   public final long glGetMultiTexParameterIivEXT;
/*      */   public final long glGetMultiTexParameterIuivEXT;
/*      */   public final long glProgramUniform1uiEXT;
/*      */   public final long glProgramUniform2uiEXT;
/*      */   public final long glProgramUniform3uiEXT;
/*      */   public final long glProgramUniform4uiEXT;
/*      */   public final long glProgramUniform1uivEXT;
/*      */   public final long glProgramUniform2uivEXT;
/*      */   public final long glProgramUniform3uivEXT;
/*      */   public final long glProgramUniform4uivEXT;
/*      */   public final long glNamedProgramLocalParameters4fvEXT;
/*      */   public final long glNamedProgramLocalParameterI4iEXT;
/*      */   public final long glNamedProgramLocalParameterI4ivEXT;
/*      */   public final long glNamedProgramLocalParametersI4ivEXT;
/*      */   public final long glNamedProgramLocalParameterI4uiEXT;
/*      */   public final long glNamedProgramLocalParameterI4uivEXT;
/*      */   public final long glNamedProgramLocalParametersI4uivEXT;
/*      */   public final long glGetNamedProgramLocalParameterIivEXT;
/*      */   public final long glGetNamedProgramLocalParameterIuivEXT;
/*      */   public final long glNamedRenderbufferStorageEXT;
/*      */   public final long glGetNamedRenderbufferParameterivEXT;
/*      */   public final long glNamedRenderbufferStorageMultisampleEXT;
/*      */   public final long glNamedRenderbufferStorageMultisampleCoverageEXT;
/*      */   public final long glCheckNamedFramebufferStatusEXT;
/*      */   public final long glNamedFramebufferTexture1DEXT;
/*      */   public final long glNamedFramebufferTexture2DEXT;
/*      */   public final long glNamedFramebufferTexture3DEXT;
/*      */   public final long glNamedFramebufferRenderbufferEXT;
/*      */   public final long glGetNamedFramebufferAttachmentParameterivEXT;
/*      */   public final long glGenerateTextureMipmapEXT;
/*      */   public final long glGenerateMultiTexMipmapEXT;
/*      */   public final long glFramebufferDrawBufferEXT;
/*      */   public final long glFramebufferDrawBuffersEXT;
/*      */   public final long glFramebufferReadBufferEXT;
/*      */   public final long glGetFramebufferParameterivEXT;
/*      */   public final long glNamedCopyBufferSubDataEXT;
/*      */   public final long glNamedFramebufferTextureEXT;
/*      */   public final long glNamedFramebufferTextureLayerEXT;
/*      */   public final long glNamedFramebufferTextureFaceEXT;
/*      */   public final long glTextureRenderbufferEXT;
/*      */   public final long glMultiTexRenderbufferEXT;
/*      */   public final long glVertexArrayVertexOffsetEXT;
/*      */   public final long glVertexArrayColorOffsetEXT;
/*      */   public final long glVertexArrayEdgeFlagOffsetEXT;
/*      */   public final long glVertexArrayIndexOffsetEXT;
/*      */   public final long glVertexArrayNormalOffsetEXT;
/*      */   public final long glVertexArrayTexCoordOffsetEXT;
/*      */   public final long glVertexArrayMultiTexCoordOffsetEXT;
/*      */   public final long glVertexArrayFogCoordOffsetEXT;
/*      */   public final long glVertexArraySecondaryColorOffsetEXT;
/*      */   public final long glVertexArrayVertexAttribOffsetEXT;
/*      */   public final long glVertexArrayVertexAttribIOffsetEXT;
/*      */   public final long glEnableVertexArrayEXT;
/*      */   public final long glDisableVertexArrayEXT;
/*      */   public final long glEnableVertexArrayAttribEXT;
/*      */   public final long glDisableVertexArrayAttribEXT;
/*      */   public final long glGetVertexArrayIntegervEXT;
/*      */   public final long glGetVertexArrayPointervEXT;
/*      */   public final long glGetVertexArrayIntegeri_vEXT;
/*      */   public final long glGetVertexArrayPointeri_vEXT;
/*      */   public final long glMapNamedBufferRangeEXT;
/*      */   public final long glFlushMappedNamedBufferRangeEXT;
/*      */   public final long glColorMaskIndexedEXT;
/*      */   public final long glDrawArraysInstancedEXT;
/*      */   public final long glDrawElementsInstancedEXT;
/*      */   public final long glEGLImageTargetTexStorageEXT;
/*      */   public final long glEGLImageTargetTextureStorageEXT;
/*      */   public final long glBufferStorageExternalEXT;
/*      */   public final long glNamedBufferStorageExternalEXT;
/*      */   public final long glShadingRateEXT;
/*      */   public final long glShadingRateCombinerOpsEXT;
/*      */   public final long glFramebufferShadingRateEXT;
/*      */   public final long glGetFragmentShadingRatesEXT;
/*      */   public final long glBlitFramebufferEXT;
/*      */   public final long glBlitFramebufferLayersEXT;
/*      */   public final long glBlitFramebufferLayerEXT;
/*      */   public final long glRenderbufferStorageMultisampleEXT;
/*      */   public final long glIsRenderbufferEXT;
/*      */   public final long glBindRenderbufferEXT;
/*      */   public final long glDeleteRenderbuffersEXT;
/*      */   public final long glGenRenderbuffersEXT;
/*      */   public final long glRenderbufferStorageEXT;
/*      */   public final long glGetRenderbufferParameterivEXT;
/*      */   public final long glIsFramebufferEXT;
/*      */   public final long glBindFramebufferEXT;
/*      */   public final long glDeleteFramebuffersEXT;
/*      */   public final long glGenFramebuffersEXT;
/*      */   public final long glCheckFramebufferStatusEXT;
/*      */   public final long glFramebufferTexture1DEXT;
/*      */   public final long glFramebufferTexture2DEXT;
/*      */   public final long glFramebufferTexture3DEXT;
/*      */   public final long glFramebufferRenderbufferEXT;
/*      */   public final long glGetFramebufferAttachmentParameterivEXT;
/*      */   public final long glGenerateMipmapEXT;
/*      */   public final long glProgramParameteriEXT;
/*      */   public final long glFramebufferTextureEXT;
/*      */   public final long glFramebufferTextureLayerEXT;
/*      */   public final long glFramebufferTextureFaceEXT;
/*      */   public final long glProgramEnvParameters4fvEXT;
/*      */   public final long glProgramLocalParameters4fvEXT;
/*      */   public final long glVertexAttribI1iEXT;
/*      */   public final long glVertexAttribI2iEXT;
/*      */   public final long glVertexAttribI3iEXT;
/*      */   public final long glVertexAttribI4iEXT;
/*      */   public final long glVertexAttribI1uiEXT;
/*      */   public final long glVertexAttribI2uiEXT;
/*      */   public final long glVertexAttribI3uiEXT;
/*      */   public final long glVertexAttribI4uiEXT;
/*      */   public final long glVertexAttribI1ivEXT;
/*      */   public final long glVertexAttribI2ivEXT;
/*      */   public final long glVertexAttribI3ivEXT;
/*      */   public final long glVertexAttribI4ivEXT;
/*      */   public final long glVertexAttribI1uivEXT;
/*      */   public final long glVertexAttribI2uivEXT;
/*      */   public final long glVertexAttribI3uivEXT;
/*      */   public final long glVertexAttribI4uivEXT;
/*      */   public final long glVertexAttribI4bvEXT;
/*      */   public final long glVertexAttribI4svEXT;
/*      */   public final long glVertexAttribI4ubvEXT;
/*      */   public final long glVertexAttribI4usvEXT;
/*      */   public final long glVertexAttribIPointerEXT;
/*      */   public final long glGetVertexAttribIivEXT;
/*      */   public final long glGetVertexAttribIuivEXT;
/*      */   public final long glGetUniformuivEXT;
/*      */   public final long glBindFragDataLocationEXT;
/*      */   public final long glGetFragDataLocationEXT;
/*      */   public final long glUniform1uiEXT;
/*      */   public final long glUniform2uiEXT;
/*      */   public final long glUniform3uiEXT;
/*      */   public final long glUniform4uiEXT;
/*      */   public final long glUniform1uivEXT;
/*      */   public final long glUniform2uivEXT;
/*      */   public final long glUniform3uivEXT;
/*      */   public final long glUniform4uivEXT;
/*      */   public final long glGetUnsignedBytevEXT;
/*      */   public final long glGetUnsignedBytei_vEXT;
/*      */   public final long glDeleteMemoryObjectsEXT;
/*      */   public final long glIsMemoryObjectEXT;
/*      */   public final long glCreateMemoryObjectsEXT;
/*      */   public final long glMemoryObjectParameterivEXT;
/*      */   public final long glGetMemoryObjectParameterivEXT;
/*      */   public final long glTexStorageMem2DEXT;
/*      */   public final long glTexStorageMem2DMultisampleEXT;
/*      */   public final long glTexStorageMem3DEXT;
/*      */   public final long glTexStorageMem3DMultisampleEXT;
/*      */   public final long glBufferStorageMemEXT;
/*      */   public final long glTextureStorageMem2DEXT;
/*      */   public final long glTextureStorageMem2DMultisampleEXT;
/*      */   public final long glTextureStorageMem3DEXT;
/*      */   public final long glTextureStorageMem3DMultisampleEXT;
/*      */   public final long glNamedBufferStorageMemEXT;
/*      */   public final long glTexStorageMem1DEXT;
/*      */   public final long glTextureStorageMem1DEXT;
/*      */   public final long glImportMemoryFdEXT;
/*      */   public final long glImportMemoryWin32HandleEXT;
/*      */   public final long glImportMemoryWin32NameEXT;
/*      */   public final long glDrawMeshTasksEXT;
/*      */   public final long glDrawMeshTasksIndirectEXT;
/*      */   public final long glMultiDrawMeshTasksIndirectEXT;
/*      */   public final long glMultiDrawMeshTasksIndirectCountEXT;
/*      */   public final long glPointParameterfEXT;
/*      */   public final long glPointParameterfvEXT;
/*      */   public final long glPolygonOffsetClampEXT;
/*      */   public final long glProvokingVertexEXT;
/*      */   public final long glRasterSamplesEXT;
/*      */   public final long glSecondaryColor3bEXT;
/*      */   public final long glSecondaryColor3sEXT;
/*      */   public final long glSecondaryColor3iEXT;
/*      */   public final long glSecondaryColor3fEXT;
/*      */   public final long glSecondaryColor3dEXT;
/*      */   public final long glSecondaryColor3ubEXT;
/*      */   public final long glSecondaryColor3usEXT;
/*      */   public final long glSecondaryColor3uiEXT;
/*      */   public final long glSecondaryColor3bvEXT;
/*      */   public final long glSecondaryColor3svEXT;
/*      */   public final long glSecondaryColor3ivEXT;
/*      */   public final long glSecondaryColor3fvEXT;
/*      */   public final long glSecondaryColor3dvEXT;
/*      */   public final long glSecondaryColor3ubvEXT;
/*      */   public final long glSecondaryColor3usvEXT;
/*      */   public final long glSecondaryColor3uivEXT;
/*      */   public final long glSecondaryColorPointerEXT;
/*      */   public final long glGenSemaphoresEXT;
/*      */   public final long glDeleteSemaphoresEXT;
/*      */   public final long glIsSemaphoreEXT;
/*      */   public final long glSemaphoreParameterui64vEXT;
/*      */   public final long glGetSemaphoreParameterui64vEXT;
/*      */   public final long glWaitSemaphoreEXT;
/*      */   public final long glSignalSemaphoreEXT;
/*      */   public final long glImportSemaphoreFdEXT;
/*      */   public final long glImportSemaphoreWin32HandleEXT;
/*      */   public final long glImportSemaphoreWin32NameEXT;
/*      */   public final long glUseShaderProgramEXT;
/*      */   public final long glActiveProgramEXT;
/*      */   public final long glCreateShaderProgramEXT;
/*      */   public final long glFramebufferFetchBarrierEXT;
/*      */   public final long glBindImageTextureEXT;
/*      */   public final long glMemoryBarrierEXT;
/*      */   public final long glStencilClearTagEXT;
/*      */   public final long glActiveStencilFaceEXT;
/*      */   public final long glTexBufferEXT;
/*      */   public final long glClearColorIiEXT;
/*      */   public final long glClearColorIuiEXT;
/*      */   public final long glTexParameterIivEXT;
/*      */   public final long glTexParameterIuivEXT;
/*      */   public final long glGetTexParameterIivEXT;
/*      */   public final long glGetTexParameterIuivEXT;
/*      */   public final long glTexStorage1DEXT;
/*      */   public final long glTexStorage2DEXT;
/*      */   public final long glTexStorage3DEXT;
/*      */   public final long glGetQueryObjecti64vEXT;
/*      */   public final long glGetQueryObjectui64vEXT;
/*      */   public final long glBindBufferRangeEXT;
/*      */   public final long glBindBufferOffsetEXT;
/*      */   public final long glBindBufferBaseEXT;
/*      */   public final long glBeginTransformFeedbackEXT;
/*      */   public final long glEndTransformFeedbackEXT;
/*      */   public final long glTransformFeedbackVaryingsEXT;
/*      */   public final long glGetTransformFeedbackVaryingEXT;
/*      */   public final long glVertexAttribL1dEXT;
/*      */   public final long glVertexAttribL2dEXT;
/*      */   public final long glVertexAttribL3dEXT;
/*      */   public final long glVertexAttribL4dEXT;
/*      */   public final long glVertexAttribL1dvEXT;
/*      */   public final long glVertexAttribL2dvEXT;
/*      */   public final long glVertexAttribL3dvEXT;
/*      */   public final long glVertexAttribL4dvEXT;
/*      */   public final long glVertexAttribLPointerEXT;
/*      */   public final long glGetVertexAttribLdvEXT;
/*      */   public final long glAcquireKeyedMutexWin32EXT;
/*      */   public final long glReleaseKeyedMutexWin32EXT;
/*      */   public final long glWindowRectanglesEXT;
/*      */   public final long glImportSyncEXT;
/*      */   public final long glFrameTerminatorGREMEDY;
/*      */   public final long glStringMarkerGREMEDY;
/*      */   public final long glApplyFramebufferAttachmentCMAAINTEL;
/*      */   public final long glSyncTextureINTEL;
/*      */   public final long glUnmapTexture2DINTEL;
/*      */   public final long glMapTexture2DINTEL;
/*      */   public final long glBeginPerfQueryINTEL;
/*      */   public final long glCreatePerfQueryINTEL;
/*      */   public final long glDeletePerfQueryINTEL;
/*      */   public final long glEndPerfQueryINTEL;
/*      */   public final long glGetFirstPerfQueryIdINTEL;
/*      */   public final long glGetNextPerfQueryIdINTEL;
/*      */   public final long glGetPerfCounterInfoINTEL;
/*      */   public final long glGetPerfQueryDataINTEL;
/*      */   public final long glGetPerfQueryIdByNameINTEL;
/*      */   public final long glGetPerfQueryInfoINTEL;
/*      */   public final long glBlendBarrierKHR;
/*      */   public final long glMaxShaderCompilerThreadsKHR;
/*      */   public final long glFramebufferParameteriMESA;
/*      */   public final long glGetFramebufferParameterivMESA;
/*      */   public final long glAlphaToCoverageDitherControlNV;
/*      */   public final long glMultiDrawArraysIndirectBindlessNV;
/*      */   public final long glMultiDrawElementsIndirectBindlessNV;
/*      */   public final long glMultiDrawArraysIndirectBindlessCountNV;
/*      */   public final long glMultiDrawElementsIndirectBindlessCountNV;
/*      */   public final long glGetTextureHandleNV;
/*      */   public final long glGetTextureSamplerHandleNV;
/*      */   public final long glMakeTextureHandleResidentNV;
/*      */   public final long glMakeTextureHandleNonResidentNV;
/*      */   public final long glGetImageHandleNV;
/*      */   public final long glMakeImageHandleResidentNV;
/*      */   public final long glMakeImageHandleNonResidentNV;
/*      */   public final long glUniformHandleui64NV;
/*      */   public final long glUniformHandleui64vNV;
/*      */   public final long glProgramUniformHandleui64NV;
/*      */   public final long glProgramUniformHandleui64vNV;
/*      */   public final long glIsTextureHandleResidentNV;
/*      */   public final long glIsImageHandleResidentNV;
/*      */   public final long glBlendParameteriNV;
/*      */   public final long glBlendBarrierNV;
/*      */   public final long glViewportPositionWScaleNV;
/*      */   public final long glCreateStatesNV;
/*      */   public final long glDeleteStatesNV;
/*      */   public final long glIsStateNV;
/*      */   public final long glStateCaptureNV;
/*      */   public final long glGetCommandHeaderNV;
/*      */   public final long glGetStageIndexNV;
/*      */   public final long glDrawCommandsNV;
/*      */   public final long glDrawCommandsAddressNV;
/*      */   public final long glDrawCommandsStatesNV;
/*      */   public final long glDrawCommandsStatesAddressNV;
/*      */   public final long glCreateCommandListsNV;
/*      */   public final long glDeleteCommandListsNV;
/*      */   public final long glIsCommandListNV;
/*      */   public final long glListDrawCommandsStatesClientNV;
/*      */   public final long glCommandListSegmentsNV;
/*      */   public final long glCompileCommandListNV;
/*      */   public final long glCallCommandListNV;
/*      */   public final long glBeginConditionalRenderNV;
/*      */   public final long glEndConditionalRenderNV;
/*      */   public final long glSubpixelPrecisionBiasNV;
/*      */   public final long glConservativeRasterParameterfNV;
/*      */   public final long glConservativeRasterParameteriNV;
/*      */   public final long glCopyImageSubDataNV;
/*      */   public final long glDepthRangedNV;
/*      */   public final long glClearDepthdNV;
/*      */   public final long glDepthBoundsdNV;
/*      */   public final long glDrawTextureNV;
/*      */   public final long glDrawVkImageNV;
/*      */   public final long glGetVkProcAddrNV;
/*      */   public final long glWaitVkSemaphoreNV;
/*      */   public final long glSignalVkSemaphoreNV;
/*      */   public final long glSignalVkFenceNV;
/*      */   public final long glGetMultisamplefvNV;
/*      */   public final long glSampleMaskIndexedNV;
/*      */   public final long glTexRenderbufferNV;
/*      */   public final long glDeleteFencesNV;
/*      */   public final long glGenFencesNV;
/*      */   public final long glIsFenceNV;
/*      */   public final long glTestFenceNV;
/*      */   public final long glGetFenceivNV;
/*      */   public final long glFinishFenceNV;
/*      */   public final long glSetFenceNV;
/*      */   public final long glFragmentCoverageColorNV;
/*      */   public final long glCoverageModulationTableNV;
/*      */   public final long glGetCoverageModulationTableNV;
/*      */   public final long glCoverageModulationNV;
/*      */   public final long glRenderbufferStorageMultisampleCoverageNV;
/*      */   public final long glRenderGpuMaskNV;
/*      */   public final long glMulticastBufferSubDataNV;
/*      */   public final long glMulticastCopyBufferSubDataNV;
/*      */   public final long glMulticastCopyImageSubDataNV;
/*      */   public final long glMulticastBlitFramebufferNV;
/*      */   public final long glMulticastFramebufferSampleLocationsfvNV;
/*      */   public final long glMulticastBarrierNV;
/*      */   public final long glMulticastWaitSyncNV;
/*      */   public final long glMulticastGetQueryObjectivNV;
/*      */   public final long glMulticastGetQueryObjectuivNV;
/*      */   public final long glMulticastGetQueryObjecti64vNV;
/*      */   public final long glMulticastGetQueryObjectui64vNV;
/*      */   public final long glVertex2hNV;
/*      */   public final long glVertex2hvNV;
/*      */   public final long glVertex3hNV;
/*      */   public final long glVertex3hvNV;
/*      */   public final long glVertex4hNV;
/*      */   public final long glVertex4hvNV;
/*      */   public final long glNormal3hNV;
/*      */   public final long glNormal3hvNV;
/*      */   public final long glColor3hNV;
/*      */   public final long glColor3hvNV;
/*      */   public final long glColor4hNV;
/*      */   public final long glColor4hvNV;
/*      */   public final long glTexCoord1hNV;
/*      */   public final long glTexCoord1hvNV;
/*      */   public final long glTexCoord2hNV;
/*      */   public final long glTexCoord2hvNV;
/*      */   public final long glTexCoord3hNV;
/*      */   public final long glTexCoord3hvNV;
/*      */   public final long glTexCoord4hNV;
/*      */   public final long glTexCoord4hvNV;
/*      */   public final long glMultiTexCoord1hNV;
/*      */   public final long glMultiTexCoord1hvNV;
/*      */   public final long glMultiTexCoord2hNV;
/*      */   public final long glMultiTexCoord2hvNV;
/*      */   public final long glMultiTexCoord3hNV;
/*      */   public final long glMultiTexCoord3hvNV;
/*      */   public final long glMultiTexCoord4hNV;
/*      */   public final long glMultiTexCoord4hvNV;
/*      */   public final long glFogCoordhNV;
/*      */   public final long glFogCoordhvNV;
/*      */   public final long glSecondaryColor3hNV;
/*      */   public final long glSecondaryColor3hvNV;
/*      */   public final long glVertexWeighthNV;
/*      */   public final long glVertexWeighthvNV;
/*      */   public final long glVertexAttrib1hNV;
/*      */   public final long glVertexAttrib1hvNV;
/*      */   public final long glVertexAttrib2hNV;
/*      */   public final long glVertexAttrib2hvNV;
/*      */   public final long glVertexAttrib3hNV;
/*      */   public final long glVertexAttrib3hvNV;
/*      */   public final long glVertexAttrib4hNV;
/*      */   public final long glVertexAttrib4hvNV;
/*      */   public final long glVertexAttribs1hvNV;
/*      */   public final long glVertexAttribs2hvNV;
/*      */   public final long glVertexAttribs3hvNV;
/*      */   public final long glVertexAttribs4hvNV;
/*      */   public final long glGetInternalformatSampleivNV;
/*      */   public final long glGetMemoryObjectDetachedResourcesuivNV;
/*      */   public final long glResetMemoryObjectParameterNV;
/*      */   public final long glTexAttachMemoryNV;
/*      */   public final long glBufferAttachMemoryNV;
/*      */   public final long glTextureAttachMemoryNV;
/*      */   public final long glNamedBufferAttachMemoryNV;
/*      */   public final long glBufferPageCommitmentMemNV;
/*      */   public final long glNamedBufferPageCommitmentMemNV;
/*      */   public final long glTexPageCommitmentMemNV;
/*      */   public final long glTexturePageCommitmentMemNV;
/*      */   public final long glDrawMeshTasksNV;
/*      */   public final long glDrawMeshTasksIndirectNV;
/*      */   public final long glMultiDrawMeshTasksIndirectNV;
/*      */   public final long glMultiDrawMeshTasksIndirectCountNV;
/*      */   public final long glPathCommandsNV;
/*      */   public final long glPathCoordsNV;
/*      */   public final long glPathSubCommandsNV;
/*      */   public final long glPathSubCoordsNV;
/*      */   public final long glPathStringNV;
/*      */   public final long glPathGlyphsNV;
/*      */   public final long glPathGlyphRangeNV;
/*      */   public final long glPathGlyphIndexArrayNV;
/*      */   public final long glPathMemoryGlyphIndexArrayNV;
/*      */   public final long glCopyPathNV;
/*      */   public final long glWeightPathsNV;
/*      */   public final long glInterpolatePathsNV;
/*      */   public final long glTransformPathNV;
/*      */   public final long glPathParameterivNV;
/*      */   public final long glPathParameteriNV;
/*      */   public final long glPathParameterfvNV;
/*      */   public final long glPathParameterfNV;
/*      */   public final long glPathDashArrayNV;
/*      */   public final long glGenPathsNV;
/*      */   public final long glDeletePathsNV;
/*      */   public final long glIsPathNV;
/*      */   public final long glPathStencilFuncNV;
/*      */   public final long glPathStencilDepthOffsetNV;
/*      */   public final long glStencilFillPathNV;
/*      */   public final long glStencilStrokePathNV;
/*      */   public final long glStencilFillPathInstancedNV;
/*      */   public final long glStencilStrokePathInstancedNV;
/*      */   public final long glPathCoverDepthFuncNV;
/*      */   public final long glPathColorGenNV;
/*      */   public final long glPathTexGenNV;
/*      */   public final long glPathFogGenNV;
/*      */   public final long glCoverFillPathNV;
/*      */   public final long glCoverStrokePathNV;
/*      */   public final long glCoverFillPathInstancedNV;
/*      */   public final long glCoverStrokePathInstancedNV;
/*      */   public final long glStencilThenCoverFillPathNV;
/*      */   public final long glStencilThenCoverStrokePathNV;
/*      */   public final long glStencilThenCoverFillPathInstancedNV;
/*      */   public final long glStencilThenCoverStrokePathInstancedNV;
/*      */   public final long glPathGlyphIndexRangeNV;
/*      */   public final long glProgramPathFragmentInputGenNV;
/*      */   public final long glGetPathParameterivNV;
/*      */   public final long glGetPathParameterfvNV;
/*      */   public final long glGetPathCommandsNV;
/*      */   public final long glGetPathCoordsNV;
/*      */   public final long glGetPathDashArrayNV;
/*      */   public final long glGetPathMetricsNV;
/*      */   public final long glGetPathMetricRangeNV;
/*      */   public final long glGetPathSpacingNV;
/*      */   public final long glGetPathColorGenivNV;
/*      */   public final long glGetPathColorGenfvNV;
/*      */   public final long glGetPathTexGenivNV;
/*      */   public final long glGetPathTexGenfvNV;
/*      */   public final long glIsPointInFillPathNV;
/*      */   public final long glIsPointInStrokePathNV;
/*      */   public final long glGetPathLengthNV;
/*      */   public final long glPointAlongPathNV;
/*      */   public final long glMatrixLoad3x2fNV;
/*      */   public final long glMatrixLoad3x3fNV;
/*      */   public final long glMatrixLoadTranspose3x3fNV;
/*      */   public final long glMatrixMult3x2fNV;
/*      */   public final long glMatrixMult3x3fNV;
/*      */   public final long glMatrixMultTranspose3x3fNV;
/*      */   public final long glGetProgramResourcefvNV;
/*      */   public final long glPixelDataRangeNV;
/*      */   public final long glFlushPixelDataRangeNV;
/*      */   public final long glPointParameteriNV;
/*      */   public final long glPointParameterivNV;
/*      */   public final long glPrimitiveRestartNV;
/*      */   public final long glPrimitiveRestartIndexNV;
/*      */   public final long glQueryResourceNV;
/*      */   public final long glGenQueryResourceTagNV;
/*      */   public final long glDeleteQueryResourceTagNV;
/*      */   public final long glQueryResourceTagNV;
/*      */   public final long glFramebufferSampleLocationsfvNV;
/*      */   public final long glNamedFramebufferSampleLocationsfvNV;
/*      */   public final long glResolveDepthValuesNV;
/*      */   public final long glScissorExclusiveArrayvNV;
/*      */   public final long glScissorExclusiveNV;
/*      */   public final long glMakeBufferResidentNV;
/*      */   public final long glMakeBufferNonResidentNV;
/*      */   public final long glIsBufferResidentNV;
/*      */   public final long glMakeNamedBufferResidentNV;
/*      */   public final long glMakeNamedBufferNonResidentNV;
/*      */   public final long glIsNamedBufferResidentNV;
/*      */   public final long glGetBufferParameterui64vNV;
/*      */   public final long glGetNamedBufferParameterui64vNV;
/*      */   public final long glGetIntegerui64vNV;
/*      */   public final long glUniformui64NV;
/*      */   public final long glUniformui64vNV;
/*      */   public final long glProgramUniformui64NV;
/*      */   public final long glProgramUniformui64vNV;
/*      */   public final long glBindShadingRateImageNV;
/*      */   public final long glShadingRateImagePaletteNV;
/*      */   public final long glGetShadingRateImagePaletteNV;
/*      */   public final long glShadingRateImageBarrierNV;
/*      */   public final long glShadingRateSampleOrderNV;
/*      */   public final long glShadingRateSampleOrderCustomNV;
/*      */   public final long glGetShadingRateSampleLocationivNV;
/*      */   public final long glTextureBarrierNV;
/*      */   public final long glTexImage2DMultisampleCoverageNV;
/*      */   public final long glTexImage3DMultisampleCoverageNV;
/*      */   public final long glTextureImage2DMultisampleNV;
/*      */   public final long glTextureImage3DMultisampleNV;
/*      */   public final long glTextureImage2DMultisampleCoverageNV;
/*      */   public final long glTextureImage3DMultisampleCoverageNV;
/*      */   public final long glCreateSemaphoresNV;
/*      */   public final long glSemaphoreParameterivNV;
/*      */   public final long glGetSemaphoreParameterivNV;
/*      */   public final long glBeginTransformFeedbackNV;
/*      */   public final long glEndTransformFeedbackNV;
/*      */   public final long glTransformFeedbackAttribsNV;
/*      */   public final long glBindBufferRangeNV;
/*      */   public final long glBindBufferOffsetNV;
/*      */   public final long glBindBufferBaseNV;
/*      */   public final long glTransformFeedbackVaryingsNV;
/*      */   public final long glActiveVaryingNV;
/*      */   public final long glGetVaryingLocationNV;
/*      */   public final long glGetActiveVaryingNV;
/*      */   public final long glGetTransformFeedbackVaryingNV;
/*      */   public final long glTransformFeedbackStreamAttribsNV;
/*      */   public final long glBindTransformFeedbackNV;
/*      */   public final long glDeleteTransformFeedbacksNV;
/*      */   public final long glGenTransformFeedbacksNV;
/*      */   public final long glIsTransformFeedbackNV;
/*      */   public final long glPauseTransformFeedbackNV;
/*      */   public final long glResumeTransformFeedbackNV;
/*      */   public final long glDrawTransformFeedbackNV;
/*      */   public final long glVertexArrayRangeNV;
/*      */   public final long glFlushVertexArrayRangeNV;
/*      */   public final long glVertexAttribL1i64NV;
/*      */   public final long glVertexAttribL2i64NV;
/*      */   public final long glVertexAttribL3i64NV;
/*      */   public final long glVertexAttribL4i64NV;
/*      */   public final long glVertexAttribL1i64vNV;
/*      */   public final long glVertexAttribL2i64vNV;
/*      */   public final long glVertexAttribL3i64vNV;
/*      */   public final long glVertexAttribL4i64vNV;
/*      */   public final long glVertexAttribL1ui64NV;
/*      */   public final long glVertexAttribL2ui64NV;
/*      */   public final long glVertexAttribL3ui64NV;
/*      */   public final long glVertexAttribL4ui64NV;
/*      */   public final long glVertexAttribL1ui64vNV;
/*      */   public final long glVertexAttribL2ui64vNV;
/*      */   public final long glVertexAttribL3ui64vNV;
/*      */   public final long glVertexAttribL4ui64vNV;
/*      */   public final long glGetVertexAttribLi64vNV;
/*      */   public final long glGetVertexAttribLui64vNV;
/*      */   public final long glVertexAttribLFormatNV;
/*      */   public final long glBufferAddressRangeNV;
/*      */   public final long glVertexFormatNV;
/*      */   public final long glNormalFormatNV;
/*      */   public final long glColorFormatNV;
/*      */   public final long glIndexFormatNV;
/*      */   public final long glTexCoordFormatNV;
/*      */   public final long glEdgeFlagFormatNV;
/*      */   public final long glSecondaryColorFormatNV;
/*      */   public final long glFogCoordFormatNV;
/*      */   public final long glVertexAttribFormatNV;
/*      */   public final long glVertexAttribIFormatNV;
/*      */   public final long glGetIntegerui64i_vNV;
/*      */   public final long glViewportSwizzleNV;
/*      */   public final long glBeginConditionalRenderNVX;
/*      */   public final long glEndConditionalRenderNVX;
/*      */   public final long glAsyncCopyImageSubDataNVX;
/*      */   public final long glAsyncCopyBufferSubDataNVX;
/*      */   public final long glUploadGpuMaskNVX;
/*      */   public final long glMulticastViewportArrayvNVX;
/*      */   public final long glMulticastScissorArrayvNVX;
/*      */   public final long glMulticastViewportPositionWScaleNVX;
/*      */   public final long glCreateProgressFenceNVX;
/*      */   public final long glSignalSemaphoreui64NVX;
/*      */   public final long glWaitSemaphoreui64NVX;
/*      */   public final long glClientWaitSemaphoreui64NVX;
/*      */   public final long glFramebufferTextureMultiviewOVR;
/*      */   public final long glNamedFramebufferTextureMultiviewOVR;
/*      */   public final boolean OpenGL11;
/*      */   public final boolean OpenGL12;
/*      */   public final boolean OpenGL13;
/*      */   public final boolean OpenGL14;
/*      */   public final boolean OpenGL15;
/*      */   public final boolean OpenGL20;
/*      */   public final boolean OpenGL21;
/*      */   public final boolean OpenGL30;
/*      */   public final boolean OpenGL31;
/*      */   public final boolean OpenGL32;
/*      */   public final boolean OpenGL33;
/*      */   public final boolean OpenGL40;
/*      */   public final boolean OpenGL41;
/*      */   public final boolean OpenGL42;
/*      */   public final boolean OpenGL43;
/*      */   public final boolean OpenGL44;
/*      */   public final boolean OpenGL45;
/*      */   public final boolean OpenGL46;
/*      */   public final boolean GL_3DFX_texture_compression_FXT1;
/*      */   public final boolean GL_AMD_blend_minmax_factor;
/*      */   public final boolean GL_AMD_conservative_depth;
/*      */   public final boolean GL_AMD_debug_output;
/*      */   public final boolean GL_AMD_depth_clamp_separate;
/*      */   public final boolean GL_AMD_draw_buffers_blend;
/*      */   public final boolean GL_AMD_framebuffer_multisample_advanced;
/*      */   public final boolean GL_AMD_gcn_shader;
/*      */   public final boolean GL_AMD_gpu_shader_half_float;
/*      */   public final boolean GL_AMD_gpu_shader_half_float_fetch;
/*      */   public final boolean GL_AMD_gpu_shader_int16;
/*      */   public final boolean GL_AMD_gpu_shader_int64;
/*      */   public final boolean GL_AMD_interleaved_elements;
/*      */   public final boolean GL_AMD_occlusion_query_event;
/*      */   public final boolean GL_AMD_performance_monitor;
/*      */   public final boolean GL_AMD_pinned_memory;
/*      */   public final boolean GL_AMD_query_buffer_object;
/*      */   public final boolean GL_AMD_sample_positions;
/*      */   public final boolean GL_AMD_seamless_cubemap_per_texture;
/*      */   public final boolean GL_AMD_shader_atomic_counter_ops;
/*      */   public final boolean GL_AMD_shader_ballot;
/*      */   public final boolean GL_AMD_shader_explicit_vertex_parameter;
/*      */   public final boolean GL_AMD_shader_image_load_store_lod;
/*      */   public final boolean GL_AMD_shader_stencil_export;
/*      */   public final boolean GL_AMD_shader_trinary_minmax;
/*      */   public final boolean GL_AMD_sparse_texture;
/*      */   public final boolean GL_AMD_stencil_operation_extended;
/*      */   public final boolean GL_AMD_texture_gather_bias_lod;
/*      */   public final boolean GL_AMD_texture_texture4;
/*      */   public final boolean GL_AMD_transform_feedback3_lines_triangles;
/*      */   public final boolean GL_AMD_transform_feedback4;
/*      */   public final boolean GL_AMD_vertex_shader_layer;
/*      */   public final boolean GL_AMD_vertex_shader_tessellator;
/*      */   public final boolean GL_AMD_vertex_shader_viewport_index;
/*      */   public final boolean GL_ARB_arrays_of_arrays;
/*      */   public final boolean GL_ARB_base_instance;
/*      */   public final boolean GL_ARB_bindless_texture;
/*      */   public final boolean GL_ARB_blend_func_extended;
/*      */   public final boolean GL_ARB_buffer_storage;
/*      */   public final boolean GL_ARB_cl_event;
/*      */   public final boolean GL_ARB_clear_buffer_object;
/*      */   public final boolean GL_ARB_clear_texture;
/*      */   public final boolean GL_ARB_clip_control;
/*      */   public final boolean GL_ARB_color_buffer_float;
/*      */   public final boolean GL_ARB_compatibility;
/*      */   public final boolean GL_ARB_compressed_texture_pixel_storage;
/*      */   public final boolean GL_ARB_compute_shader;
/*      */   public final boolean GL_ARB_compute_variable_group_size;
/*      */   public final boolean GL_ARB_conditional_render_inverted;
/*      */   public final boolean GL_ARB_conservative_depth;
/*      */   public final boolean GL_ARB_copy_buffer;
/*      */   public final boolean GL_ARB_copy_image;
/*      */   public final boolean GL_ARB_cull_distance;
/*      */   public final boolean GL_ARB_debug_output;
/*      */   public final boolean GL_ARB_depth_buffer_float;
/*      */   public final boolean GL_ARB_depth_clamp;
/*      */   public final boolean GL_ARB_depth_texture;
/*      */   public final boolean GL_ARB_derivative_control;
/*      */   public final boolean GL_ARB_direct_state_access;
/*      */   public final boolean GL_ARB_draw_buffers;
/*      */   public final boolean GL_ARB_draw_buffers_blend;
/*      */   public final boolean GL_ARB_draw_elements_base_vertex;
/*      */   public final boolean GL_ARB_draw_indirect;
/*      */   public final boolean GL_ARB_draw_instanced;
/*      */   public final boolean GL_ARB_enhanced_layouts;
/*      */   public final boolean GL_ARB_ES2_compatibility;
/*      */   public final boolean GL_ARB_ES3_1_compatibility;
/*      */   public final boolean GL_ARB_ES3_2_compatibility;
/*      */   public final boolean GL_ARB_ES3_compatibility;
/*      */   public final boolean GL_ARB_explicit_attrib_location;
/*      */   public final boolean GL_ARB_explicit_uniform_location;
/*      */   public final boolean GL_ARB_fragment_coord_conventions;
/*      */   public final boolean GL_ARB_fragment_layer_viewport;
/*      */   public final boolean GL_ARB_fragment_program;
/*      */   public final boolean GL_ARB_fragment_program_shadow;
/*      */   public final boolean GL_ARB_fragment_shader;
/*      */   public final boolean GL_ARB_fragment_shader_interlock;
/*      */   public final boolean GL_ARB_framebuffer_no_attachments;
/*      */   public final boolean GL_ARB_framebuffer_object;
/*      */   public final boolean GL_ARB_framebuffer_sRGB;
/*      */   public final boolean GL_ARB_geometry_shader4;
/*      */   public final boolean GL_ARB_get_program_binary;
/*      */   public final boolean GL_ARB_get_texture_sub_image;
/*      */   public final boolean GL_ARB_gl_spirv;
/*      */   public final boolean GL_ARB_gpu_shader5;
/*      */   public final boolean GL_ARB_gpu_shader_fp64;
/*      */   public final boolean GL_ARB_gpu_shader_int64;
/*      */   public final boolean GL_ARB_half_float_pixel;
/*      */   public final boolean GL_ARB_half_float_vertex;
/*      */   public final boolean GL_ARB_imaging;
/*      */   public final boolean GL_ARB_indirect_parameters;
/*      */   public final boolean GL_ARB_instanced_arrays;
/*      */   public final boolean GL_ARB_internalformat_query;
/*      */   public final boolean GL_ARB_internalformat_query2;
/*      */   public final boolean GL_ARB_invalidate_subdata;
/*      */   public final boolean GL_ARB_map_buffer_alignment;
/*      */   public final boolean GL_ARB_map_buffer_range;
/*      */   public final boolean GL_ARB_matrix_palette;
/*      */   public final boolean GL_ARB_multi_bind;
/*      */   public final boolean GL_ARB_multi_draw_indirect;
/*      */   public final boolean GL_ARB_multisample;
/*      */   public final boolean GL_ARB_multitexture;
/*      */   public final boolean GL_ARB_occlusion_query;
/*      */   public final boolean GL_ARB_occlusion_query2;
/*      */   public final boolean GL_ARB_parallel_shader_compile;
/*      */   public final boolean GL_ARB_pipeline_statistics_query;
/*      */   public final boolean GL_ARB_pixel_buffer_object;
/*      */   public final boolean GL_ARB_point_parameters;
/*      */   public final boolean GL_ARB_point_sprite;
/*      */   public final boolean GL_ARB_polygon_offset_clamp;
/*      */   public final boolean GL_ARB_post_depth_coverage;
/*      */   public final boolean GL_ARB_program_interface_query;
/*      */   public final boolean GL_ARB_provoking_vertex;
/*      */   public final boolean GL_ARB_query_buffer_object;
/*      */   public final boolean GL_ARB_robust_buffer_access_behavior;
/*      */   public final boolean GL_ARB_robustness;
/*      */   public final boolean GL_ARB_robustness_application_isolation;
/*      */   public final boolean GL_ARB_robustness_share_group_isolation;
/*      */   public final boolean GL_ARB_sample_locations;
/*      */   public final boolean GL_ARB_sample_shading;
/*      */   public final boolean GL_ARB_sampler_objects;
/*      */   public final boolean GL_ARB_seamless_cube_map;
/*      */   public final boolean GL_ARB_seamless_cubemap_per_texture;
/*      */   public final boolean GL_ARB_separate_shader_objects;
/*      */   public final boolean GL_ARB_shader_atomic_counter_ops;
/*      */   public final boolean GL_ARB_shader_atomic_counters;
/*      */   public final boolean GL_ARB_shader_ballot;
/*      */   public final boolean GL_ARB_shader_bit_encoding;
/*      */   public final boolean GL_ARB_shader_clock;
/*      */   public final boolean GL_ARB_shader_draw_parameters;
/*      */   public final boolean GL_ARB_shader_group_vote;
/*      */   public final boolean GL_ARB_shader_image_load_store;
/*      */   public final boolean GL_ARB_shader_image_size;
/*      */   public final boolean GL_ARB_shader_objects;
/*      */   public final boolean GL_ARB_shader_precision;
/*      */   public final boolean GL_ARB_shader_stencil_export;
/*      */   public final boolean GL_ARB_shader_storage_buffer_object;
/*      */   public final boolean GL_ARB_shader_subroutine;
/*      */   public final boolean GL_ARB_shader_texture_image_samples;
/*      */   public final boolean GL_ARB_shader_texture_lod;
/*      */   public final boolean GL_ARB_shader_viewport_layer_array;
/*      */   public final boolean GL_ARB_shading_language_100;
/*      */   public final boolean GL_ARB_shading_language_420pack;
/*      */   public final boolean GL_ARB_shading_language_include;
/*      */   public final boolean GL_ARB_shading_language_packing;
/*      */   public final boolean GL_ARB_shadow;
/*      */   public final boolean GL_ARB_shadow_ambient;
/*      */   public final boolean GL_ARB_sparse_buffer;
/*      */   public final boolean GL_ARB_sparse_texture;
/*      */   public final boolean GL_ARB_sparse_texture2;
/*      */   public final boolean GL_ARB_sparse_texture_clamp;
/*      */   public final boolean GL_ARB_spirv_extensions;
/*      */   public final boolean GL_ARB_stencil_texturing;
/*      */   public final boolean GL_ARB_sync;
/*      */   public final boolean GL_ARB_tessellation_shader;
/*      */   public final boolean GL_ARB_texture_barrier;
/*      */   public final boolean GL_ARB_texture_border_clamp;
/*      */   public final boolean GL_ARB_texture_buffer_object;
/*      */   public final boolean GL_ARB_texture_buffer_object_rgb32;
/*      */   public final boolean GL_ARB_texture_buffer_range;
/*      */   public final boolean GL_ARB_texture_compression;
/*      */   public final boolean GL_ARB_texture_compression_bptc;
/*      */   public final boolean GL_ARB_texture_compression_rgtc;
/*      */   public final boolean GL_ARB_texture_cube_map;
/*      */   public final boolean GL_ARB_texture_cube_map_array;
/*      */   public final boolean GL_ARB_texture_env_add;
/*      */   public final boolean GL_ARB_texture_env_combine;
/*      */   public final boolean GL_ARB_texture_env_crossbar;
/*      */   public final boolean GL_ARB_texture_env_dot3;
/*      */   public final boolean GL_ARB_texture_filter_anisotropic;
/*      */   public final boolean GL_ARB_texture_filter_minmax;
/*      */   public final boolean GL_ARB_texture_float;
/*      */   public final boolean GL_ARB_texture_gather;
/*      */   public final boolean GL_ARB_texture_mirror_clamp_to_edge;
/*      */   public final boolean GL_ARB_texture_mirrored_repeat;
/*      */   public final boolean GL_ARB_texture_multisample;
/*      */   public final boolean GL_ARB_texture_non_power_of_two;
/*      */   public final boolean GL_ARB_texture_query_levels;
/*      */   public final boolean GL_ARB_texture_query_lod;
/*      */   public final boolean GL_ARB_texture_rectangle;
/*      */   public final boolean GL_ARB_texture_rg;
/*      */   public final boolean GL_ARB_texture_rgb10_a2ui;
/*      */   public final boolean GL_ARB_texture_stencil8;
/*      */   public final boolean GL_ARB_texture_storage;
/*      */   public final boolean GL_ARB_texture_storage_multisample;
/*      */   public final boolean GL_ARB_texture_swizzle;
/*      */   public final boolean GL_ARB_texture_view;
/*      */   public final boolean GL_ARB_timer_query;
/*      */   public final boolean GL_ARB_transform_feedback2;
/*      */   public final boolean GL_ARB_transform_feedback3;
/*      */   public final boolean GL_ARB_transform_feedback_instanced;
/*      */   public final boolean GL_ARB_transform_feedback_overflow_query;
/*      */   public final boolean GL_ARB_transpose_matrix;
/*      */   public final boolean GL_ARB_uniform_buffer_object;
/*      */   public final boolean GL_ARB_vertex_array_bgra;
/*      */   public final boolean GL_ARB_vertex_array_object;
/*      */   public final boolean GL_ARB_vertex_attrib_64bit;
/*      */   public final boolean GL_ARB_vertex_attrib_binding;
/*      */   public final boolean GL_ARB_vertex_blend;
/*      */   public final boolean GL_ARB_vertex_buffer_object;
/*      */   public final boolean GL_ARB_vertex_program;
/*      */   public final boolean GL_ARB_vertex_shader;
/*      */   public final boolean GL_ARB_vertex_type_10f_11f_11f_rev;
/*      */   public final boolean GL_ARB_vertex_type_2_10_10_10_rev;
/*      */   public final boolean GL_ARB_viewport_array;
/*      */   public final boolean GL_ARB_window_pos;
/*      */   public final boolean GL_ATI_meminfo;
/*      */   public final boolean GL_ATI_shader_texture_lod;
/*      */   public final boolean GL_ATI_texture_compression_3dc;
/*      */   public final boolean GL_EXT_422_pixels;
/*      */   public final boolean GL_EXT_abgr;
/*      */   public final boolean GL_EXT_bgra;
/*      */   public final boolean GL_EXT_bindable_uniform;
/*      */   public final boolean GL_EXT_blend_color;
/*      */   public final boolean GL_EXT_blend_equation_separate;
/*      */   public final boolean GL_EXT_blend_func_separate;
/*      */   public final boolean GL_EXT_blend_minmax;
/*      */   public final boolean GL_EXT_blend_subtract;
/*      */   public final boolean GL_EXT_clip_volume_hint;
/*      */   public final boolean GL_EXT_compiled_vertex_array;
/*      */   public final boolean GL_EXT_debug_label;
/*      */   public final boolean GL_EXT_debug_marker;
/*      */   public final boolean GL_EXT_depth_bounds_test;
/*      */   public final boolean GL_EXT_direct_state_access;
/*      */   public final boolean GL_EXT_draw_buffers2;
/*      */   public final boolean GL_EXT_draw_instanced;
/*      */   public final boolean GL_EXT_EGL_image_storage;
/*      */   public final boolean GL_EXT_EGL_sync;
/*      */   public final boolean GL_EXT_external_buffer;
/*      */   public final boolean GL_EXT_fragment_shading_rate;
/*      */   public final boolean GL_EXT_fragment_shading_rate_attachment;
/*      */   public final boolean GL_EXT_fragment_shading_rate_primitive;
/*      */   public final boolean GL_EXT_framebuffer_blit;
/*      */   public final boolean GL_EXT_framebuffer_blit_layers;
/*      */   public final boolean GL_EXT_framebuffer_multisample;
/*      */   public final boolean GL_EXT_framebuffer_multisample_blit_scaled;
/*      */   public final boolean GL_EXT_framebuffer_object;
/*      */   public final boolean GL_EXT_framebuffer_sRGB;
/*      */   public final boolean GL_EXT_geometry_shader4;
/*      */   public final boolean GL_EXT_gpu_program_parameters;
/*      */   public final boolean GL_EXT_gpu_shader4;
/*      */   public final boolean GL_EXT_memory_object;
/*      */   public final boolean GL_EXT_memory_object_fd;
/*      */   public final boolean GL_EXT_memory_object_win32;
/*      */   public final boolean GL_EXT_mesh_shader;
/*      */   public final boolean GL_EXT_multiview_tessellation_geometry_shader;
/*      */   public final boolean GL_EXT_multiview_texture_multisample;
/*      */   public final boolean GL_EXT_multiview_timer_query;
/*      */   public final boolean GL_EXT_packed_depth_stencil;
/*      */   public final boolean GL_EXT_packed_float;
/*      */   public final boolean GL_EXT_pixel_buffer_object;
/*      */   public final boolean GL_EXT_point_parameters;
/*      */   public final boolean GL_EXT_polygon_offset_clamp;
/*      */   public final boolean GL_EXT_post_depth_coverage;
/*      */   public final boolean GL_EXT_provoking_vertex;
/*      */   public final boolean GL_EXT_raster_multisample;
/*      */   public final boolean GL_EXT_secondary_color;
/*      */   public final boolean GL_EXT_semaphore;
/*      */   public final boolean GL_EXT_semaphore_fd;
/*      */   public final boolean GL_EXT_semaphore_win32;
/*      */   public final boolean GL_EXT_separate_shader_objects;
/*      */   public final boolean GL_EXT_shader_framebuffer_fetch;
/*      */   public final boolean GL_EXT_shader_framebuffer_fetch_non_coherent;
/*      */   public final boolean GL_EXT_shader_image_load_formatted;
/*      */   public final boolean GL_EXT_shader_image_load_store;
/*      */   public final boolean GL_EXT_shader_integer_mix;
/*      */   public final boolean GL_EXT_shader_realtime_clock;
/*      */   public final boolean GL_EXT_shader_samples_identical;
/*      */   public final boolean GL_EXT_shader_texture_samples;
/*      */   public final boolean GL_EXT_shadow_funcs;
/*      */   public final boolean GL_EXT_shared_texture_palette;
/*      */   public final boolean GL_EXT_sparse_texture2;
/*      */   public final boolean GL_EXT_stencil_clear_tag;
/*      */   public final boolean GL_EXT_stencil_two_side;
/*      */   public final boolean GL_EXT_stencil_wrap;
/*      */   public final boolean GL_EXT_texture_array;
/*      */   public final boolean GL_EXT_texture_buffer_object;
/*      */   public final boolean GL_EXT_texture_compression_latc;
/*      */   public final boolean GL_EXT_texture_compression_rgtc;
/*      */   public final boolean GL_EXT_texture_compression_s3tc;
/*      */   public final boolean GL_EXT_texture_filter_anisotropic;
/*      */   public final boolean GL_EXT_texture_filter_minmax;
/*      */   public final boolean GL_EXT_texture_integer;
/*      */   public final boolean GL_EXT_texture_mirror_clamp;
/*      */   public final boolean GL_EXT_texture_shadow_lod;
/*      */   public final boolean GL_EXT_texture_shared_exponent;
/*      */   public final boolean GL_EXT_texture_snorm;
/*      */   public final boolean GL_EXT_texture_sRGB;
/*      */   public final boolean GL_EXT_texture_sRGB_decode;
/*      */   public final boolean GL_EXT_texture_sRGB_R8;
/*      */   public final boolean GL_EXT_texture_sRGB_RG8;
/*      */   public final boolean GL_EXT_texture_storage;
/*      */   public final boolean GL_EXT_texture_swizzle;
/*      */   public final boolean GL_EXT_timer_query;
/*      */   public final boolean GL_EXT_transform_feedback;
/*      */   public final boolean GL_EXT_vertex_array_bgra;
/*      */   public final boolean GL_EXT_vertex_attrib_64bit;
/*      */   public final boolean GL_EXT_win32_keyed_mutex;
/*      */   public final boolean GL_EXT_window_rectangles;
/*      */   public final boolean GL_EXT_x11_sync_object;
/*      */   public final boolean GL_GREMEDY_frame_terminator;
/*      */   public final boolean GL_GREMEDY_string_marker;
/*      */   public final boolean GL_INTEL_blackhole_render;
/*      */   public final boolean GL_INTEL_conservative_rasterization;
/*      */   public final boolean GL_INTEL_fragment_shader_ordering;
/*      */   public final boolean GL_INTEL_framebuffer_CMAA;
/*      */   public final boolean GL_INTEL_map_texture;
/*      */   public final boolean GL_INTEL_performance_query;
/*      */   public final boolean GL_INTEL_shader_integer_functions2;
/*      */   public final boolean GL_KHR_blend_equation_advanced;
/*      */   public final boolean GL_KHR_blend_equation_advanced_coherent;
/*      */   public final boolean GL_KHR_context_flush_control;
/*      */   public final boolean GL_KHR_debug;
/*      */   public final boolean GL_KHR_no_error;
/*      */   public final boolean GL_KHR_parallel_shader_compile;
/*      */   public final boolean GL_KHR_robust_buffer_access_behavior;
/*      */   public final boolean GL_KHR_robustness;
/*      */   public final boolean GL_KHR_shader_subgroup;
/*      */   public final boolean GL_KHR_texture_compression_astc_hdr;
/*      */   public final boolean GL_KHR_texture_compression_astc_ldr;
/*      */   public final boolean GL_KHR_texture_compression_astc_sliced_3d;
/*      */   public final boolean GL_MESA_framebuffer_flip_x;
/*      */   public final boolean GL_MESA_framebuffer_flip_y;
/*      */   public final boolean GL_MESA_framebuffer_swap_xy;
/*      */   public final boolean GL_MESA_tile_raster_order;
/*      */   public final boolean GL_NV_alpha_to_coverage_dither_control;
/*      */   public final boolean GL_NV_bindless_multi_draw_indirect;
/*      */   public final boolean GL_NV_bindless_multi_draw_indirect_count;
/*      */   public final boolean GL_NV_bindless_texture;
/*      */   public final boolean GL_NV_blend_equation_advanced;
/*      */   public final boolean GL_NV_blend_equation_advanced_coherent;
/*      */   public final boolean GL_NV_blend_minmax_factor;
/*      */   public final boolean GL_NV_blend_square;
/*      */   public final boolean GL_NV_clip_space_w_scaling;
/*      */   public final boolean GL_NV_command_list;
/*      */   public final boolean GL_NV_compute_shader_derivatives;
/*      */   public final boolean GL_NV_conditional_render;
/*      */   public final boolean GL_NV_conservative_raster;
/*      */   public final boolean GL_NV_conservative_raster_dilate;
/*      */   public final boolean GL_NV_conservative_raster_pre_snap;
/*      */   public final boolean GL_NV_conservative_raster_pre_snap_triangles;
/*      */   public final boolean GL_NV_conservative_raster_underestimation;
/*      */   public final boolean GL_NV_copy_depth_to_color;
/*      */   public final boolean GL_NV_copy_image;
/*      */   public final boolean GL_NV_deep_texture3D;
/*      */   public final boolean GL_NV_depth_buffer_float;
/*      */   public final boolean GL_NV_depth_clamp;
/*      */   public final boolean GL_NV_draw_texture;
/*      */   public final boolean GL_NV_draw_vulkan_image;
/*      */   public final boolean GL_NV_ES3_1_compatibility;
/*      */   public final boolean GL_NV_explicit_multisample;
/*      */   public final boolean GL_NV_fence;
/*      */   public final boolean GL_NV_fill_rectangle;
/*      */   public final boolean GL_NV_float_buffer;
/*      */   public final boolean GL_NV_fog_distance;
/*      */   public final boolean GL_NV_fragment_coverage_to_color;
/*      */   public final boolean GL_NV_fragment_program4;
/*      */   public final boolean GL_NV_fragment_program_option;
/*      */   public final boolean GL_NV_fragment_shader_barycentric;
/*      */   public final boolean GL_NV_fragment_shader_interlock;
/*      */   public final boolean GL_NV_framebuffer_mixed_samples;
/*      */   public final boolean GL_NV_framebuffer_multisample_coverage;
/*      */   public final boolean GL_NV_geometry_shader4;
/*      */   public final boolean GL_NV_geometry_shader_passthrough;
/*      */   public final boolean GL_NV_gpu_multicast;
/*      */   public final boolean GL_NV_gpu_shader5;
/*      */   public final boolean GL_NV_half_float;
/*      */   public final boolean GL_NV_internalformat_sample_query;
/*      */   public final boolean GL_NV_light_max_exponent;
/*      */   public final boolean GL_NV_memory_attachment;
/*      */   public final boolean GL_NV_memory_object_sparse;
/*      */   public final boolean GL_NV_mesh_shader;
/*      */   public final boolean GL_NV_multisample_coverage;
/*      */   public final boolean GL_NV_multisample_filter_hint;
/*      */   public final boolean GL_NV_packed_depth_stencil;
/*      */   public final boolean GL_NV_path_rendering;
/*      */   public final boolean GL_NV_path_rendering_shared_edge;
/*      */   public final boolean GL_NV_pixel_data_range;
/*      */   public final boolean GL_NV_point_sprite;
/*      */   public final boolean GL_NV_primitive_restart;
/*      */   public final boolean GL_NV_primitive_shading_rate;
/*      */   public final boolean GL_NV_query_resource;
/*      */   public final boolean GL_NV_query_resource_tag;
/*      */   public final boolean GL_NV_representative_fragment_test;
/*      */   public final boolean GL_NV_robustness_video_memory_purge;
/*      */   public final boolean GL_NV_sample_locations;
/*      */   public final boolean GL_NV_sample_mask_override_coverage;
/*      */   public final boolean GL_NV_scissor_exclusive;
/*      */   public final boolean GL_NV_shader_atomic_float;
/*      */   public final boolean GL_NV_shader_atomic_float64;
/*      */   public final boolean GL_NV_shader_atomic_fp16_vector;
/*      */   public final boolean GL_NV_shader_atomic_int64;
/*      */   public final boolean GL_NV_shader_buffer_load;
/*      */   public final boolean GL_NV_shader_buffer_store;
/*      */   public final boolean GL_NV_shader_subgroup_partitioned;
/*      */   public final boolean GL_NV_shader_texture_footprint;
/*      */   public final boolean GL_NV_shader_thread_group;
/*      */   public final boolean GL_NV_shader_thread_shuffle;
/*      */   public final boolean GL_NV_shading_rate_image;
/*      */   public final boolean GL_NV_stereo_view_rendering;
/*      */   public final boolean GL_NV_texgen_reflection;
/*      */   public final boolean GL_NV_texture_barrier;
/*      */   public final boolean GL_NV_texture_compression_vtc;
/*      */   public final boolean GL_NV_texture_multisample;
/*      */   public final boolean GL_NV_texture_rectangle_compressed;
/*      */   public final boolean GL_NV_texture_shader;
/*      */   public final boolean GL_NV_texture_shader2;
/*      */   public final boolean GL_NV_texture_shader3;
/*      */   public final boolean GL_NV_timeline_semaphore;
/*      */   public final boolean GL_NV_transform_feedback;
/*      */   public final boolean GL_NV_transform_feedback2;
/*      */   public final boolean GL_NV_uniform_buffer_std430_layout;
/*      */   public final boolean GL_NV_uniform_buffer_unified_memory;
/*      */   public final boolean GL_NV_vertex_array_range;
/*      */   public final boolean GL_NV_vertex_array_range2;
/*      */   public final boolean GL_NV_vertex_attrib_integer_64bit;
/*      */   public final boolean GL_NV_vertex_buffer_unified_memory;
/*      */   public final boolean GL_NV_viewport_array2;
/*      */   public final boolean GL_NV_viewport_swizzle;
/*      */   public final boolean GL_NVX_blend_equation_advanced_multi_draw_buffers;
/*      */   public final boolean GL_NVX_conditional_render;
/*      */   public final boolean GL_NVX_gpu_memory_info;
/*      */   public final boolean GL_NVX_gpu_multicast2;
/*      */   public final boolean GL_NVX_progress_fence;
/*      */   public final boolean GL_OVR_multiview;
/*      */   public final boolean GL_OVR_multiview2;
/*      */   public final boolean GL_S3_s3tc;
/*      */   public final boolean forwardCompatible;
/*      */   final PointerBuffer addresses;
/*      */   
/*      */   GLCapabilities(FunctionProvider provider, Set<String> ext, boolean fc, IntFunction<PointerBuffer> bufferFactory) {
/* 3689 */     this.forwardCompatible = fc;
/*      */     
/* 3691 */     PointerBuffer caps = bufferFactory.apply(2236);
/*      */     
/* 3693 */     this.OpenGL11 = check_GL11(provider, caps, ext, fc);
/* 3694 */     this.OpenGL12 = check_GL12(provider, caps, ext);
/* 3695 */     this.OpenGL13 = check_GL13(provider, caps, ext, fc);
/* 3696 */     this.OpenGL14 = check_GL14(provider, caps, ext, fc);
/* 3697 */     this.OpenGL15 = check_GL15(provider, caps, ext);
/* 3698 */     this.OpenGL20 = check_GL20(provider, caps, ext);
/* 3699 */     this.OpenGL21 = check_GL21(provider, caps, ext);
/* 3700 */     this.OpenGL30 = check_GL30(provider, caps, ext);
/* 3701 */     this.OpenGL31 = check_GL31(provider, caps, ext);
/* 3702 */     this.OpenGL32 = check_GL32(provider, caps, ext);
/* 3703 */     this.OpenGL33 = check_GL33(provider, caps, ext, fc);
/* 3704 */     this.OpenGL40 = check_GL40(provider, caps, ext);
/* 3705 */     this.OpenGL41 = check_GL41(provider, caps, ext);
/* 3706 */     this.OpenGL42 = check_GL42(provider, caps, ext);
/* 3707 */     this.OpenGL43 = check_GL43(provider, caps, ext);
/* 3708 */     this.OpenGL44 = check_GL44(provider, caps, ext);
/* 3709 */     this.OpenGL45 = check_GL45(provider, caps, ext);
/* 3710 */     this.OpenGL46 = check_GL46(provider, caps, ext);
/* 3711 */     this.GL_3DFX_texture_compression_FXT1 = ext.contains("GL_3DFX_texture_compression_FXT1");
/* 3712 */     this.GL_AMD_blend_minmax_factor = ext.contains("GL_AMD_blend_minmax_factor");
/* 3713 */     this.GL_AMD_conservative_depth = ext.contains("GL_AMD_conservative_depth");
/* 3714 */     this.GL_AMD_debug_output = check_AMD_debug_output(provider, caps, ext);
/* 3715 */     this.GL_AMD_depth_clamp_separate = ext.contains("GL_AMD_depth_clamp_separate");
/* 3716 */     this.GL_AMD_draw_buffers_blend = check_AMD_draw_buffers_blend(provider, caps, ext);
/* 3717 */     this.GL_AMD_framebuffer_multisample_advanced = check_AMD_framebuffer_multisample_advanced(provider, caps, ext);
/* 3718 */     this.GL_AMD_gcn_shader = ext.contains("GL_AMD_gcn_shader");
/* 3719 */     this.GL_AMD_gpu_shader_half_float = ext.contains("GL_AMD_gpu_shader_half_float");
/* 3720 */     this.GL_AMD_gpu_shader_half_float_fetch = ext.contains("GL_AMD_gpu_shader_half_float_fetch");
/* 3721 */     this.GL_AMD_gpu_shader_int16 = ext.contains("GL_AMD_gpu_shader_int16");
/* 3722 */     this.GL_AMD_gpu_shader_int64 = check_AMD_gpu_shader_int64(provider, caps, ext);
/* 3723 */     this.GL_AMD_interleaved_elements = check_AMD_interleaved_elements(provider, caps, ext);
/* 3724 */     this.GL_AMD_occlusion_query_event = check_AMD_occlusion_query_event(provider, caps, ext);
/* 3725 */     this.GL_AMD_performance_monitor = check_AMD_performance_monitor(provider, caps, ext);
/* 3726 */     this.GL_AMD_pinned_memory = ext.contains("GL_AMD_pinned_memory");
/* 3727 */     this.GL_AMD_query_buffer_object = ext.contains("GL_AMD_query_buffer_object");
/* 3728 */     this.GL_AMD_sample_positions = check_AMD_sample_positions(provider, caps, ext);
/* 3729 */     this.GL_AMD_seamless_cubemap_per_texture = ext.contains("GL_AMD_seamless_cubemap_per_texture");
/* 3730 */     this.GL_AMD_shader_atomic_counter_ops = ext.contains("GL_AMD_shader_atomic_counter_ops");
/* 3731 */     this.GL_AMD_shader_ballot = ext.contains("GL_AMD_shader_ballot");
/* 3732 */     this.GL_AMD_shader_explicit_vertex_parameter = ext.contains("GL_AMD_shader_explicit_vertex_parameter");
/* 3733 */     this.GL_AMD_shader_image_load_store_lod = ext.contains("GL_AMD_shader_image_load_store_lod");
/* 3734 */     this.GL_AMD_shader_stencil_export = ext.contains("GL_AMD_shader_stencil_export");
/* 3735 */     this.GL_AMD_shader_trinary_minmax = ext.contains("GL_AMD_shader_trinary_minmax");
/* 3736 */     this.GL_AMD_sparse_texture = check_AMD_sparse_texture(provider, caps, ext);
/* 3737 */     this.GL_AMD_stencil_operation_extended = check_AMD_stencil_operation_extended(provider, caps, ext);
/* 3738 */     this.GL_AMD_texture_gather_bias_lod = ext.contains("GL_AMD_texture_gather_bias_lod");
/* 3739 */     this.GL_AMD_texture_texture4 = ext.contains("GL_AMD_texture_texture4");
/* 3740 */     this.GL_AMD_transform_feedback3_lines_triangles = ext.contains("GL_AMD_transform_feedback3_lines_triangles");
/* 3741 */     this.GL_AMD_transform_feedback4 = ext.contains("GL_AMD_transform_feedback4");
/* 3742 */     this.GL_AMD_vertex_shader_layer = ext.contains("GL_AMD_vertex_shader_layer");
/* 3743 */     this.GL_AMD_vertex_shader_tessellator = check_AMD_vertex_shader_tessellator(provider, caps, ext);
/* 3744 */     this.GL_AMD_vertex_shader_viewport_index = ext.contains("GL_AMD_vertex_shader_viewport_index");
/* 3745 */     this.GL_ARB_arrays_of_arrays = ext.contains("GL_ARB_arrays_of_arrays");
/* 3746 */     this.GL_ARB_base_instance = check_ARB_base_instance(provider, caps, ext);
/* 3747 */     this.GL_ARB_bindless_texture = check_ARB_bindless_texture(provider, caps, ext);
/* 3748 */     this.GL_ARB_blend_func_extended = check_ARB_blend_func_extended(provider, caps, ext);
/* 3749 */     this.GL_ARB_buffer_storage = check_ARB_buffer_storage(provider, caps, ext);
/* 3750 */     this.GL_ARB_cl_event = check_ARB_cl_event(provider, caps, ext);
/* 3751 */     this.GL_ARB_clear_buffer_object = check_ARB_clear_buffer_object(provider, caps, ext);
/* 3752 */     this.GL_ARB_clear_texture = check_ARB_clear_texture(provider, caps, ext);
/* 3753 */     this.GL_ARB_clip_control = check_ARB_clip_control(provider, caps, ext);
/* 3754 */     this.GL_ARB_color_buffer_float = check_ARB_color_buffer_float(provider, caps, ext);
/* 3755 */     this.GL_ARB_compatibility = ext.contains("GL_ARB_compatibility");
/* 3756 */     this.GL_ARB_compressed_texture_pixel_storage = ext.contains("GL_ARB_compressed_texture_pixel_storage");
/* 3757 */     this.GL_ARB_compute_shader = check_ARB_compute_shader(provider, caps, ext);
/* 3758 */     this.GL_ARB_compute_variable_group_size = check_ARB_compute_variable_group_size(provider, caps, ext);
/* 3759 */     this.GL_ARB_conditional_render_inverted = ext.contains("GL_ARB_conditional_render_inverted");
/* 3760 */     this.GL_ARB_conservative_depth = ext.contains("GL_ARB_conservative_depth");
/* 3761 */     this.GL_ARB_copy_buffer = check_ARB_copy_buffer(provider, caps, ext);
/* 3762 */     this.GL_ARB_copy_image = check_ARB_copy_image(provider, caps, ext);
/* 3763 */     this.GL_ARB_cull_distance = ext.contains("GL_ARB_cull_distance");
/* 3764 */     this.GL_ARB_debug_output = check_ARB_debug_output(provider, caps, ext);
/* 3765 */     this.GL_ARB_depth_buffer_float = ext.contains("GL_ARB_depth_buffer_float");
/* 3766 */     this.GL_ARB_depth_clamp = ext.contains("GL_ARB_depth_clamp");
/* 3767 */     this.GL_ARB_depth_texture = ext.contains("GL_ARB_depth_texture");
/* 3768 */     this.GL_ARB_derivative_control = ext.contains("GL_ARB_derivative_control");
/* 3769 */     this.GL_ARB_direct_state_access = check_ARB_direct_state_access(provider, caps, ext);
/* 3770 */     this.GL_ARB_draw_buffers = check_ARB_draw_buffers(provider, caps, ext);
/* 3771 */     this.GL_ARB_draw_buffers_blend = check_ARB_draw_buffers_blend(provider, caps, ext);
/* 3772 */     this.GL_ARB_draw_elements_base_vertex = check_ARB_draw_elements_base_vertex(provider, caps, ext);
/* 3773 */     this.GL_ARB_draw_indirect = check_ARB_draw_indirect(provider, caps, ext);
/* 3774 */     this.GL_ARB_draw_instanced = check_ARB_draw_instanced(provider, caps, ext);
/* 3775 */     this.GL_ARB_enhanced_layouts = ext.contains("GL_ARB_enhanced_layouts");
/* 3776 */     this.GL_ARB_ES2_compatibility = check_ARB_ES2_compatibility(provider, caps, ext);
/* 3777 */     this.GL_ARB_ES3_1_compatibility = check_ARB_ES3_1_compatibility(provider, caps, ext);
/* 3778 */     this.GL_ARB_ES3_2_compatibility = check_ARB_ES3_2_compatibility(provider, caps, ext);
/* 3779 */     this.GL_ARB_ES3_compatibility = ext.contains("GL_ARB_ES3_compatibility");
/* 3780 */     this.GL_ARB_explicit_attrib_location = ext.contains("GL_ARB_explicit_attrib_location");
/* 3781 */     this.GL_ARB_explicit_uniform_location = ext.contains("GL_ARB_explicit_uniform_location");
/* 3782 */     this.GL_ARB_fragment_coord_conventions = ext.contains("GL_ARB_fragment_coord_conventions");
/* 3783 */     this.GL_ARB_fragment_layer_viewport = ext.contains("GL_ARB_fragment_layer_viewport");
/* 3784 */     this.GL_ARB_fragment_program = ext.contains("GL_ARB_fragment_program");
/* 3785 */     this.GL_ARB_fragment_program_shadow = ext.contains("GL_ARB_fragment_program_shadow");
/* 3786 */     this.GL_ARB_fragment_shader = ext.contains("GL_ARB_fragment_shader");
/* 3787 */     this.GL_ARB_fragment_shader_interlock = ext.contains("GL_ARB_fragment_shader_interlock");
/* 3788 */     this.GL_ARB_framebuffer_no_attachments = check_ARB_framebuffer_no_attachments(provider, caps, ext);
/* 3789 */     this.GL_ARB_framebuffer_object = check_ARB_framebuffer_object(provider, caps, ext);
/* 3790 */     this.GL_ARB_framebuffer_sRGB = ext.contains("GL_ARB_framebuffer_sRGB");
/* 3791 */     this.GL_ARB_geometry_shader4 = check_ARB_geometry_shader4(provider, caps, ext);
/* 3792 */     this.GL_ARB_get_program_binary = check_ARB_get_program_binary(provider, caps, ext);
/* 3793 */     this.GL_ARB_get_texture_sub_image = check_ARB_get_texture_sub_image(provider, caps, ext);
/* 3794 */     this.GL_ARB_gl_spirv = check_ARB_gl_spirv(provider, caps, ext);
/* 3795 */     this.GL_ARB_gpu_shader5 = ext.contains("GL_ARB_gpu_shader5");
/* 3796 */     this.GL_ARB_gpu_shader_fp64 = check_ARB_gpu_shader_fp64(provider, caps, ext);
/* 3797 */     this.GL_ARB_gpu_shader_int64 = check_ARB_gpu_shader_int64(provider, caps, ext);
/* 3798 */     this.GL_ARB_half_float_pixel = ext.contains("GL_ARB_half_float_pixel");
/* 3799 */     this.GL_ARB_half_float_vertex = ext.contains("GL_ARB_half_float_vertex");
/* 3800 */     this.GL_ARB_imaging = check_ARB_imaging(provider, caps, ext, fc);
/* 3801 */     this.GL_ARB_indirect_parameters = check_ARB_indirect_parameters(provider, caps, ext);
/* 3802 */     this.GL_ARB_instanced_arrays = check_ARB_instanced_arrays(provider, caps, ext);
/* 3803 */     this.GL_ARB_internalformat_query = check_ARB_internalformat_query(provider, caps, ext);
/* 3804 */     this.GL_ARB_internalformat_query2 = check_ARB_internalformat_query2(provider, caps, ext);
/* 3805 */     this.GL_ARB_invalidate_subdata = check_ARB_invalidate_subdata(provider, caps, ext);
/* 3806 */     this.GL_ARB_map_buffer_alignment = ext.contains("GL_ARB_map_buffer_alignment");
/* 3807 */     this.GL_ARB_map_buffer_range = check_ARB_map_buffer_range(provider, caps, ext);
/* 3808 */     this.GL_ARB_matrix_palette = check_ARB_matrix_palette(provider, caps, ext);
/* 3809 */     this.GL_ARB_multi_bind = check_ARB_multi_bind(provider, caps, ext);
/* 3810 */     this.GL_ARB_multi_draw_indirect = check_ARB_multi_draw_indirect(provider, caps, ext);
/* 3811 */     this.GL_ARB_multisample = check_ARB_multisample(provider, caps, ext);
/* 3812 */     this.GL_ARB_multitexture = check_ARB_multitexture(provider, caps, ext);
/* 3813 */     this.GL_ARB_occlusion_query = check_ARB_occlusion_query(provider, caps, ext);
/* 3814 */     this.GL_ARB_occlusion_query2 = ext.contains("GL_ARB_occlusion_query2");
/* 3815 */     this.GL_ARB_parallel_shader_compile = check_ARB_parallel_shader_compile(provider, caps, ext);
/* 3816 */     this.GL_ARB_pipeline_statistics_query = ext.contains("GL_ARB_pipeline_statistics_query");
/* 3817 */     this.GL_ARB_pixel_buffer_object = ext.contains("GL_ARB_pixel_buffer_object");
/* 3818 */     this.GL_ARB_point_parameters = check_ARB_point_parameters(provider, caps, ext);
/* 3819 */     this.GL_ARB_point_sprite = ext.contains("GL_ARB_point_sprite");
/* 3820 */     this.GL_ARB_polygon_offset_clamp = check_ARB_polygon_offset_clamp(provider, caps, ext);
/* 3821 */     this.GL_ARB_post_depth_coverage = ext.contains("GL_ARB_post_depth_coverage");
/* 3822 */     this.GL_ARB_program_interface_query = check_ARB_program_interface_query(provider, caps, ext);
/* 3823 */     this.GL_ARB_provoking_vertex = check_ARB_provoking_vertex(provider, caps, ext);
/* 3824 */     this.GL_ARB_query_buffer_object = ext.contains("GL_ARB_query_buffer_object");
/* 3825 */     this.GL_ARB_robust_buffer_access_behavior = ext.contains("GL_ARB_robust_buffer_access_behavior");
/* 3826 */     this.GL_ARB_robustness = check_ARB_robustness(provider, caps, ext);
/* 3827 */     this.GL_ARB_robustness_application_isolation = ext.contains("GL_ARB_robustness_application_isolation");
/* 3828 */     this.GL_ARB_robustness_share_group_isolation = ext.contains("GL_ARB_robustness_share_group_isolation");
/* 3829 */     this.GL_ARB_sample_locations = check_ARB_sample_locations(provider, caps, ext);
/* 3830 */     this.GL_ARB_sample_shading = check_ARB_sample_shading(provider, caps, ext);
/* 3831 */     this.GL_ARB_sampler_objects = check_ARB_sampler_objects(provider, caps, ext);
/* 3832 */     this.GL_ARB_seamless_cube_map = ext.contains("GL_ARB_seamless_cube_map");
/* 3833 */     this.GL_ARB_seamless_cubemap_per_texture = ext.contains("GL_ARB_seamless_cubemap_per_texture");
/* 3834 */     this.GL_ARB_separate_shader_objects = check_ARB_separate_shader_objects(provider, caps, ext);
/* 3835 */     this.GL_ARB_shader_atomic_counter_ops = ext.contains("GL_ARB_shader_atomic_counter_ops");
/* 3836 */     this.GL_ARB_shader_atomic_counters = check_ARB_shader_atomic_counters(provider, caps, ext);
/* 3837 */     this.GL_ARB_shader_ballot = ext.contains("GL_ARB_shader_ballot");
/* 3838 */     this.GL_ARB_shader_bit_encoding = ext.contains("GL_ARB_shader_bit_encoding");
/* 3839 */     this.GL_ARB_shader_clock = ext.contains("GL_ARB_shader_clock");
/* 3840 */     this.GL_ARB_shader_draw_parameters = ext.contains("GL_ARB_shader_draw_parameters");
/* 3841 */     this.GL_ARB_shader_group_vote = ext.contains("GL_ARB_shader_group_vote");
/* 3842 */     this.GL_ARB_shader_image_load_store = check_ARB_shader_image_load_store(provider, caps, ext);
/* 3843 */     this.GL_ARB_shader_image_size = ext.contains("GL_ARB_shader_image_size");
/* 3844 */     this.GL_ARB_shader_objects = check_ARB_shader_objects(provider, caps, ext);
/* 3845 */     this.GL_ARB_shader_precision = ext.contains("GL_ARB_shader_precision");
/* 3846 */     this.GL_ARB_shader_stencil_export = ext.contains("GL_ARB_shader_stencil_export");
/* 3847 */     this.GL_ARB_shader_storage_buffer_object = check_ARB_shader_storage_buffer_object(provider, caps, ext);
/* 3848 */     this.GL_ARB_shader_subroutine = check_ARB_shader_subroutine(provider, caps, ext);
/* 3849 */     this.GL_ARB_shader_texture_image_samples = ext.contains("GL_ARB_shader_texture_image_samples");
/* 3850 */     this.GL_ARB_shader_texture_lod = ext.contains("GL_ARB_shader_texture_lod");
/* 3851 */     this.GL_ARB_shader_viewport_layer_array = ext.contains("GL_ARB_shader_viewport_layer_array");
/* 3852 */     this.GL_ARB_shading_language_100 = ext.contains("GL_ARB_shading_language_100");
/* 3853 */     this.GL_ARB_shading_language_420pack = ext.contains("GL_ARB_shading_language_420pack");
/* 3854 */     this.GL_ARB_shading_language_include = check_ARB_shading_language_include(provider, caps, ext);
/* 3855 */     this.GL_ARB_shading_language_packing = ext.contains("GL_ARB_shading_language_packing");
/* 3856 */     this.GL_ARB_shadow = ext.contains("GL_ARB_shadow");
/* 3857 */     this.GL_ARB_shadow_ambient = ext.contains("GL_ARB_shadow_ambient");
/* 3858 */     this.GL_ARB_sparse_buffer = check_ARB_sparse_buffer(provider, caps, ext);
/* 3859 */     this.GL_ARB_sparse_texture = check_ARB_sparse_texture(provider, caps, ext);
/* 3860 */     this.GL_ARB_sparse_texture2 = ext.contains("GL_ARB_sparse_texture2");
/* 3861 */     this.GL_ARB_sparse_texture_clamp = ext.contains("GL_ARB_sparse_texture_clamp");
/* 3862 */     this.GL_ARB_spirv_extensions = ext.contains("GL_ARB_spirv_extensions");
/* 3863 */     this.GL_ARB_stencil_texturing = ext.contains("GL_ARB_stencil_texturing");
/* 3864 */     this.GL_ARB_sync = check_ARB_sync(provider, caps, ext);
/* 3865 */     this.GL_ARB_tessellation_shader = check_ARB_tessellation_shader(provider, caps, ext);
/* 3866 */     this.GL_ARB_texture_barrier = check_ARB_texture_barrier(provider, caps, ext);
/* 3867 */     this.GL_ARB_texture_border_clamp = ext.contains("GL_ARB_texture_border_clamp");
/* 3868 */     this.GL_ARB_texture_buffer_object = check_ARB_texture_buffer_object(provider, caps, ext);
/* 3869 */     this.GL_ARB_texture_buffer_object_rgb32 = ext.contains("GL_ARB_texture_buffer_object_rgb32");
/* 3870 */     this.GL_ARB_texture_buffer_range = check_ARB_texture_buffer_range(provider, caps, ext);
/* 3871 */     this.GL_ARB_texture_compression = check_ARB_texture_compression(provider, caps, ext);
/* 3872 */     this.GL_ARB_texture_compression_bptc = ext.contains("GL_ARB_texture_compression_bptc");
/* 3873 */     this.GL_ARB_texture_compression_rgtc = ext.contains("GL_ARB_texture_compression_rgtc");
/* 3874 */     this.GL_ARB_texture_cube_map = ext.contains("GL_ARB_texture_cube_map");
/* 3875 */     this.GL_ARB_texture_cube_map_array = ext.contains("GL_ARB_texture_cube_map_array");
/* 3876 */     this.GL_ARB_texture_env_add = ext.contains("GL_ARB_texture_env_add");
/* 3877 */     this.GL_ARB_texture_env_combine = ext.contains("GL_ARB_texture_env_combine");
/* 3878 */     this.GL_ARB_texture_env_crossbar = ext.contains("GL_ARB_texture_env_crossbar");
/* 3879 */     this.GL_ARB_texture_env_dot3 = ext.contains("GL_ARB_texture_env_dot3");
/* 3880 */     this.GL_ARB_texture_filter_anisotropic = ext.contains("GL_ARB_texture_filter_anisotropic");
/* 3881 */     this.GL_ARB_texture_filter_minmax = ext.contains("GL_ARB_texture_filter_minmax");
/* 3882 */     this.GL_ARB_texture_float = ext.contains("GL_ARB_texture_float");
/* 3883 */     this.GL_ARB_texture_gather = ext.contains("GL_ARB_texture_gather");
/* 3884 */     this.GL_ARB_texture_mirror_clamp_to_edge = ext.contains("GL_ARB_texture_mirror_clamp_to_edge");
/* 3885 */     this.GL_ARB_texture_mirrored_repeat = ext.contains("GL_ARB_texture_mirrored_repeat");
/* 3886 */     this.GL_ARB_texture_multisample = check_ARB_texture_multisample(provider, caps, ext);
/* 3887 */     this.GL_ARB_texture_non_power_of_two = ext.contains("GL_ARB_texture_non_power_of_two");
/* 3888 */     this.GL_ARB_texture_query_levels = ext.contains("GL_ARB_texture_query_levels");
/* 3889 */     this.GL_ARB_texture_query_lod = ext.contains("GL_ARB_texture_query_lod");
/* 3890 */     this.GL_ARB_texture_rectangle = ext.contains("GL_ARB_texture_rectangle");
/* 3891 */     this.GL_ARB_texture_rg = ext.contains("GL_ARB_texture_rg");
/* 3892 */     this.GL_ARB_texture_rgb10_a2ui = ext.contains("GL_ARB_texture_rgb10_a2ui");
/* 3893 */     this.GL_ARB_texture_stencil8 = ext.contains("GL_ARB_texture_stencil8");
/* 3894 */     this.GL_ARB_texture_storage = check_ARB_texture_storage(provider, caps, ext);
/* 3895 */     this.GL_ARB_texture_storage_multisample = check_ARB_texture_storage_multisample(provider, caps, ext);
/* 3896 */     this.GL_ARB_texture_swizzle = ext.contains("GL_ARB_texture_swizzle");
/* 3897 */     this.GL_ARB_texture_view = check_ARB_texture_view(provider, caps, ext);
/* 3898 */     this.GL_ARB_timer_query = check_ARB_timer_query(provider, caps, ext);
/* 3899 */     this.GL_ARB_transform_feedback2 = check_ARB_transform_feedback2(provider, caps, ext);
/* 3900 */     this.GL_ARB_transform_feedback3 = check_ARB_transform_feedback3(provider, caps, ext);
/* 3901 */     this.GL_ARB_transform_feedback_instanced = check_ARB_transform_feedback_instanced(provider, caps, ext);
/* 3902 */     this.GL_ARB_transform_feedback_overflow_query = ext.contains("GL_ARB_transform_feedback_overflow_query");
/* 3903 */     this.GL_ARB_transpose_matrix = check_ARB_transpose_matrix(provider, caps, ext);
/* 3904 */     this.GL_ARB_uniform_buffer_object = check_ARB_uniform_buffer_object(provider, caps, ext);
/* 3905 */     this.GL_ARB_vertex_array_bgra = ext.contains("GL_ARB_vertex_array_bgra");
/* 3906 */     this.GL_ARB_vertex_array_object = check_ARB_vertex_array_object(provider, caps, ext);
/* 3907 */     this.GL_ARB_vertex_attrib_64bit = check_ARB_vertex_attrib_64bit(provider, caps, ext);
/* 3908 */     this.GL_ARB_vertex_attrib_binding = check_ARB_vertex_attrib_binding(provider, caps, ext);
/* 3909 */     this.GL_ARB_vertex_blend = check_ARB_vertex_blend(provider, caps, ext);
/* 3910 */     this.GL_ARB_vertex_buffer_object = check_ARB_vertex_buffer_object(provider, caps, ext);
/* 3911 */     this.GL_ARB_vertex_program = check_ARB_vertex_program(provider, caps, ext);
/* 3912 */     this.GL_ARB_vertex_shader = check_ARB_vertex_shader(provider, caps, ext);
/* 3913 */     this.GL_ARB_vertex_type_10f_11f_11f_rev = ext.contains("GL_ARB_vertex_type_10f_11f_11f_rev");
/* 3914 */     this.GL_ARB_vertex_type_2_10_10_10_rev = check_ARB_vertex_type_2_10_10_10_rev(provider, caps, ext, fc);
/* 3915 */     this.GL_ARB_viewport_array = check_ARB_viewport_array(provider, caps, ext);
/* 3916 */     this.GL_ARB_window_pos = check_ARB_window_pos(provider, caps, ext);
/* 3917 */     this.GL_ATI_meminfo = ext.contains("GL_ATI_meminfo");
/* 3918 */     this.GL_ATI_shader_texture_lod = ext.contains("GL_ATI_shader_texture_lod");
/* 3919 */     this.GL_ATI_texture_compression_3dc = ext.contains("GL_ATI_texture_compression_3dc");
/* 3920 */     this.GL_EXT_422_pixels = ext.contains("GL_EXT_422_pixels");
/* 3921 */     this.GL_EXT_abgr = ext.contains("GL_EXT_abgr");
/* 3922 */     this.GL_EXT_bgra = ext.contains("GL_EXT_bgra");
/* 3923 */     this.GL_EXT_bindable_uniform = check_EXT_bindable_uniform(provider, caps, ext);
/* 3924 */     this.GL_EXT_blend_color = check_EXT_blend_color(provider, caps, ext);
/* 3925 */     this.GL_EXT_blend_equation_separate = check_EXT_blend_equation_separate(provider, caps, ext);
/* 3926 */     this.GL_EXT_blend_func_separate = check_EXT_blend_func_separate(provider, caps, ext);
/* 3927 */     this.GL_EXT_blend_minmax = check_EXT_blend_minmax(provider, caps, ext);
/* 3928 */     this.GL_EXT_blend_subtract = ext.contains("GL_EXT_blend_subtract");
/* 3929 */     this.GL_EXT_clip_volume_hint = ext.contains("GL_EXT_clip_volume_hint");
/* 3930 */     this.GL_EXT_compiled_vertex_array = check_EXT_compiled_vertex_array(provider, caps, ext);
/* 3931 */     this.GL_EXT_debug_label = check_EXT_debug_label(provider, caps, ext);
/* 3932 */     this.GL_EXT_debug_marker = check_EXT_debug_marker(provider, caps, ext);
/* 3933 */     this.GL_EXT_depth_bounds_test = check_EXT_depth_bounds_test(provider, caps, ext);
/* 3934 */     this.GL_EXT_direct_state_access = check_EXT_direct_state_access(provider, caps, ext);
/* 3935 */     this.GL_EXT_draw_buffers2 = check_EXT_draw_buffers2(provider, caps, ext);
/* 3936 */     this.GL_EXT_draw_instanced = check_EXT_draw_instanced(provider, caps, ext);
/* 3937 */     this.GL_EXT_EGL_image_storage = check_EXT_EGL_image_storage(provider, caps, ext);
/* 3938 */     this.GL_EXT_EGL_sync = ext.contains("GL_EXT_EGL_sync");
/* 3939 */     this.GL_EXT_external_buffer = check_EXT_external_buffer(provider, caps, ext);
/* 3940 */     this.GL_EXT_fragment_shading_rate = check_EXT_fragment_shading_rate(provider, caps, ext);
/* 3941 */     this.GL_EXT_fragment_shading_rate_attachment = ext.contains("GL_EXT_fragment_shading_rate_attachment");
/* 3942 */     this.GL_EXT_fragment_shading_rate_primitive = ext.contains("GL_EXT_fragment_shading_rate_primitive");
/* 3943 */     this.GL_EXT_framebuffer_blit = check_EXT_framebuffer_blit(provider, caps, ext);
/* 3944 */     this.GL_EXT_framebuffer_blit_layers = check_EXT_framebuffer_blit_layers(provider, caps, ext);
/* 3945 */     this.GL_EXT_framebuffer_multisample = check_EXT_framebuffer_multisample(provider, caps, ext);
/* 3946 */     this.GL_EXT_framebuffer_multisample_blit_scaled = ext.contains("GL_EXT_framebuffer_multisample_blit_scaled");
/* 3947 */     this.GL_EXT_framebuffer_object = check_EXT_framebuffer_object(provider, caps, ext);
/* 3948 */     this.GL_EXT_framebuffer_sRGB = ext.contains("GL_EXT_framebuffer_sRGB");
/* 3949 */     this.GL_EXT_geometry_shader4 = check_EXT_geometry_shader4(provider, caps, ext);
/* 3950 */     this.GL_EXT_gpu_program_parameters = check_EXT_gpu_program_parameters(provider, caps, ext);
/* 3951 */     this.GL_EXT_gpu_shader4 = check_EXT_gpu_shader4(provider, caps, ext);
/* 3952 */     this.GL_EXT_memory_object = check_EXT_memory_object(provider, caps, ext);
/* 3953 */     this.GL_EXT_memory_object_fd = check_EXT_memory_object_fd(provider, caps, ext);
/* 3954 */     this.GL_EXT_memory_object_win32 = check_EXT_memory_object_win32(provider, caps, ext);
/* 3955 */     this.GL_EXT_mesh_shader = check_EXT_mesh_shader(provider, caps, ext);
/* 3956 */     this.GL_EXT_multiview_tessellation_geometry_shader = ext.contains("GL_EXT_multiview_tessellation_geometry_shader");
/* 3957 */     this.GL_EXT_multiview_texture_multisample = ext.contains("GL_EXT_multiview_texture_multisample");
/* 3958 */     this.GL_EXT_multiview_timer_query = ext.contains("GL_EXT_multiview_timer_query");
/* 3959 */     this.GL_EXT_packed_depth_stencil = ext.contains("GL_EXT_packed_depth_stencil");
/* 3960 */     this.GL_EXT_packed_float = ext.contains("GL_EXT_packed_float");
/* 3961 */     this.GL_EXT_pixel_buffer_object = ext.contains("GL_EXT_pixel_buffer_object");
/* 3962 */     this.GL_EXT_point_parameters = check_EXT_point_parameters(provider, caps, ext);
/* 3963 */     this.GL_EXT_polygon_offset_clamp = check_EXT_polygon_offset_clamp(provider, caps, ext);
/* 3964 */     this.GL_EXT_post_depth_coverage = ext.contains("GL_EXT_post_depth_coverage");
/* 3965 */     this.GL_EXT_provoking_vertex = check_EXT_provoking_vertex(provider, caps, ext);
/* 3966 */     this.GL_EXT_raster_multisample = check_EXT_raster_multisample(provider, caps, ext);
/* 3967 */     this.GL_EXT_secondary_color = check_EXT_secondary_color(provider, caps, ext);
/* 3968 */     this.GL_EXT_semaphore = check_EXT_semaphore(provider, caps, ext);
/* 3969 */     this.GL_EXT_semaphore_fd = check_EXT_semaphore_fd(provider, caps, ext);
/* 3970 */     this.GL_EXT_semaphore_win32 = check_EXT_semaphore_win32(provider, caps, ext);
/* 3971 */     this.GL_EXT_separate_shader_objects = check_EXT_separate_shader_objects(provider, caps, ext);
/* 3972 */     this.GL_EXT_shader_framebuffer_fetch = ext.contains("GL_EXT_shader_framebuffer_fetch");
/* 3973 */     this.GL_EXT_shader_framebuffer_fetch_non_coherent = check_EXT_shader_framebuffer_fetch_non_coherent(provider, caps, ext);
/* 3974 */     this.GL_EXT_shader_image_load_formatted = ext.contains("GL_EXT_shader_image_load_formatted");
/* 3975 */     this.GL_EXT_shader_image_load_store = check_EXT_shader_image_load_store(provider, caps, ext);
/* 3976 */     this.GL_EXT_shader_integer_mix = ext.contains("GL_EXT_shader_integer_mix");
/* 3977 */     this.GL_EXT_shader_realtime_clock = ext.contains("GL_EXT_shader_realtime_clock");
/* 3978 */     this.GL_EXT_shader_samples_identical = ext.contains("GL_EXT_shader_samples_identical");
/* 3979 */     this.GL_EXT_shader_texture_samples = ext.contains("GL_EXT_shader_texture_samples");
/* 3980 */     this.GL_EXT_shadow_funcs = ext.contains("GL_EXT_shadow_funcs");
/* 3981 */     this.GL_EXT_shared_texture_palette = ext.contains("GL_EXT_shared_texture_palette");
/* 3982 */     this.GL_EXT_sparse_texture2 = ext.contains("GL_EXT_sparse_texture2");
/* 3983 */     this.GL_EXT_stencil_clear_tag = check_EXT_stencil_clear_tag(provider, caps, ext);
/* 3984 */     this.GL_EXT_stencil_two_side = check_EXT_stencil_two_side(provider, caps, ext);
/* 3985 */     this.GL_EXT_stencil_wrap = ext.contains("GL_EXT_stencil_wrap");
/* 3986 */     this.GL_EXT_texture_array = check_EXT_texture_array(provider, caps, ext);
/* 3987 */     this.GL_EXT_texture_buffer_object = check_EXT_texture_buffer_object(provider, caps, ext);
/* 3988 */     this.GL_EXT_texture_compression_latc = ext.contains("GL_EXT_texture_compression_latc");
/* 3989 */     this.GL_EXT_texture_compression_rgtc = ext.contains("GL_EXT_texture_compression_rgtc");
/* 3990 */     this.GL_EXT_texture_compression_s3tc = ext.contains("GL_EXT_texture_compression_s3tc");
/* 3991 */     this.GL_EXT_texture_filter_anisotropic = ext.contains("GL_EXT_texture_filter_anisotropic");
/* 3992 */     this.GL_EXT_texture_filter_minmax = ext.contains("GL_EXT_texture_filter_minmax");
/* 3993 */     this.GL_EXT_texture_integer = check_EXT_texture_integer(provider, caps, ext);
/* 3994 */     this.GL_EXT_texture_mirror_clamp = ext.contains("GL_EXT_texture_mirror_clamp");
/* 3995 */     this.GL_EXT_texture_shadow_lod = ext.contains("GL_EXT_texture_shadow_lod");
/* 3996 */     this.GL_EXT_texture_shared_exponent = ext.contains("GL_EXT_texture_shared_exponent");
/* 3997 */     this.GL_EXT_texture_snorm = ext.contains("GL_EXT_texture_snorm");
/* 3998 */     this.GL_EXT_texture_sRGB = ext.contains("GL_EXT_texture_sRGB");
/* 3999 */     this.GL_EXT_texture_sRGB_decode = ext.contains("GL_EXT_texture_sRGB_decode");
/* 4000 */     this.GL_EXT_texture_sRGB_R8 = ext.contains("GL_EXT_texture_sRGB_R8");
/* 4001 */     this.GL_EXT_texture_sRGB_RG8 = ext.contains("GL_EXT_texture_sRGB_RG8");
/* 4002 */     this.GL_EXT_texture_storage = check_EXT_texture_storage(provider, caps, ext);
/* 4003 */     this.GL_EXT_texture_swizzle = ext.contains("GL_EXT_texture_swizzle");
/* 4004 */     this.GL_EXT_timer_query = check_EXT_timer_query(provider, caps, ext);
/* 4005 */     this.GL_EXT_transform_feedback = check_EXT_transform_feedback(provider, caps, ext);
/* 4006 */     this.GL_EXT_vertex_array_bgra = ext.contains("GL_EXT_vertex_array_bgra");
/* 4007 */     this.GL_EXT_vertex_attrib_64bit = check_EXT_vertex_attrib_64bit(provider, caps, ext);
/* 4008 */     this.GL_EXT_win32_keyed_mutex = check_EXT_win32_keyed_mutex(provider, caps, ext);
/* 4009 */     this.GL_EXT_window_rectangles = check_EXT_window_rectangles(provider, caps, ext);
/* 4010 */     this.GL_EXT_x11_sync_object = check_EXT_x11_sync_object(provider, caps, ext);
/* 4011 */     this.GL_GREMEDY_frame_terminator = check_GREMEDY_frame_terminator(provider, caps, ext);
/* 4012 */     this.GL_GREMEDY_string_marker = check_GREMEDY_string_marker(provider, caps, ext);
/* 4013 */     this.GL_INTEL_blackhole_render = ext.contains("GL_INTEL_blackhole_render");
/* 4014 */     this.GL_INTEL_conservative_rasterization = ext.contains("GL_INTEL_conservative_rasterization");
/* 4015 */     this.GL_INTEL_fragment_shader_ordering = ext.contains("GL_INTEL_fragment_shader_ordering");
/* 4016 */     this.GL_INTEL_framebuffer_CMAA = check_INTEL_framebuffer_CMAA(provider, caps, ext);
/* 4017 */     this.GL_INTEL_map_texture = check_INTEL_map_texture(provider, caps, ext);
/* 4018 */     this.GL_INTEL_performance_query = check_INTEL_performance_query(provider, caps, ext);
/* 4019 */     this.GL_INTEL_shader_integer_functions2 = ext.contains("GL_INTEL_shader_integer_functions2");
/* 4020 */     this.GL_KHR_blend_equation_advanced = check_KHR_blend_equation_advanced(provider, caps, ext);
/* 4021 */     this.GL_KHR_blend_equation_advanced_coherent = ext.contains("GL_KHR_blend_equation_advanced_coherent");
/* 4022 */     this.GL_KHR_context_flush_control = ext.contains("GL_KHR_context_flush_control");
/* 4023 */     this.GL_KHR_debug = check_KHR_debug(provider, caps, ext);
/* 4024 */     this.GL_KHR_no_error = ext.contains("GL_KHR_no_error");
/* 4025 */     this.GL_KHR_parallel_shader_compile = check_KHR_parallel_shader_compile(provider, caps, ext);
/* 4026 */     this.GL_KHR_robust_buffer_access_behavior = ext.contains("GL_KHR_robust_buffer_access_behavior");
/* 4027 */     this.GL_KHR_robustness = check_KHR_robustness(provider, caps, ext);
/* 4028 */     this.GL_KHR_shader_subgroup = ext.contains("GL_KHR_shader_subgroup");
/* 4029 */     this.GL_KHR_texture_compression_astc_hdr = ext.contains("GL_KHR_texture_compression_astc_hdr");
/* 4030 */     this.GL_KHR_texture_compression_astc_ldr = ext.contains("GL_KHR_texture_compression_astc_ldr");
/* 4031 */     this.GL_KHR_texture_compression_astc_sliced_3d = ext.contains("GL_KHR_texture_compression_astc_sliced_3d");
/* 4032 */     this.GL_MESA_framebuffer_flip_x = ext.contains("GL_MESA_framebuffer_flip_x");
/* 4033 */     this.GL_MESA_framebuffer_flip_y = check_MESA_framebuffer_flip_y(provider, caps, ext);
/* 4034 */     this.GL_MESA_framebuffer_swap_xy = ext.contains("GL_MESA_framebuffer_swap_xy");
/* 4035 */     this.GL_MESA_tile_raster_order = ext.contains("GL_MESA_tile_raster_order");
/* 4036 */     this.GL_NV_alpha_to_coverage_dither_control = check_NV_alpha_to_coverage_dither_control(provider, caps, ext);
/* 4037 */     this.GL_NV_bindless_multi_draw_indirect = check_NV_bindless_multi_draw_indirect(provider, caps, ext);
/* 4038 */     this.GL_NV_bindless_multi_draw_indirect_count = check_NV_bindless_multi_draw_indirect_count(provider, caps, ext);
/* 4039 */     this.GL_NV_bindless_texture = check_NV_bindless_texture(provider, caps, ext);
/* 4040 */     this.GL_NV_blend_equation_advanced = check_NV_blend_equation_advanced(provider, caps, ext);
/* 4041 */     this.GL_NV_blend_equation_advanced_coherent = ext.contains("GL_NV_blend_equation_advanced_coherent");
/* 4042 */     this.GL_NV_blend_minmax_factor = ext.contains("GL_NV_blend_minmax_factor");
/* 4043 */     this.GL_NV_blend_square = ext.contains("GL_NV_blend_square");
/* 4044 */     this.GL_NV_clip_space_w_scaling = check_NV_clip_space_w_scaling(provider, caps, ext);
/* 4045 */     this.GL_NV_command_list = check_NV_command_list(provider, caps, ext);
/* 4046 */     this.GL_NV_compute_shader_derivatives = ext.contains("GL_NV_compute_shader_derivatives");
/* 4047 */     this.GL_NV_conditional_render = check_NV_conditional_render(provider, caps, ext);
/* 4048 */     this.GL_NV_conservative_raster = check_NV_conservative_raster(provider, caps, ext);
/* 4049 */     this.GL_NV_conservative_raster_dilate = check_NV_conservative_raster_dilate(provider, caps, ext);
/* 4050 */     this.GL_NV_conservative_raster_pre_snap = ext.contains("GL_NV_conservative_raster_pre_snap");
/* 4051 */     this.GL_NV_conservative_raster_pre_snap_triangles = check_NV_conservative_raster_pre_snap_triangles(provider, caps, ext);
/* 4052 */     this.GL_NV_conservative_raster_underestimation = ext.contains("GL_NV_conservative_raster_underestimation");
/* 4053 */     this.GL_NV_copy_depth_to_color = ext.contains("GL_NV_copy_depth_to_color");
/* 4054 */     this.GL_NV_copy_image = check_NV_copy_image(provider, caps, ext);
/* 4055 */     this.GL_NV_deep_texture3D = ext.contains("GL_NV_deep_texture3D");
/* 4056 */     this.GL_NV_depth_buffer_float = check_NV_depth_buffer_float(provider, caps, ext);
/* 4057 */     this.GL_NV_depth_clamp = ext.contains("GL_NV_depth_clamp");
/* 4058 */     this.GL_NV_draw_texture = check_NV_draw_texture(provider, caps, ext);
/* 4059 */     this.GL_NV_draw_vulkan_image = check_NV_draw_vulkan_image(provider, caps, ext);
/* 4060 */     this.GL_NV_ES3_1_compatibility = ext.contains("GL_NV_ES3_1_compatibility");
/* 4061 */     this.GL_NV_explicit_multisample = check_NV_explicit_multisample(provider, caps, ext);
/* 4062 */     this.GL_NV_fence = check_NV_fence(provider, caps, ext);
/* 4063 */     this.GL_NV_fill_rectangle = ext.contains("GL_NV_fill_rectangle");
/* 4064 */     this.GL_NV_float_buffer = ext.contains("GL_NV_float_buffer");
/* 4065 */     this.GL_NV_fog_distance = ext.contains("GL_NV_fog_distance");
/* 4066 */     this.GL_NV_fragment_coverage_to_color = check_NV_fragment_coverage_to_color(provider, caps, ext);
/* 4067 */     this.GL_NV_fragment_program4 = ext.contains("GL_NV_fragment_program4");
/* 4068 */     this.GL_NV_fragment_program_option = ext.contains("GL_NV_fragment_program_option");
/* 4069 */     this.GL_NV_fragment_shader_barycentric = ext.contains("GL_NV_fragment_shader_barycentric");
/* 4070 */     this.GL_NV_fragment_shader_interlock = ext.contains("GL_NV_fragment_shader_interlock");
/* 4071 */     this.GL_NV_framebuffer_mixed_samples = check_NV_framebuffer_mixed_samples(provider, caps, ext);
/* 4072 */     this.GL_NV_framebuffer_multisample_coverage = check_NV_framebuffer_multisample_coverage(provider, caps, ext);
/* 4073 */     this.GL_NV_geometry_shader4 = ext.contains("GL_NV_geometry_shader4");
/* 4074 */     this.GL_NV_geometry_shader_passthrough = ext.contains("GL_NV_geometry_shader_passthrough");
/* 4075 */     this.GL_NV_gpu_multicast = check_NV_gpu_multicast(provider, caps, ext);
/* 4076 */     this.GL_NV_gpu_shader5 = check_NV_gpu_shader5(provider, caps, ext);
/* 4077 */     this.GL_NV_half_float = check_NV_half_float(provider, caps, ext);
/* 4078 */     this.GL_NV_internalformat_sample_query = check_NV_internalformat_sample_query(provider, caps, ext);
/* 4079 */     this.GL_NV_light_max_exponent = ext.contains("GL_NV_light_max_exponent");
/* 4080 */     this.GL_NV_memory_attachment = check_NV_memory_attachment(provider, caps, ext);
/* 4081 */     this.GL_NV_memory_object_sparse = check_NV_memory_object_sparse(provider, caps, ext);
/* 4082 */     this.GL_NV_mesh_shader = check_NV_mesh_shader(provider, caps, ext);
/* 4083 */     this.GL_NV_multisample_coverage = ext.contains("GL_NV_multisample_coverage");
/* 4084 */     this.GL_NV_multisample_filter_hint = ext.contains("GL_NV_multisample_filter_hint");
/* 4085 */     this.GL_NV_packed_depth_stencil = ext.contains("GL_NV_packed_depth_stencil");
/* 4086 */     this.GL_NV_path_rendering = check_NV_path_rendering(provider, caps, ext);
/* 4087 */     this.GL_NV_path_rendering_shared_edge = ext.contains("GL_NV_path_rendering_shared_edge");
/* 4088 */     this.GL_NV_pixel_data_range = check_NV_pixel_data_range(provider, caps, ext);
/* 4089 */     this.GL_NV_point_sprite = check_NV_point_sprite(provider, caps, ext);
/* 4090 */     this.GL_NV_primitive_restart = check_NV_primitive_restart(provider, caps, ext);
/* 4091 */     this.GL_NV_primitive_shading_rate = ext.contains("GL_NV_primitive_shading_rate");
/* 4092 */     this.GL_NV_query_resource = check_NV_query_resource(provider, caps, ext);
/* 4093 */     this.GL_NV_query_resource_tag = check_NV_query_resource_tag(provider, caps, ext);
/* 4094 */     this.GL_NV_representative_fragment_test = ext.contains("GL_NV_representative_fragment_test");
/* 4095 */     this.GL_NV_robustness_video_memory_purge = ext.contains("GL_NV_robustness_video_memory_purge");
/* 4096 */     this.GL_NV_sample_locations = check_NV_sample_locations(provider, caps, ext);
/* 4097 */     this.GL_NV_sample_mask_override_coverage = ext.contains("GL_NV_sample_mask_override_coverage");
/* 4098 */     this.GL_NV_scissor_exclusive = check_NV_scissor_exclusive(provider, caps, ext);
/* 4099 */     this.GL_NV_shader_atomic_float = ext.contains("GL_NV_shader_atomic_float");
/* 4100 */     this.GL_NV_shader_atomic_float64 = ext.contains("GL_NV_shader_atomic_float64");
/* 4101 */     this.GL_NV_shader_atomic_fp16_vector = ext.contains("GL_NV_shader_atomic_fp16_vector");
/* 4102 */     this.GL_NV_shader_atomic_int64 = ext.contains("GL_NV_shader_atomic_int64");
/* 4103 */     this.GL_NV_shader_buffer_load = check_NV_shader_buffer_load(provider, caps, ext);
/* 4104 */     this.GL_NV_shader_buffer_store = ext.contains("GL_NV_shader_buffer_store");
/* 4105 */     this.GL_NV_shader_subgroup_partitioned = ext.contains("GL_NV_shader_subgroup_partitioned");
/* 4106 */     this.GL_NV_shader_texture_footprint = ext.contains("GL_NV_shader_texture_footprint");
/* 4107 */     this.GL_NV_shader_thread_group = ext.contains("GL_NV_shader_thread_group");
/* 4108 */     this.GL_NV_shader_thread_shuffle = ext.contains("GL_NV_shader_thread_shuffle");
/* 4109 */     this.GL_NV_shading_rate_image = check_NV_shading_rate_image(provider, caps, ext);
/* 4110 */     this.GL_NV_stereo_view_rendering = ext.contains("GL_NV_stereo_view_rendering");
/* 4111 */     this.GL_NV_texgen_reflection = ext.contains("GL_NV_texgen_reflection");
/* 4112 */     this.GL_NV_texture_barrier = check_NV_texture_barrier(provider, caps, ext);
/* 4113 */     this.GL_NV_texture_compression_vtc = ext.contains("GL_NV_texture_compression_vtc");
/* 4114 */     this.GL_NV_texture_multisample = check_NV_texture_multisample(provider, caps, ext);
/* 4115 */     this.GL_NV_texture_rectangle_compressed = ext.contains("GL_NV_texture_rectangle_compressed");
/* 4116 */     this.GL_NV_texture_shader = ext.contains("GL_NV_texture_shader");
/* 4117 */     this.GL_NV_texture_shader2 = ext.contains("GL_NV_texture_shader2");
/* 4118 */     this.GL_NV_texture_shader3 = ext.contains("GL_NV_texture_shader3");
/* 4119 */     this.GL_NV_timeline_semaphore = check_NV_timeline_semaphore(provider, caps, ext);
/* 4120 */     this.GL_NV_transform_feedback = check_NV_transform_feedback(provider, caps, ext);
/* 4121 */     this.GL_NV_transform_feedback2 = check_NV_transform_feedback2(provider, caps, ext);
/* 4122 */     this.GL_NV_uniform_buffer_std430_layout = ext.contains("GL_NV_uniform_buffer_std430_layout");
/* 4123 */     this.GL_NV_uniform_buffer_unified_memory = ext.contains("GL_NV_uniform_buffer_unified_memory");
/* 4124 */     this.GL_NV_vertex_array_range = check_NV_vertex_array_range(provider, caps, ext);
/* 4125 */     this.GL_NV_vertex_array_range2 = ext.contains("GL_NV_vertex_array_range2");
/* 4126 */     this.GL_NV_vertex_attrib_integer_64bit = check_NV_vertex_attrib_integer_64bit(provider, caps, ext);
/* 4127 */     this.GL_NV_vertex_buffer_unified_memory = check_NV_vertex_buffer_unified_memory(provider, caps, ext);
/* 4128 */     this.GL_NV_viewport_array2 = ext.contains("GL_NV_viewport_array2");
/* 4129 */     this.GL_NV_viewport_swizzle = check_NV_viewport_swizzle(provider, caps, ext);
/* 4130 */     this.GL_NVX_blend_equation_advanced_multi_draw_buffers = ext.contains("GL_NVX_blend_equation_advanced_multi_draw_buffers");
/* 4131 */     this.GL_NVX_conditional_render = check_NVX_conditional_render(provider, caps, ext);
/* 4132 */     this.GL_NVX_gpu_memory_info = ext.contains("GL_NVX_gpu_memory_info");
/* 4133 */     this.GL_NVX_gpu_multicast2 = check_NVX_gpu_multicast2(provider, caps, ext);
/* 4134 */     this.GL_NVX_progress_fence = check_NVX_progress_fence(provider, caps, ext);
/* 4135 */     this.GL_OVR_multiview = check_OVR_multiview(provider, caps, ext);
/* 4136 */     this.GL_OVR_multiview2 = ext.contains("GL_OVR_multiview2");
/* 4137 */     this.GL_S3_s3tc = ext.contains("GL_S3_s3tc");
/*      */     
/* 4139 */     this.glEnable = caps.get(0);
/* 4140 */     this.glDisable = caps.get(1);
/* 4141 */     this.glAccum = caps.get(2);
/* 4142 */     this.glAlphaFunc = caps.get(3);
/* 4143 */     this.glAreTexturesResident = caps.get(4);
/* 4144 */     this.glArrayElement = caps.get(5);
/* 4145 */     this.glBegin = caps.get(6);
/* 4146 */     this.glBindTexture = caps.get(7);
/* 4147 */     this.glBitmap = caps.get(8);
/* 4148 */     this.glBlendFunc = caps.get(9);
/* 4149 */     this.glCallList = caps.get(10);
/* 4150 */     this.glCallLists = caps.get(11);
/* 4151 */     this.glClear = caps.get(12);
/* 4152 */     this.glClearAccum = caps.get(13);
/* 4153 */     this.glClearColor = caps.get(14);
/* 4154 */     this.glClearDepth = caps.get(15);
/* 4155 */     this.glClearIndex = caps.get(16);
/* 4156 */     this.glClearStencil = caps.get(17);
/* 4157 */     this.glClipPlane = caps.get(18);
/* 4158 */     this.glColor3b = caps.get(19);
/* 4159 */     this.glColor3s = caps.get(20);
/* 4160 */     this.glColor3i = caps.get(21);
/* 4161 */     this.glColor3f = caps.get(22);
/* 4162 */     this.glColor3d = caps.get(23);
/* 4163 */     this.glColor3ub = caps.get(24);
/* 4164 */     this.glColor3us = caps.get(25);
/* 4165 */     this.glColor3ui = caps.get(26);
/* 4166 */     this.glColor3bv = caps.get(27);
/* 4167 */     this.glColor3sv = caps.get(28);
/* 4168 */     this.glColor3iv = caps.get(29);
/* 4169 */     this.glColor3fv = caps.get(30);
/* 4170 */     this.glColor3dv = caps.get(31);
/* 4171 */     this.glColor3ubv = caps.get(32);
/* 4172 */     this.glColor3usv = caps.get(33);
/* 4173 */     this.glColor3uiv = caps.get(34);
/* 4174 */     this.glColor4b = caps.get(35);
/* 4175 */     this.glColor4s = caps.get(36);
/* 4176 */     this.glColor4i = caps.get(37);
/* 4177 */     this.glColor4f = caps.get(38);
/* 4178 */     this.glColor4d = caps.get(39);
/* 4179 */     this.glColor4ub = caps.get(40);
/* 4180 */     this.glColor4us = caps.get(41);
/* 4181 */     this.glColor4ui = caps.get(42);
/* 4182 */     this.glColor4bv = caps.get(43);
/* 4183 */     this.glColor4sv = caps.get(44);
/* 4184 */     this.glColor4iv = caps.get(45);
/* 4185 */     this.glColor4fv = caps.get(46);
/* 4186 */     this.glColor4dv = caps.get(47);
/* 4187 */     this.glColor4ubv = caps.get(48);
/* 4188 */     this.glColor4usv = caps.get(49);
/* 4189 */     this.glColor4uiv = caps.get(50);
/* 4190 */     this.glColorMask = caps.get(51);
/* 4191 */     this.glColorMaterial = caps.get(52);
/* 4192 */     this.glColorPointer = caps.get(53);
/* 4193 */     this.glCopyPixels = caps.get(54);
/* 4194 */     this.glCullFace = caps.get(55);
/* 4195 */     this.glDeleteLists = caps.get(56);
/* 4196 */     this.glDepthFunc = caps.get(57);
/* 4197 */     this.glDepthMask = caps.get(58);
/* 4198 */     this.glDepthRange = caps.get(59);
/* 4199 */     this.glDisableClientState = caps.get(60);
/* 4200 */     this.glDrawArrays = caps.get(61);
/* 4201 */     this.glDrawBuffer = caps.get(62);
/* 4202 */     this.glDrawElements = caps.get(63);
/* 4203 */     this.glDrawPixels = caps.get(64);
/* 4204 */     this.glEdgeFlag = caps.get(65);
/* 4205 */     this.glEdgeFlagv = caps.get(66);
/* 4206 */     this.glEdgeFlagPointer = caps.get(67);
/* 4207 */     this.glEnableClientState = caps.get(68);
/* 4208 */     this.glEnd = caps.get(69);
/* 4209 */     this.glEvalCoord1f = caps.get(70);
/* 4210 */     this.glEvalCoord1fv = caps.get(71);
/* 4211 */     this.glEvalCoord1d = caps.get(72);
/* 4212 */     this.glEvalCoord1dv = caps.get(73);
/* 4213 */     this.glEvalCoord2f = caps.get(74);
/* 4214 */     this.glEvalCoord2fv = caps.get(75);
/* 4215 */     this.glEvalCoord2d = caps.get(76);
/* 4216 */     this.glEvalCoord2dv = caps.get(77);
/* 4217 */     this.glEvalMesh1 = caps.get(78);
/* 4218 */     this.glEvalMesh2 = caps.get(79);
/* 4219 */     this.glEvalPoint1 = caps.get(80);
/* 4220 */     this.glEvalPoint2 = caps.get(81);
/* 4221 */     this.glFeedbackBuffer = caps.get(82);
/* 4222 */     this.glFinish = caps.get(83);
/* 4223 */     this.glFlush = caps.get(84);
/* 4224 */     this.glFogi = caps.get(85);
/* 4225 */     this.glFogiv = caps.get(86);
/* 4226 */     this.glFogf = caps.get(87);
/* 4227 */     this.glFogfv = caps.get(88);
/* 4228 */     this.glFrontFace = caps.get(89);
/* 4229 */     this.glGenLists = caps.get(90);
/* 4230 */     this.glGenTextures = caps.get(91);
/* 4231 */     this.glDeleteTextures = caps.get(92);
/* 4232 */     this.glGetClipPlane = caps.get(93);
/* 4233 */     this.glGetBooleanv = caps.get(94);
/* 4234 */     this.glGetFloatv = caps.get(95);
/* 4235 */     this.glGetIntegerv = caps.get(96);
/* 4236 */     this.glGetDoublev = caps.get(97);
/* 4237 */     this.glGetError = caps.get(98);
/* 4238 */     this.glGetLightiv = caps.get(99);
/* 4239 */     this.glGetLightfv = caps.get(100);
/* 4240 */     this.glGetMapiv = caps.get(101);
/* 4241 */     this.glGetMapfv = caps.get(102);
/* 4242 */     this.glGetMapdv = caps.get(103);
/* 4243 */     this.glGetMaterialiv = caps.get(104);
/* 4244 */     this.glGetMaterialfv = caps.get(105);
/* 4245 */     this.glGetPixelMapfv = caps.get(106);
/* 4246 */     this.glGetPixelMapusv = caps.get(107);
/* 4247 */     this.glGetPixelMapuiv = caps.get(108);
/* 4248 */     this.glGetPointerv = caps.get(109);
/* 4249 */     this.glGetPolygonStipple = caps.get(110);
/* 4250 */     this.glGetString = caps.get(111);
/* 4251 */     this.glGetTexEnviv = caps.get(112);
/* 4252 */     this.glGetTexEnvfv = caps.get(113);
/* 4253 */     this.glGetTexGeniv = caps.get(114);
/* 4254 */     this.glGetTexGenfv = caps.get(115);
/* 4255 */     this.glGetTexGendv = caps.get(116);
/* 4256 */     this.glGetTexImage = caps.get(117);
/* 4257 */     this.glGetTexLevelParameteriv = caps.get(118);
/* 4258 */     this.glGetTexLevelParameterfv = caps.get(119);
/* 4259 */     this.glGetTexParameteriv = caps.get(120);
/* 4260 */     this.glGetTexParameterfv = caps.get(121);
/* 4261 */     this.glHint = caps.get(122);
/* 4262 */     this.glIndexi = caps.get(123);
/* 4263 */     this.glIndexub = caps.get(124);
/* 4264 */     this.glIndexs = caps.get(125);
/* 4265 */     this.glIndexf = caps.get(126);
/* 4266 */     this.glIndexd = caps.get(127);
/* 4267 */     this.glIndexiv = caps.get(128);
/* 4268 */     this.glIndexubv = caps.get(129);
/* 4269 */     this.glIndexsv = caps.get(130);
/* 4270 */     this.glIndexfv = caps.get(131);
/* 4271 */     this.glIndexdv = caps.get(132);
/* 4272 */     this.glIndexMask = caps.get(133);
/* 4273 */     this.glIndexPointer = caps.get(134);
/* 4274 */     this.glInitNames = caps.get(135);
/* 4275 */     this.glInterleavedArrays = caps.get(136);
/* 4276 */     this.glIsEnabled = caps.get(137);
/* 4277 */     this.glIsList = caps.get(138);
/* 4278 */     this.glIsTexture = caps.get(139);
/* 4279 */     this.glLightModeli = caps.get(140);
/* 4280 */     this.glLightModelf = caps.get(141);
/* 4281 */     this.glLightModeliv = caps.get(142);
/* 4282 */     this.glLightModelfv = caps.get(143);
/* 4283 */     this.glLighti = caps.get(144);
/* 4284 */     this.glLightf = caps.get(145);
/* 4285 */     this.glLightiv = caps.get(146);
/* 4286 */     this.glLightfv = caps.get(147);
/* 4287 */     this.glLineStipple = caps.get(148);
/* 4288 */     this.glLineWidth = caps.get(149);
/* 4289 */     this.glListBase = caps.get(150);
/* 4290 */     this.glLoadMatrixf = caps.get(151);
/* 4291 */     this.glLoadMatrixd = caps.get(152);
/* 4292 */     this.glLoadIdentity = caps.get(153);
/* 4293 */     this.glLoadName = caps.get(154);
/* 4294 */     this.glLogicOp = caps.get(155);
/* 4295 */     this.glMap1f = caps.get(156);
/* 4296 */     this.glMap1d = caps.get(157);
/* 4297 */     this.glMap2f = caps.get(158);
/* 4298 */     this.glMap2d = caps.get(159);
/* 4299 */     this.glMapGrid1f = caps.get(160);
/* 4300 */     this.glMapGrid1d = caps.get(161);
/* 4301 */     this.glMapGrid2f = caps.get(162);
/* 4302 */     this.glMapGrid2d = caps.get(163);
/* 4303 */     this.glMateriali = caps.get(164);
/* 4304 */     this.glMaterialf = caps.get(165);
/* 4305 */     this.glMaterialiv = caps.get(166);
/* 4306 */     this.glMaterialfv = caps.get(167);
/* 4307 */     this.glMatrixMode = caps.get(168);
/* 4308 */     this.glMultMatrixf = caps.get(169);
/* 4309 */     this.glMultMatrixd = caps.get(170);
/* 4310 */     this.glFrustum = caps.get(171);
/* 4311 */     this.glNewList = caps.get(172);
/* 4312 */     this.glEndList = caps.get(173);
/* 4313 */     this.glNormal3f = caps.get(174);
/* 4314 */     this.glNormal3b = caps.get(175);
/* 4315 */     this.glNormal3s = caps.get(176);
/* 4316 */     this.glNormal3i = caps.get(177);
/* 4317 */     this.glNormal3d = caps.get(178);
/* 4318 */     this.glNormal3fv = caps.get(179);
/* 4319 */     this.glNormal3bv = caps.get(180);
/* 4320 */     this.glNormal3sv = caps.get(181);
/* 4321 */     this.glNormal3iv = caps.get(182);
/* 4322 */     this.glNormal3dv = caps.get(183);
/* 4323 */     this.glNormalPointer = caps.get(184);
/* 4324 */     this.glOrtho = caps.get(185);
/* 4325 */     this.glPassThrough = caps.get(186);
/* 4326 */     this.glPixelMapfv = caps.get(187);
/* 4327 */     this.glPixelMapusv = caps.get(188);
/* 4328 */     this.glPixelMapuiv = caps.get(189);
/* 4329 */     this.glPixelStorei = caps.get(190);
/* 4330 */     this.glPixelStoref = caps.get(191);
/* 4331 */     this.glPixelTransferi = caps.get(192);
/* 4332 */     this.glPixelTransferf = caps.get(193);
/* 4333 */     this.glPixelZoom = caps.get(194);
/* 4334 */     this.glPointSize = caps.get(195);
/* 4335 */     this.glPolygonMode = caps.get(196);
/* 4336 */     this.glPolygonOffset = caps.get(197);
/* 4337 */     this.glPolygonStipple = caps.get(198);
/* 4338 */     this.glPushAttrib = caps.get(199);
/* 4339 */     this.glPushClientAttrib = caps.get(200);
/* 4340 */     this.glPopAttrib = caps.get(201);
/* 4341 */     this.glPopClientAttrib = caps.get(202);
/* 4342 */     this.glPopMatrix = caps.get(203);
/* 4343 */     this.glPopName = caps.get(204);
/* 4344 */     this.glPrioritizeTextures = caps.get(205);
/* 4345 */     this.glPushMatrix = caps.get(206);
/* 4346 */     this.glPushName = caps.get(207);
/* 4347 */     this.glRasterPos2i = caps.get(208);
/* 4348 */     this.glRasterPos2s = caps.get(209);
/* 4349 */     this.glRasterPos2f = caps.get(210);
/* 4350 */     this.glRasterPos2d = caps.get(211);
/* 4351 */     this.glRasterPos2iv = caps.get(212);
/* 4352 */     this.glRasterPos2sv = caps.get(213);
/* 4353 */     this.glRasterPos2fv = caps.get(214);
/* 4354 */     this.glRasterPos2dv = caps.get(215);
/* 4355 */     this.glRasterPos3i = caps.get(216);
/* 4356 */     this.glRasterPos3s = caps.get(217);
/* 4357 */     this.glRasterPos3f = caps.get(218);
/* 4358 */     this.glRasterPos3d = caps.get(219);
/* 4359 */     this.glRasterPos3iv = caps.get(220);
/* 4360 */     this.glRasterPos3sv = caps.get(221);
/* 4361 */     this.glRasterPos3fv = caps.get(222);
/* 4362 */     this.glRasterPos3dv = caps.get(223);
/* 4363 */     this.glRasterPos4i = caps.get(224);
/* 4364 */     this.glRasterPos4s = caps.get(225);
/* 4365 */     this.glRasterPos4f = caps.get(226);
/* 4366 */     this.glRasterPos4d = caps.get(227);
/* 4367 */     this.glRasterPos4iv = caps.get(228);
/* 4368 */     this.glRasterPos4sv = caps.get(229);
/* 4369 */     this.glRasterPos4fv = caps.get(230);
/* 4370 */     this.glRasterPos4dv = caps.get(231);
/* 4371 */     this.glReadBuffer = caps.get(232);
/* 4372 */     this.glReadPixels = caps.get(233);
/* 4373 */     this.glRecti = caps.get(234);
/* 4374 */     this.glRects = caps.get(235);
/* 4375 */     this.glRectf = caps.get(236);
/* 4376 */     this.glRectd = caps.get(237);
/* 4377 */     this.glRectiv = caps.get(238);
/* 4378 */     this.glRectsv = caps.get(239);
/* 4379 */     this.glRectfv = caps.get(240);
/* 4380 */     this.glRectdv = caps.get(241);
/* 4381 */     this.glRenderMode = caps.get(242);
/* 4382 */     this.glRotatef = caps.get(243);
/* 4383 */     this.glRotated = caps.get(244);
/* 4384 */     this.glScalef = caps.get(245);
/* 4385 */     this.glScaled = caps.get(246);
/* 4386 */     this.glScissor = caps.get(247);
/* 4387 */     this.glSelectBuffer = caps.get(248);
/* 4388 */     this.glShadeModel = caps.get(249);
/* 4389 */     this.glStencilFunc = caps.get(250);
/* 4390 */     this.glStencilMask = caps.get(251);
/* 4391 */     this.glStencilOp = caps.get(252);
/* 4392 */     this.glTexCoord1f = caps.get(253);
/* 4393 */     this.glTexCoord1s = caps.get(254);
/* 4394 */     this.glTexCoord1i = caps.get(255);
/* 4395 */     this.glTexCoord1d = caps.get(256);
/* 4396 */     this.glTexCoord1fv = caps.get(257);
/* 4397 */     this.glTexCoord1sv = caps.get(258);
/* 4398 */     this.glTexCoord1iv = caps.get(259);
/* 4399 */     this.glTexCoord1dv = caps.get(260);
/* 4400 */     this.glTexCoord2f = caps.get(261);
/* 4401 */     this.glTexCoord2s = caps.get(262);
/* 4402 */     this.glTexCoord2i = caps.get(263);
/* 4403 */     this.glTexCoord2d = caps.get(264);
/* 4404 */     this.glTexCoord2fv = caps.get(265);
/* 4405 */     this.glTexCoord2sv = caps.get(266);
/* 4406 */     this.glTexCoord2iv = caps.get(267);
/* 4407 */     this.glTexCoord2dv = caps.get(268);
/* 4408 */     this.glTexCoord3f = caps.get(269);
/* 4409 */     this.glTexCoord3s = caps.get(270);
/* 4410 */     this.glTexCoord3i = caps.get(271);
/* 4411 */     this.glTexCoord3d = caps.get(272);
/* 4412 */     this.glTexCoord3fv = caps.get(273);
/* 4413 */     this.glTexCoord3sv = caps.get(274);
/* 4414 */     this.glTexCoord3iv = caps.get(275);
/* 4415 */     this.glTexCoord3dv = caps.get(276);
/* 4416 */     this.glTexCoord4f = caps.get(277);
/* 4417 */     this.glTexCoord4s = caps.get(278);
/* 4418 */     this.glTexCoord4i = caps.get(279);
/* 4419 */     this.glTexCoord4d = caps.get(280);
/* 4420 */     this.glTexCoord4fv = caps.get(281);
/* 4421 */     this.glTexCoord4sv = caps.get(282);
/* 4422 */     this.glTexCoord4iv = caps.get(283);
/* 4423 */     this.glTexCoord4dv = caps.get(284);
/* 4424 */     this.glTexCoordPointer = caps.get(285);
/* 4425 */     this.glTexEnvi = caps.get(286);
/* 4426 */     this.glTexEnviv = caps.get(287);
/* 4427 */     this.glTexEnvf = caps.get(288);
/* 4428 */     this.glTexEnvfv = caps.get(289);
/* 4429 */     this.glTexGeni = caps.get(290);
/* 4430 */     this.glTexGeniv = caps.get(291);
/* 4431 */     this.glTexGenf = caps.get(292);
/* 4432 */     this.glTexGenfv = caps.get(293);
/* 4433 */     this.glTexGend = caps.get(294);
/* 4434 */     this.glTexGendv = caps.get(295);
/* 4435 */     this.glTexImage1D = caps.get(296);
/* 4436 */     this.glTexImage2D = caps.get(297);
/* 4437 */     this.glCopyTexImage1D = caps.get(298);
/* 4438 */     this.glCopyTexImage2D = caps.get(299);
/* 4439 */     this.glCopyTexSubImage1D = caps.get(300);
/* 4440 */     this.glCopyTexSubImage2D = caps.get(301);
/* 4441 */     this.glTexParameteri = caps.get(302);
/* 4442 */     this.glTexParameteriv = caps.get(303);
/* 4443 */     this.glTexParameterf = caps.get(304);
/* 4444 */     this.glTexParameterfv = caps.get(305);
/* 4445 */     this.glTexSubImage1D = caps.get(306);
/* 4446 */     this.glTexSubImage2D = caps.get(307);
/* 4447 */     this.glTranslatef = caps.get(308);
/* 4448 */     this.glTranslated = caps.get(309);
/* 4449 */     this.glVertex2f = caps.get(310);
/* 4450 */     this.glVertex2s = caps.get(311);
/* 4451 */     this.glVertex2i = caps.get(312);
/* 4452 */     this.glVertex2d = caps.get(313);
/* 4453 */     this.glVertex2fv = caps.get(314);
/* 4454 */     this.glVertex2sv = caps.get(315);
/* 4455 */     this.glVertex2iv = caps.get(316);
/* 4456 */     this.glVertex2dv = caps.get(317);
/* 4457 */     this.glVertex3f = caps.get(318);
/* 4458 */     this.glVertex3s = caps.get(319);
/* 4459 */     this.glVertex3i = caps.get(320);
/* 4460 */     this.glVertex3d = caps.get(321);
/* 4461 */     this.glVertex3fv = caps.get(322);
/* 4462 */     this.glVertex3sv = caps.get(323);
/* 4463 */     this.glVertex3iv = caps.get(324);
/* 4464 */     this.glVertex3dv = caps.get(325);
/* 4465 */     this.glVertex4f = caps.get(326);
/* 4466 */     this.glVertex4s = caps.get(327);
/* 4467 */     this.glVertex4i = caps.get(328);
/* 4468 */     this.glVertex4d = caps.get(329);
/* 4469 */     this.glVertex4fv = caps.get(330);
/* 4470 */     this.glVertex4sv = caps.get(331);
/* 4471 */     this.glVertex4iv = caps.get(332);
/* 4472 */     this.glVertex4dv = caps.get(333);
/* 4473 */     this.glVertexPointer = caps.get(334);
/* 4474 */     this.glViewport = caps.get(335);
/* 4475 */     this.glTexImage3D = caps.get(336);
/* 4476 */     this.glTexSubImage3D = caps.get(337);
/* 4477 */     this.glCopyTexSubImage3D = caps.get(338);
/* 4478 */     this.glDrawRangeElements = caps.get(339);
/* 4479 */     this.glCompressedTexImage3D = caps.get(340);
/* 4480 */     this.glCompressedTexImage2D = caps.get(341);
/* 4481 */     this.glCompressedTexImage1D = caps.get(342);
/* 4482 */     this.glCompressedTexSubImage3D = caps.get(343);
/* 4483 */     this.glCompressedTexSubImage2D = caps.get(344);
/* 4484 */     this.glCompressedTexSubImage1D = caps.get(345);
/* 4485 */     this.glGetCompressedTexImage = caps.get(346);
/* 4486 */     this.glSampleCoverage = caps.get(347);
/* 4487 */     this.glActiveTexture = caps.get(348);
/* 4488 */     this.glClientActiveTexture = caps.get(349);
/* 4489 */     this.glMultiTexCoord1f = caps.get(350);
/* 4490 */     this.glMultiTexCoord1s = caps.get(351);
/* 4491 */     this.glMultiTexCoord1i = caps.get(352);
/* 4492 */     this.glMultiTexCoord1d = caps.get(353);
/* 4493 */     this.glMultiTexCoord1fv = caps.get(354);
/* 4494 */     this.glMultiTexCoord1sv = caps.get(355);
/* 4495 */     this.glMultiTexCoord1iv = caps.get(356);
/* 4496 */     this.glMultiTexCoord1dv = caps.get(357);
/* 4497 */     this.glMultiTexCoord2f = caps.get(358);
/* 4498 */     this.glMultiTexCoord2s = caps.get(359);
/* 4499 */     this.glMultiTexCoord2i = caps.get(360);
/* 4500 */     this.glMultiTexCoord2d = caps.get(361);
/* 4501 */     this.glMultiTexCoord2fv = caps.get(362);
/* 4502 */     this.glMultiTexCoord2sv = caps.get(363);
/* 4503 */     this.glMultiTexCoord2iv = caps.get(364);
/* 4504 */     this.glMultiTexCoord2dv = caps.get(365);
/* 4505 */     this.glMultiTexCoord3f = caps.get(366);
/* 4506 */     this.glMultiTexCoord3s = caps.get(367);
/* 4507 */     this.glMultiTexCoord3i = caps.get(368);
/* 4508 */     this.glMultiTexCoord3d = caps.get(369);
/* 4509 */     this.glMultiTexCoord3fv = caps.get(370);
/* 4510 */     this.glMultiTexCoord3sv = caps.get(371);
/* 4511 */     this.glMultiTexCoord3iv = caps.get(372);
/* 4512 */     this.glMultiTexCoord3dv = caps.get(373);
/* 4513 */     this.glMultiTexCoord4f = caps.get(374);
/* 4514 */     this.glMultiTexCoord4s = caps.get(375);
/* 4515 */     this.glMultiTexCoord4i = caps.get(376);
/* 4516 */     this.glMultiTexCoord4d = caps.get(377);
/* 4517 */     this.glMultiTexCoord4fv = caps.get(378);
/* 4518 */     this.glMultiTexCoord4sv = caps.get(379);
/* 4519 */     this.glMultiTexCoord4iv = caps.get(380);
/* 4520 */     this.glMultiTexCoord4dv = caps.get(381);
/* 4521 */     this.glLoadTransposeMatrixf = caps.get(382);
/* 4522 */     this.glLoadTransposeMatrixd = caps.get(383);
/* 4523 */     this.glMultTransposeMatrixf = caps.get(384);
/* 4524 */     this.glMultTransposeMatrixd = caps.get(385);
/* 4525 */     this.glBlendColor = caps.get(386);
/* 4526 */     this.glBlendEquation = caps.get(387);
/* 4527 */     this.glFogCoordf = caps.get(388);
/* 4528 */     this.glFogCoordd = caps.get(389);
/* 4529 */     this.glFogCoordfv = caps.get(390);
/* 4530 */     this.glFogCoorddv = caps.get(391);
/* 4531 */     this.glFogCoordPointer = caps.get(392);
/* 4532 */     this.glMultiDrawArrays = caps.get(393);
/* 4533 */     this.glMultiDrawElements = caps.get(394);
/* 4534 */     this.glPointParameterf = caps.get(395);
/* 4535 */     this.glPointParameteri = caps.get(396);
/* 4536 */     this.glPointParameterfv = caps.get(397);
/* 4537 */     this.glPointParameteriv = caps.get(398);
/* 4538 */     this.glSecondaryColor3b = caps.get(399);
/* 4539 */     this.glSecondaryColor3s = caps.get(400);
/* 4540 */     this.glSecondaryColor3i = caps.get(401);
/* 4541 */     this.glSecondaryColor3f = caps.get(402);
/* 4542 */     this.glSecondaryColor3d = caps.get(403);
/* 4543 */     this.glSecondaryColor3ub = caps.get(404);
/* 4544 */     this.glSecondaryColor3us = caps.get(405);
/* 4545 */     this.glSecondaryColor3ui = caps.get(406);
/* 4546 */     this.glSecondaryColor3bv = caps.get(407);
/* 4547 */     this.glSecondaryColor3sv = caps.get(408);
/* 4548 */     this.glSecondaryColor3iv = caps.get(409);
/* 4549 */     this.glSecondaryColor3fv = caps.get(410);
/* 4550 */     this.glSecondaryColor3dv = caps.get(411);
/* 4551 */     this.glSecondaryColor3ubv = caps.get(412);
/* 4552 */     this.glSecondaryColor3usv = caps.get(413);
/* 4553 */     this.glSecondaryColor3uiv = caps.get(414);
/* 4554 */     this.glSecondaryColorPointer = caps.get(415);
/* 4555 */     this.glBlendFuncSeparate = caps.get(416);
/* 4556 */     this.glWindowPos2i = caps.get(417);
/* 4557 */     this.glWindowPos2s = caps.get(418);
/* 4558 */     this.glWindowPos2f = caps.get(419);
/* 4559 */     this.glWindowPos2d = caps.get(420);
/* 4560 */     this.glWindowPos2iv = caps.get(421);
/* 4561 */     this.glWindowPos2sv = caps.get(422);
/* 4562 */     this.glWindowPos2fv = caps.get(423);
/* 4563 */     this.glWindowPos2dv = caps.get(424);
/* 4564 */     this.glWindowPos3i = caps.get(425);
/* 4565 */     this.glWindowPos3s = caps.get(426);
/* 4566 */     this.glWindowPos3f = caps.get(427);
/* 4567 */     this.glWindowPos3d = caps.get(428);
/* 4568 */     this.glWindowPos3iv = caps.get(429);
/* 4569 */     this.glWindowPos3sv = caps.get(430);
/* 4570 */     this.glWindowPos3fv = caps.get(431);
/* 4571 */     this.glWindowPos3dv = caps.get(432);
/* 4572 */     this.glBindBuffer = caps.get(433);
/* 4573 */     this.glDeleteBuffers = caps.get(434);
/* 4574 */     this.glGenBuffers = caps.get(435);
/* 4575 */     this.glIsBuffer = caps.get(436);
/* 4576 */     this.glBufferData = caps.get(437);
/* 4577 */     this.glBufferSubData = caps.get(438);
/* 4578 */     this.glGetBufferSubData = caps.get(439);
/* 4579 */     this.glMapBuffer = caps.get(440);
/* 4580 */     this.glUnmapBuffer = caps.get(441);
/* 4581 */     this.glGetBufferParameteriv = caps.get(442);
/* 4582 */     this.glGetBufferPointerv = caps.get(443);
/* 4583 */     this.glGenQueries = caps.get(444);
/* 4584 */     this.glDeleteQueries = caps.get(445);
/* 4585 */     this.glIsQuery = caps.get(446);
/* 4586 */     this.glBeginQuery = caps.get(447);
/* 4587 */     this.glEndQuery = caps.get(448);
/* 4588 */     this.glGetQueryiv = caps.get(449);
/* 4589 */     this.glGetQueryObjectiv = caps.get(450);
/* 4590 */     this.glGetQueryObjectuiv = caps.get(451);
/* 4591 */     this.glCreateProgram = caps.get(452);
/* 4592 */     this.glDeleteProgram = caps.get(453);
/* 4593 */     this.glIsProgram = caps.get(454);
/* 4594 */     this.glCreateShader = caps.get(455);
/* 4595 */     this.glDeleteShader = caps.get(456);
/* 4596 */     this.glIsShader = caps.get(457);
/* 4597 */     this.glAttachShader = caps.get(458);
/* 4598 */     this.glDetachShader = caps.get(459);
/* 4599 */     this.glShaderSource = caps.get(460);
/* 4600 */     this.glCompileShader = caps.get(461);
/* 4601 */     this.glLinkProgram = caps.get(462);
/* 4602 */     this.glUseProgram = caps.get(463);
/* 4603 */     this.glValidateProgram = caps.get(464);
/* 4604 */     this.glUniform1f = caps.get(465);
/* 4605 */     this.glUniform2f = caps.get(466);
/* 4606 */     this.glUniform3f = caps.get(467);
/* 4607 */     this.glUniform4f = caps.get(468);
/* 4608 */     this.glUniform1i = caps.get(469);
/* 4609 */     this.glUniform2i = caps.get(470);
/* 4610 */     this.glUniform3i = caps.get(471);
/* 4611 */     this.glUniform4i = caps.get(472);
/* 4612 */     this.glUniform1fv = caps.get(473);
/* 4613 */     this.glUniform2fv = caps.get(474);
/* 4614 */     this.glUniform3fv = caps.get(475);
/* 4615 */     this.glUniform4fv = caps.get(476);
/* 4616 */     this.glUniform1iv = caps.get(477);
/* 4617 */     this.glUniform2iv = caps.get(478);
/* 4618 */     this.glUniform3iv = caps.get(479);
/* 4619 */     this.glUniform4iv = caps.get(480);
/* 4620 */     this.glUniformMatrix2fv = caps.get(481);
/* 4621 */     this.glUniformMatrix3fv = caps.get(482);
/* 4622 */     this.glUniformMatrix4fv = caps.get(483);
/* 4623 */     this.glGetShaderiv = caps.get(484);
/* 4624 */     this.glGetProgramiv = caps.get(485);
/* 4625 */     this.glGetShaderInfoLog = caps.get(486);
/* 4626 */     this.glGetProgramInfoLog = caps.get(487);
/* 4627 */     this.glGetAttachedShaders = caps.get(488);
/* 4628 */     this.glGetUniformLocation = caps.get(489);
/* 4629 */     this.glGetActiveUniform = caps.get(490);
/* 4630 */     this.glGetUniformfv = caps.get(491);
/* 4631 */     this.glGetUniformiv = caps.get(492);
/* 4632 */     this.glGetShaderSource = caps.get(493);
/* 4633 */     this.glVertexAttrib1f = caps.get(494);
/* 4634 */     this.glVertexAttrib1s = caps.get(495);
/* 4635 */     this.glVertexAttrib1d = caps.get(496);
/* 4636 */     this.glVertexAttrib2f = caps.get(497);
/* 4637 */     this.glVertexAttrib2s = caps.get(498);
/* 4638 */     this.glVertexAttrib2d = caps.get(499);
/* 4639 */     this.glVertexAttrib3f = caps.get(500);
/* 4640 */     this.glVertexAttrib3s = caps.get(501);
/* 4641 */     this.glVertexAttrib3d = caps.get(502);
/* 4642 */     this.glVertexAttrib4f = caps.get(503);
/* 4643 */     this.glVertexAttrib4s = caps.get(504);
/* 4644 */     this.glVertexAttrib4d = caps.get(505);
/* 4645 */     this.glVertexAttrib4Nub = caps.get(506);
/* 4646 */     this.glVertexAttrib1fv = caps.get(507);
/* 4647 */     this.glVertexAttrib1sv = caps.get(508);
/* 4648 */     this.glVertexAttrib1dv = caps.get(509);
/* 4649 */     this.glVertexAttrib2fv = caps.get(510);
/* 4650 */     this.glVertexAttrib2sv = caps.get(511);
/* 4651 */     this.glVertexAttrib2dv = caps.get(512);
/* 4652 */     this.glVertexAttrib3fv = caps.get(513);
/* 4653 */     this.glVertexAttrib3sv = caps.get(514);
/* 4654 */     this.glVertexAttrib3dv = caps.get(515);
/* 4655 */     this.glVertexAttrib4fv = caps.get(516);
/* 4656 */     this.glVertexAttrib4sv = caps.get(517);
/* 4657 */     this.glVertexAttrib4dv = caps.get(518);
/* 4658 */     this.glVertexAttrib4iv = caps.get(519);
/* 4659 */     this.glVertexAttrib4bv = caps.get(520);
/* 4660 */     this.glVertexAttrib4ubv = caps.get(521);
/* 4661 */     this.glVertexAttrib4usv = caps.get(522);
/* 4662 */     this.glVertexAttrib4uiv = caps.get(523);
/* 4663 */     this.glVertexAttrib4Nbv = caps.get(524);
/* 4664 */     this.glVertexAttrib4Nsv = caps.get(525);
/* 4665 */     this.glVertexAttrib4Niv = caps.get(526);
/* 4666 */     this.glVertexAttrib4Nubv = caps.get(527);
/* 4667 */     this.glVertexAttrib4Nusv = caps.get(528);
/* 4668 */     this.glVertexAttrib4Nuiv = caps.get(529);
/* 4669 */     this.glVertexAttribPointer = caps.get(530);
/* 4670 */     this.glEnableVertexAttribArray = caps.get(531);
/* 4671 */     this.glDisableVertexAttribArray = caps.get(532);
/* 4672 */     this.glBindAttribLocation = caps.get(533);
/* 4673 */     this.glGetActiveAttrib = caps.get(534);
/* 4674 */     this.glGetAttribLocation = caps.get(535);
/* 4675 */     this.glGetVertexAttribiv = caps.get(536);
/* 4676 */     this.glGetVertexAttribfv = caps.get(537);
/* 4677 */     this.glGetVertexAttribdv = caps.get(538);
/* 4678 */     this.glGetVertexAttribPointerv = caps.get(539);
/* 4679 */     this.glDrawBuffers = caps.get(540);
/* 4680 */     this.glBlendEquationSeparate = caps.get(541);
/* 4681 */     this.glStencilOpSeparate = caps.get(542);
/* 4682 */     this.glStencilFuncSeparate = caps.get(543);
/* 4683 */     this.glStencilMaskSeparate = caps.get(544);
/* 4684 */     this.glUniformMatrix2x3fv = caps.get(545);
/* 4685 */     this.glUniformMatrix3x2fv = caps.get(546);
/* 4686 */     this.glUniformMatrix2x4fv = caps.get(547);
/* 4687 */     this.glUniformMatrix4x2fv = caps.get(548);
/* 4688 */     this.glUniformMatrix3x4fv = caps.get(549);
/* 4689 */     this.glUniformMatrix4x3fv = caps.get(550);
/* 4690 */     this.glGetStringi = caps.get(551);
/* 4691 */     this.glClearBufferiv = caps.get(552);
/* 4692 */     this.glClearBufferuiv = caps.get(553);
/* 4693 */     this.glClearBufferfv = caps.get(554);
/* 4694 */     this.glClearBufferfi = caps.get(555);
/* 4695 */     this.glVertexAttribI1i = caps.get(556);
/* 4696 */     this.glVertexAttribI2i = caps.get(557);
/* 4697 */     this.glVertexAttribI3i = caps.get(558);
/* 4698 */     this.glVertexAttribI4i = caps.get(559);
/* 4699 */     this.glVertexAttribI1ui = caps.get(560);
/* 4700 */     this.glVertexAttribI2ui = caps.get(561);
/* 4701 */     this.glVertexAttribI3ui = caps.get(562);
/* 4702 */     this.glVertexAttribI4ui = caps.get(563);
/* 4703 */     this.glVertexAttribI1iv = caps.get(564);
/* 4704 */     this.glVertexAttribI2iv = caps.get(565);
/* 4705 */     this.glVertexAttribI3iv = caps.get(566);
/* 4706 */     this.glVertexAttribI4iv = caps.get(567);
/* 4707 */     this.glVertexAttribI1uiv = caps.get(568);
/* 4708 */     this.glVertexAttribI2uiv = caps.get(569);
/* 4709 */     this.glVertexAttribI3uiv = caps.get(570);
/* 4710 */     this.glVertexAttribI4uiv = caps.get(571);
/* 4711 */     this.glVertexAttribI4bv = caps.get(572);
/* 4712 */     this.glVertexAttribI4sv = caps.get(573);
/* 4713 */     this.glVertexAttribI4ubv = caps.get(574);
/* 4714 */     this.glVertexAttribI4usv = caps.get(575);
/* 4715 */     this.glVertexAttribIPointer = caps.get(576);
/* 4716 */     this.glGetVertexAttribIiv = caps.get(577);
/* 4717 */     this.glGetVertexAttribIuiv = caps.get(578);
/* 4718 */     this.glUniform1ui = caps.get(579);
/* 4719 */     this.glUniform2ui = caps.get(580);
/* 4720 */     this.glUniform3ui = caps.get(581);
/* 4721 */     this.glUniform4ui = caps.get(582);
/* 4722 */     this.glUniform1uiv = caps.get(583);
/* 4723 */     this.glUniform2uiv = caps.get(584);
/* 4724 */     this.glUniform3uiv = caps.get(585);
/* 4725 */     this.glUniform4uiv = caps.get(586);
/* 4726 */     this.glGetUniformuiv = caps.get(587);
/* 4727 */     this.glBindFragDataLocation = caps.get(588);
/* 4728 */     this.glGetFragDataLocation = caps.get(589);
/* 4729 */     this.glBeginConditionalRender = caps.get(590);
/* 4730 */     this.glEndConditionalRender = caps.get(591);
/* 4731 */     this.glMapBufferRange = caps.get(592);
/* 4732 */     this.glFlushMappedBufferRange = caps.get(593);
/* 4733 */     this.glClampColor = caps.get(594);
/* 4734 */     this.glIsRenderbuffer = caps.get(595);
/* 4735 */     this.glBindRenderbuffer = caps.get(596);
/* 4736 */     this.glDeleteRenderbuffers = caps.get(597);
/* 4737 */     this.glGenRenderbuffers = caps.get(598);
/* 4738 */     this.glRenderbufferStorage = caps.get(599);
/* 4739 */     this.glRenderbufferStorageMultisample = caps.get(600);
/* 4740 */     this.glGetRenderbufferParameteriv = caps.get(601);
/* 4741 */     this.glIsFramebuffer = caps.get(602);
/* 4742 */     this.glBindFramebuffer = caps.get(603);
/* 4743 */     this.glDeleteFramebuffers = caps.get(604);
/* 4744 */     this.glGenFramebuffers = caps.get(605);
/* 4745 */     this.glCheckFramebufferStatus = caps.get(606);
/* 4746 */     this.glFramebufferTexture1D = caps.get(607);
/* 4747 */     this.glFramebufferTexture2D = caps.get(608);
/* 4748 */     this.glFramebufferTexture3D = caps.get(609);
/* 4749 */     this.glFramebufferTextureLayer = caps.get(610);
/* 4750 */     this.glFramebufferRenderbuffer = caps.get(611);
/* 4751 */     this.glGetFramebufferAttachmentParameteriv = caps.get(612);
/* 4752 */     this.glBlitFramebuffer = caps.get(613);
/* 4753 */     this.glGenerateMipmap = caps.get(614);
/* 4754 */     this.glTexParameterIiv = caps.get(615);
/* 4755 */     this.glTexParameterIuiv = caps.get(616);
/* 4756 */     this.glGetTexParameterIiv = caps.get(617);
/* 4757 */     this.glGetTexParameterIuiv = caps.get(618);
/* 4758 */     this.glColorMaski = caps.get(619);
/* 4759 */     this.glGetBooleani_v = caps.get(620);
/* 4760 */     this.glGetIntegeri_v = caps.get(621);
/* 4761 */     this.glEnablei = caps.get(622);
/* 4762 */     this.glDisablei = caps.get(623);
/* 4763 */     this.glIsEnabledi = caps.get(624);
/* 4764 */     this.glBindBufferRange = caps.get(625);
/* 4765 */     this.glBindBufferBase = caps.get(626);
/* 4766 */     this.glBeginTransformFeedback = caps.get(627);
/* 4767 */     this.glEndTransformFeedback = caps.get(628);
/* 4768 */     this.glTransformFeedbackVaryings = caps.get(629);
/* 4769 */     this.glGetTransformFeedbackVarying = caps.get(630);
/* 4770 */     this.glBindVertexArray = caps.get(631);
/* 4771 */     this.glDeleteVertexArrays = caps.get(632);
/* 4772 */     this.glGenVertexArrays = caps.get(633);
/* 4773 */     this.glIsVertexArray = caps.get(634);
/* 4774 */     this.glDrawArraysInstanced = caps.get(635);
/* 4775 */     this.glDrawElementsInstanced = caps.get(636);
/* 4776 */     this.glCopyBufferSubData = caps.get(637);
/* 4777 */     this.glPrimitiveRestartIndex = caps.get(638);
/* 4778 */     this.glTexBuffer = caps.get(639);
/* 4779 */     this.glGetUniformIndices = caps.get(640);
/* 4780 */     this.glGetActiveUniformsiv = caps.get(641);
/* 4781 */     this.glGetActiveUniformName = caps.get(642);
/* 4782 */     this.glGetUniformBlockIndex = caps.get(643);
/* 4783 */     this.glGetActiveUniformBlockiv = caps.get(644);
/* 4784 */     this.glGetActiveUniformBlockName = caps.get(645);
/* 4785 */     this.glUniformBlockBinding = caps.get(646);
/* 4786 */     this.glGetBufferParameteri64v = caps.get(647);
/* 4787 */     this.glDrawElementsBaseVertex = caps.get(648);
/* 4788 */     this.glDrawRangeElementsBaseVertex = caps.get(649);
/* 4789 */     this.glDrawElementsInstancedBaseVertex = caps.get(650);
/* 4790 */     this.glMultiDrawElementsBaseVertex = caps.get(651);
/* 4791 */     this.glProvokingVertex = caps.get(652);
/* 4792 */     this.glTexImage2DMultisample = caps.get(653);
/* 4793 */     this.glTexImage3DMultisample = caps.get(654);
/* 4794 */     this.glGetMultisamplefv = caps.get(655);
/* 4795 */     this.glSampleMaski = caps.get(656);
/* 4796 */     this.glFramebufferTexture = caps.get(657);
/* 4797 */     this.glFenceSync = caps.get(658);
/* 4798 */     this.glIsSync = caps.get(659);
/* 4799 */     this.glDeleteSync = caps.get(660);
/* 4800 */     this.glClientWaitSync = caps.get(661);
/* 4801 */     this.glWaitSync = caps.get(662);
/* 4802 */     this.glGetInteger64v = caps.get(663);
/* 4803 */     this.glGetInteger64i_v = caps.get(664);
/* 4804 */     this.glGetSynciv = caps.get(665);
/* 4805 */     this.glBindFragDataLocationIndexed = caps.get(666);
/* 4806 */     this.glGetFragDataIndex = caps.get(667);
/* 4807 */     this.glGenSamplers = caps.get(668);
/* 4808 */     this.glDeleteSamplers = caps.get(669);
/* 4809 */     this.glIsSampler = caps.get(670);
/* 4810 */     this.glBindSampler = caps.get(671);
/* 4811 */     this.glSamplerParameteri = caps.get(672);
/* 4812 */     this.glSamplerParameterf = caps.get(673);
/* 4813 */     this.glSamplerParameteriv = caps.get(674);
/* 4814 */     this.glSamplerParameterfv = caps.get(675);
/* 4815 */     this.glSamplerParameterIiv = caps.get(676);
/* 4816 */     this.glSamplerParameterIuiv = caps.get(677);
/* 4817 */     this.glGetSamplerParameteriv = caps.get(678);
/* 4818 */     this.glGetSamplerParameterfv = caps.get(679);
/* 4819 */     this.glGetSamplerParameterIiv = caps.get(680);
/* 4820 */     this.glGetSamplerParameterIuiv = caps.get(681);
/* 4821 */     this.glQueryCounter = caps.get(682);
/* 4822 */     this.glGetQueryObjecti64v = caps.get(683);
/* 4823 */     this.glGetQueryObjectui64v = caps.get(684);
/* 4824 */     this.glVertexAttribDivisor = caps.get(685);
/* 4825 */     this.glVertexP2ui = caps.get(686);
/* 4826 */     this.glVertexP3ui = caps.get(687);
/* 4827 */     this.glVertexP4ui = caps.get(688);
/* 4828 */     this.glVertexP2uiv = caps.get(689);
/* 4829 */     this.glVertexP3uiv = caps.get(690);
/* 4830 */     this.glVertexP4uiv = caps.get(691);
/* 4831 */     this.glTexCoordP1ui = caps.get(692);
/* 4832 */     this.glTexCoordP2ui = caps.get(693);
/* 4833 */     this.glTexCoordP3ui = caps.get(694);
/* 4834 */     this.glTexCoordP4ui = caps.get(695);
/* 4835 */     this.glTexCoordP1uiv = caps.get(696);
/* 4836 */     this.glTexCoordP2uiv = caps.get(697);
/* 4837 */     this.glTexCoordP3uiv = caps.get(698);
/* 4838 */     this.glTexCoordP4uiv = caps.get(699);
/* 4839 */     this.glMultiTexCoordP1ui = caps.get(700);
/* 4840 */     this.glMultiTexCoordP2ui = caps.get(701);
/* 4841 */     this.glMultiTexCoordP3ui = caps.get(702);
/* 4842 */     this.glMultiTexCoordP4ui = caps.get(703);
/* 4843 */     this.glMultiTexCoordP1uiv = caps.get(704);
/* 4844 */     this.glMultiTexCoordP2uiv = caps.get(705);
/* 4845 */     this.glMultiTexCoordP3uiv = caps.get(706);
/* 4846 */     this.glMultiTexCoordP4uiv = caps.get(707);
/* 4847 */     this.glNormalP3ui = caps.get(708);
/* 4848 */     this.glNormalP3uiv = caps.get(709);
/* 4849 */     this.glColorP3ui = caps.get(710);
/* 4850 */     this.glColorP4ui = caps.get(711);
/* 4851 */     this.glColorP3uiv = caps.get(712);
/* 4852 */     this.glColorP4uiv = caps.get(713);
/* 4853 */     this.glSecondaryColorP3ui = caps.get(714);
/* 4854 */     this.glSecondaryColorP3uiv = caps.get(715);
/* 4855 */     this.glVertexAttribP1ui = caps.get(716);
/* 4856 */     this.glVertexAttribP2ui = caps.get(717);
/* 4857 */     this.glVertexAttribP3ui = caps.get(718);
/* 4858 */     this.glVertexAttribP4ui = caps.get(719);
/* 4859 */     this.glVertexAttribP1uiv = caps.get(720);
/* 4860 */     this.glVertexAttribP2uiv = caps.get(721);
/* 4861 */     this.glVertexAttribP3uiv = caps.get(722);
/* 4862 */     this.glVertexAttribP4uiv = caps.get(723);
/* 4863 */     this.glBlendEquationi = caps.get(724);
/* 4864 */     this.glBlendEquationSeparatei = caps.get(725);
/* 4865 */     this.glBlendFunci = caps.get(726);
/* 4866 */     this.glBlendFuncSeparatei = caps.get(727);
/* 4867 */     this.glDrawArraysIndirect = caps.get(728);
/* 4868 */     this.glDrawElementsIndirect = caps.get(729);
/* 4869 */     this.glUniform1d = caps.get(730);
/* 4870 */     this.glUniform2d = caps.get(731);
/* 4871 */     this.glUniform3d = caps.get(732);
/* 4872 */     this.glUniform4d = caps.get(733);
/* 4873 */     this.glUniform1dv = caps.get(734);
/* 4874 */     this.glUniform2dv = caps.get(735);
/* 4875 */     this.glUniform3dv = caps.get(736);
/* 4876 */     this.glUniform4dv = caps.get(737);
/* 4877 */     this.glUniformMatrix2dv = caps.get(738);
/* 4878 */     this.glUniformMatrix3dv = caps.get(739);
/* 4879 */     this.glUniformMatrix4dv = caps.get(740);
/* 4880 */     this.glUniformMatrix2x3dv = caps.get(741);
/* 4881 */     this.glUniformMatrix2x4dv = caps.get(742);
/* 4882 */     this.glUniformMatrix3x2dv = caps.get(743);
/* 4883 */     this.glUniformMatrix3x4dv = caps.get(744);
/* 4884 */     this.glUniformMatrix4x2dv = caps.get(745);
/* 4885 */     this.glUniformMatrix4x3dv = caps.get(746);
/* 4886 */     this.glGetUniformdv = caps.get(747);
/* 4887 */     this.glMinSampleShading = caps.get(748);
/* 4888 */     this.glGetSubroutineUniformLocation = caps.get(749);
/* 4889 */     this.glGetSubroutineIndex = caps.get(750);
/* 4890 */     this.glGetActiveSubroutineUniformiv = caps.get(751);
/* 4891 */     this.glGetActiveSubroutineUniformName = caps.get(752);
/* 4892 */     this.glGetActiveSubroutineName = caps.get(753);
/* 4893 */     this.glUniformSubroutinesuiv = caps.get(754);
/* 4894 */     this.glGetUniformSubroutineuiv = caps.get(755);
/* 4895 */     this.glGetProgramStageiv = caps.get(756);
/* 4896 */     this.glPatchParameteri = caps.get(757);
/* 4897 */     this.glPatchParameterfv = caps.get(758);
/* 4898 */     this.glBindTransformFeedback = caps.get(759);
/* 4899 */     this.glDeleteTransformFeedbacks = caps.get(760);
/* 4900 */     this.glGenTransformFeedbacks = caps.get(761);
/* 4901 */     this.glIsTransformFeedback = caps.get(762);
/* 4902 */     this.glPauseTransformFeedback = caps.get(763);
/* 4903 */     this.glResumeTransformFeedback = caps.get(764);
/* 4904 */     this.glDrawTransformFeedback = caps.get(765);
/* 4905 */     this.glDrawTransformFeedbackStream = caps.get(766);
/* 4906 */     this.glBeginQueryIndexed = caps.get(767);
/* 4907 */     this.glEndQueryIndexed = caps.get(768);
/* 4908 */     this.glGetQueryIndexediv = caps.get(769);
/* 4909 */     this.glReleaseShaderCompiler = caps.get(770);
/* 4910 */     this.glShaderBinary = caps.get(771);
/* 4911 */     this.glGetShaderPrecisionFormat = caps.get(772);
/* 4912 */     this.glDepthRangef = caps.get(773);
/* 4913 */     this.glClearDepthf = caps.get(774);
/* 4914 */     this.glGetProgramBinary = caps.get(775);
/* 4915 */     this.glProgramBinary = caps.get(776);
/* 4916 */     this.glProgramParameteri = caps.get(777);
/* 4917 */     this.glUseProgramStages = caps.get(778);
/* 4918 */     this.glActiveShaderProgram = caps.get(779);
/* 4919 */     this.glCreateShaderProgramv = caps.get(780);
/* 4920 */     this.glBindProgramPipeline = caps.get(781);
/* 4921 */     this.glDeleteProgramPipelines = caps.get(782);
/* 4922 */     this.glGenProgramPipelines = caps.get(783);
/* 4923 */     this.glIsProgramPipeline = caps.get(784);
/* 4924 */     this.glGetProgramPipelineiv = caps.get(785);
/* 4925 */     this.glProgramUniform1i = caps.get(786);
/* 4926 */     this.glProgramUniform2i = caps.get(787);
/* 4927 */     this.glProgramUniform3i = caps.get(788);
/* 4928 */     this.glProgramUniform4i = caps.get(789);
/* 4929 */     this.glProgramUniform1ui = caps.get(790);
/* 4930 */     this.glProgramUniform2ui = caps.get(791);
/* 4931 */     this.glProgramUniform3ui = caps.get(792);
/* 4932 */     this.glProgramUniform4ui = caps.get(793);
/* 4933 */     this.glProgramUniform1f = caps.get(794);
/* 4934 */     this.glProgramUniform2f = caps.get(795);
/* 4935 */     this.glProgramUniform3f = caps.get(796);
/* 4936 */     this.glProgramUniform4f = caps.get(797);
/* 4937 */     this.glProgramUniform1d = caps.get(798);
/* 4938 */     this.glProgramUniform2d = caps.get(799);
/* 4939 */     this.glProgramUniform3d = caps.get(800);
/* 4940 */     this.glProgramUniform4d = caps.get(801);
/* 4941 */     this.glProgramUniform1iv = caps.get(802);
/* 4942 */     this.glProgramUniform2iv = caps.get(803);
/* 4943 */     this.glProgramUniform3iv = caps.get(804);
/* 4944 */     this.glProgramUniform4iv = caps.get(805);
/* 4945 */     this.glProgramUniform1uiv = caps.get(806);
/* 4946 */     this.glProgramUniform2uiv = caps.get(807);
/* 4947 */     this.glProgramUniform3uiv = caps.get(808);
/* 4948 */     this.glProgramUniform4uiv = caps.get(809);
/* 4949 */     this.glProgramUniform1fv = caps.get(810);
/* 4950 */     this.glProgramUniform2fv = caps.get(811);
/* 4951 */     this.glProgramUniform3fv = caps.get(812);
/* 4952 */     this.glProgramUniform4fv = caps.get(813);
/* 4953 */     this.glProgramUniform1dv = caps.get(814);
/* 4954 */     this.glProgramUniform2dv = caps.get(815);
/* 4955 */     this.glProgramUniform3dv = caps.get(816);
/* 4956 */     this.glProgramUniform4dv = caps.get(817);
/* 4957 */     this.glProgramUniformMatrix2fv = caps.get(818);
/* 4958 */     this.glProgramUniformMatrix3fv = caps.get(819);
/* 4959 */     this.glProgramUniformMatrix4fv = caps.get(820);
/* 4960 */     this.glProgramUniformMatrix2dv = caps.get(821);
/* 4961 */     this.glProgramUniformMatrix3dv = caps.get(822);
/* 4962 */     this.glProgramUniformMatrix4dv = caps.get(823);
/* 4963 */     this.glProgramUniformMatrix2x3fv = caps.get(824);
/* 4964 */     this.glProgramUniformMatrix3x2fv = caps.get(825);
/* 4965 */     this.glProgramUniformMatrix2x4fv = caps.get(826);
/* 4966 */     this.glProgramUniformMatrix4x2fv = caps.get(827);
/* 4967 */     this.glProgramUniformMatrix3x4fv = caps.get(828);
/* 4968 */     this.glProgramUniformMatrix4x3fv = caps.get(829);
/* 4969 */     this.glProgramUniformMatrix2x3dv = caps.get(830);
/* 4970 */     this.glProgramUniformMatrix3x2dv = caps.get(831);
/* 4971 */     this.glProgramUniformMatrix2x4dv = caps.get(832);
/* 4972 */     this.glProgramUniformMatrix4x2dv = caps.get(833);
/* 4973 */     this.glProgramUniformMatrix3x4dv = caps.get(834);
/* 4974 */     this.glProgramUniformMatrix4x3dv = caps.get(835);
/* 4975 */     this.glValidateProgramPipeline = caps.get(836);
/* 4976 */     this.glGetProgramPipelineInfoLog = caps.get(837);
/* 4977 */     this.glVertexAttribL1d = caps.get(838);
/* 4978 */     this.glVertexAttribL2d = caps.get(839);
/* 4979 */     this.glVertexAttribL3d = caps.get(840);
/* 4980 */     this.glVertexAttribL4d = caps.get(841);
/* 4981 */     this.glVertexAttribL1dv = caps.get(842);
/* 4982 */     this.glVertexAttribL2dv = caps.get(843);
/* 4983 */     this.glVertexAttribL3dv = caps.get(844);
/* 4984 */     this.glVertexAttribL4dv = caps.get(845);
/* 4985 */     this.glVertexAttribLPointer = caps.get(846);
/* 4986 */     this.glGetVertexAttribLdv = caps.get(847);
/* 4987 */     this.glViewportArrayv = caps.get(848);
/* 4988 */     this.glViewportIndexedf = caps.get(849);
/* 4989 */     this.glViewportIndexedfv = caps.get(850);
/* 4990 */     this.glScissorArrayv = caps.get(851);
/* 4991 */     this.glScissorIndexed = caps.get(852);
/* 4992 */     this.glScissorIndexedv = caps.get(853);
/* 4993 */     this.glDepthRangeArrayv = caps.get(854);
/* 4994 */     this.glDepthRangeIndexed = caps.get(855);
/* 4995 */     this.glGetFloati_v = caps.get(856);
/* 4996 */     this.glGetDoublei_v = caps.get(857);
/* 4997 */     this.glGetActiveAtomicCounterBufferiv = caps.get(858);
/* 4998 */     this.glTexStorage1D = caps.get(859);
/* 4999 */     this.glTexStorage2D = caps.get(860);
/* 5000 */     this.glTexStorage3D = caps.get(861);
/* 5001 */     this.glDrawTransformFeedbackInstanced = caps.get(862);
/* 5002 */     this.glDrawTransformFeedbackStreamInstanced = caps.get(863);
/* 5003 */     this.glDrawArraysInstancedBaseInstance = caps.get(864);
/* 5004 */     this.glDrawElementsInstancedBaseInstance = caps.get(865);
/* 5005 */     this.glDrawElementsInstancedBaseVertexBaseInstance = caps.get(866);
/* 5006 */     this.glBindImageTexture = caps.get(867);
/* 5007 */     this.glMemoryBarrier = caps.get(868);
/* 5008 */     this.glGetInternalformativ = caps.get(869);
/* 5009 */     this.glClearBufferData = caps.get(870);
/* 5010 */     this.glClearBufferSubData = caps.get(871);
/* 5011 */     this.glDispatchCompute = caps.get(872);
/* 5012 */     this.glDispatchComputeIndirect = caps.get(873);
/* 5013 */     this.glCopyImageSubData = caps.get(874);
/* 5014 */     this.glDebugMessageControl = caps.get(875);
/* 5015 */     this.glDebugMessageInsert = caps.get(876);
/* 5016 */     this.glDebugMessageCallback = caps.get(877);
/* 5017 */     this.glGetDebugMessageLog = caps.get(878);
/* 5018 */     this.glPushDebugGroup = caps.get(879);
/* 5019 */     this.glPopDebugGroup = caps.get(880);
/* 5020 */     this.glObjectLabel = caps.get(881);
/* 5021 */     this.glGetObjectLabel = caps.get(882);
/* 5022 */     this.glObjectPtrLabel = caps.get(883);
/* 5023 */     this.glGetObjectPtrLabel = caps.get(884);
/* 5024 */     this.glFramebufferParameteri = caps.get(885);
/* 5025 */     this.glGetFramebufferParameteriv = caps.get(886);
/* 5026 */     this.glGetInternalformati64v = caps.get(887);
/* 5027 */     this.glInvalidateTexSubImage = caps.get(888);
/* 5028 */     this.glInvalidateTexImage = caps.get(889);
/* 5029 */     this.glInvalidateBufferSubData = caps.get(890);
/* 5030 */     this.glInvalidateBufferData = caps.get(891);
/* 5031 */     this.glInvalidateFramebuffer = caps.get(892);
/* 5032 */     this.glInvalidateSubFramebuffer = caps.get(893);
/* 5033 */     this.glMultiDrawArraysIndirect = caps.get(894);
/* 5034 */     this.glMultiDrawElementsIndirect = caps.get(895);
/* 5035 */     this.glGetProgramInterfaceiv = caps.get(896);
/* 5036 */     this.glGetProgramResourceIndex = caps.get(897);
/* 5037 */     this.glGetProgramResourceName = caps.get(898);
/* 5038 */     this.glGetProgramResourceiv = caps.get(899);
/* 5039 */     this.glGetProgramResourceLocation = caps.get(900);
/* 5040 */     this.glGetProgramResourceLocationIndex = caps.get(901);
/* 5041 */     this.glShaderStorageBlockBinding = caps.get(902);
/* 5042 */     this.glTexBufferRange = caps.get(903);
/* 5043 */     this.glTexStorage2DMultisample = caps.get(904);
/* 5044 */     this.glTexStorage3DMultisample = caps.get(905);
/* 5045 */     this.glTextureView = caps.get(906);
/* 5046 */     this.glBindVertexBuffer = caps.get(907);
/* 5047 */     this.glVertexAttribFormat = caps.get(908);
/* 5048 */     this.glVertexAttribIFormat = caps.get(909);
/* 5049 */     this.glVertexAttribLFormat = caps.get(910);
/* 5050 */     this.glVertexAttribBinding = caps.get(911);
/* 5051 */     this.glVertexBindingDivisor = caps.get(912);
/* 5052 */     this.glBufferStorage = caps.get(913);
/* 5053 */     this.glClearTexSubImage = caps.get(914);
/* 5054 */     this.glClearTexImage = caps.get(915);
/* 5055 */     this.glBindBuffersBase = caps.get(916);
/* 5056 */     this.glBindBuffersRange = caps.get(917);
/* 5057 */     this.glBindTextures = caps.get(918);
/* 5058 */     this.glBindSamplers = caps.get(919);
/* 5059 */     this.glBindImageTextures = caps.get(920);
/* 5060 */     this.glBindVertexBuffers = caps.get(921);
/* 5061 */     this.glClipControl = caps.get(922);
/* 5062 */     this.glCreateTransformFeedbacks = caps.get(923);
/* 5063 */     this.glTransformFeedbackBufferBase = caps.get(924);
/* 5064 */     this.glTransformFeedbackBufferRange = caps.get(925);
/* 5065 */     this.glGetTransformFeedbackiv = caps.get(926);
/* 5066 */     this.glGetTransformFeedbacki_v = caps.get(927);
/* 5067 */     this.glGetTransformFeedbacki64_v = caps.get(928);
/* 5068 */     this.glCreateBuffers = caps.get(929);
/* 5069 */     this.glNamedBufferStorage = caps.get(930);
/* 5070 */     this.glNamedBufferData = caps.get(931);
/* 5071 */     this.glNamedBufferSubData = caps.get(932);
/* 5072 */     this.glCopyNamedBufferSubData = caps.get(933);
/* 5073 */     this.glClearNamedBufferData = caps.get(934);
/* 5074 */     this.glClearNamedBufferSubData = caps.get(935);
/* 5075 */     this.glMapNamedBuffer = caps.get(936);
/* 5076 */     this.glMapNamedBufferRange = caps.get(937);
/* 5077 */     this.glUnmapNamedBuffer = caps.get(938);
/* 5078 */     this.glFlushMappedNamedBufferRange = caps.get(939);
/* 5079 */     this.glGetNamedBufferParameteriv = caps.get(940);
/* 5080 */     this.glGetNamedBufferParameteri64v = caps.get(941);
/* 5081 */     this.glGetNamedBufferPointerv = caps.get(942);
/* 5082 */     this.glGetNamedBufferSubData = caps.get(943);
/* 5083 */     this.glCreateFramebuffers = caps.get(944);
/* 5084 */     this.glNamedFramebufferRenderbuffer = caps.get(945);
/* 5085 */     this.glNamedFramebufferParameteri = caps.get(946);
/* 5086 */     this.glNamedFramebufferTexture = caps.get(947);
/* 5087 */     this.glNamedFramebufferTextureLayer = caps.get(948);
/* 5088 */     this.glNamedFramebufferDrawBuffer = caps.get(949);
/* 5089 */     this.glNamedFramebufferDrawBuffers = caps.get(950);
/* 5090 */     this.glNamedFramebufferReadBuffer = caps.get(951);
/* 5091 */     this.glInvalidateNamedFramebufferData = caps.get(952);
/* 5092 */     this.glInvalidateNamedFramebufferSubData = caps.get(953);
/* 5093 */     this.glClearNamedFramebufferiv = caps.get(954);
/* 5094 */     this.glClearNamedFramebufferuiv = caps.get(955);
/* 5095 */     this.glClearNamedFramebufferfv = caps.get(956);
/* 5096 */     this.glClearNamedFramebufferfi = caps.get(957);
/* 5097 */     this.glBlitNamedFramebuffer = caps.get(958);
/* 5098 */     this.glCheckNamedFramebufferStatus = caps.get(959);
/* 5099 */     this.glGetNamedFramebufferParameteriv = caps.get(960);
/* 5100 */     this.glGetNamedFramebufferAttachmentParameteriv = caps.get(961);
/* 5101 */     this.glCreateRenderbuffers = caps.get(962);
/* 5102 */     this.glNamedRenderbufferStorage = caps.get(963);
/* 5103 */     this.glNamedRenderbufferStorageMultisample = caps.get(964);
/* 5104 */     this.glGetNamedRenderbufferParameteriv = caps.get(965);
/* 5105 */     this.glCreateTextures = caps.get(966);
/* 5106 */     this.glTextureBuffer = caps.get(967);
/* 5107 */     this.glTextureBufferRange = caps.get(968);
/* 5108 */     this.glTextureStorage1D = caps.get(969);
/* 5109 */     this.glTextureStorage2D = caps.get(970);
/* 5110 */     this.glTextureStorage3D = caps.get(971);
/* 5111 */     this.glTextureStorage2DMultisample = caps.get(972);
/* 5112 */     this.glTextureStorage3DMultisample = caps.get(973);
/* 5113 */     this.glTextureSubImage1D = caps.get(974);
/* 5114 */     this.glTextureSubImage2D = caps.get(975);
/* 5115 */     this.glTextureSubImage3D = caps.get(976);
/* 5116 */     this.glCompressedTextureSubImage1D = caps.get(977);
/* 5117 */     this.glCompressedTextureSubImage2D = caps.get(978);
/* 5118 */     this.glCompressedTextureSubImage3D = caps.get(979);
/* 5119 */     this.glCopyTextureSubImage1D = caps.get(980);
/* 5120 */     this.glCopyTextureSubImage2D = caps.get(981);
/* 5121 */     this.glCopyTextureSubImage3D = caps.get(982);
/* 5122 */     this.glTextureParameterf = caps.get(983);
/* 5123 */     this.glTextureParameterfv = caps.get(984);
/* 5124 */     this.glTextureParameteri = caps.get(985);
/* 5125 */     this.glTextureParameterIiv = caps.get(986);
/* 5126 */     this.glTextureParameterIuiv = caps.get(987);
/* 5127 */     this.glTextureParameteriv = caps.get(988);
/* 5128 */     this.glGenerateTextureMipmap = caps.get(989);
/* 5129 */     this.glBindTextureUnit = caps.get(990);
/* 5130 */     this.glGetTextureImage = caps.get(991);
/* 5131 */     this.glGetCompressedTextureImage = caps.get(992);
/* 5132 */     this.glGetTextureLevelParameterfv = caps.get(993);
/* 5133 */     this.glGetTextureLevelParameteriv = caps.get(994);
/* 5134 */     this.glGetTextureParameterfv = caps.get(995);
/* 5135 */     this.glGetTextureParameterIiv = caps.get(996);
/* 5136 */     this.glGetTextureParameterIuiv = caps.get(997);
/* 5137 */     this.glGetTextureParameteriv = caps.get(998);
/* 5138 */     this.glCreateVertexArrays = caps.get(999);
/* 5139 */     this.glDisableVertexArrayAttrib = caps.get(1000);
/* 5140 */     this.glEnableVertexArrayAttrib = caps.get(1001);
/* 5141 */     this.glVertexArrayElementBuffer = caps.get(1002);
/* 5142 */     this.glVertexArrayVertexBuffer = caps.get(1003);
/* 5143 */     this.glVertexArrayVertexBuffers = caps.get(1004);
/* 5144 */     this.glVertexArrayAttribFormat = caps.get(1005);
/* 5145 */     this.glVertexArrayAttribIFormat = caps.get(1006);
/* 5146 */     this.glVertexArrayAttribLFormat = caps.get(1007);
/* 5147 */     this.glVertexArrayAttribBinding = caps.get(1008);
/* 5148 */     this.glVertexArrayBindingDivisor = caps.get(1009);
/* 5149 */     this.glGetVertexArrayiv = caps.get(1010);
/* 5150 */     this.glGetVertexArrayIndexediv = caps.get(1011);
/* 5151 */     this.glGetVertexArrayIndexed64iv = caps.get(1012);
/* 5152 */     this.glCreateSamplers = caps.get(1013);
/* 5153 */     this.glCreateProgramPipelines = caps.get(1014);
/* 5154 */     this.glCreateQueries = caps.get(1015);
/* 5155 */     this.glGetQueryBufferObjectiv = caps.get(1016);
/* 5156 */     this.glGetQueryBufferObjectuiv = caps.get(1017);
/* 5157 */     this.glGetQueryBufferObjecti64v = caps.get(1018);
/* 5158 */     this.glGetQueryBufferObjectui64v = caps.get(1019);
/* 5159 */     this.glMemoryBarrierByRegion = caps.get(1020);
/* 5160 */     this.glGetTextureSubImage = caps.get(1021);
/* 5161 */     this.glGetCompressedTextureSubImage = caps.get(1022);
/* 5162 */     this.glTextureBarrier = caps.get(1023);
/* 5163 */     this.glGetGraphicsResetStatus = caps.get(1024);
/* 5164 */     this.glGetnMapdv = caps.get(1025);
/* 5165 */     this.glGetnMapfv = caps.get(1026);
/* 5166 */     this.glGetnMapiv = caps.get(1027);
/* 5167 */     this.glGetnPixelMapfv = caps.get(1028);
/* 5168 */     this.glGetnPixelMapuiv = caps.get(1029);
/* 5169 */     this.glGetnPixelMapusv = caps.get(1030);
/* 5170 */     this.glGetnPolygonStipple = caps.get(1031);
/* 5171 */     this.glGetnTexImage = caps.get(1032);
/* 5172 */     this.glReadnPixels = caps.get(1033);
/* 5173 */     this.glGetnColorTable = caps.get(1034);
/* 5174 */     this.glGetnConvolutionFilter = caps.get(1035);
/* 5175 */     this.glGetnSeparableFilter = caps.get(1036);
/* 5176 */     this.glGetnHistogram = caps.get(1037);
/* 5177 */     this.glGetnMinmax = caps.get(1038);
/* 5178 */     this.glGetnCompressedTexImage = caps.get(1039);
/* 5179 */     this.glGetnUniformfv = caps.get(1040);
/* 5180 */     this.glGetnUniformdv = caps.get(1041);
/* 5181 */     this.glGetnUniformiv = caps.get(1042);
/* 5182 */     this.glGetnUniformuiv = caps.get(1043);
/* 5183 */     this.glMultiDrawArraysIndirectCount = caps.get(1044);
/* 5184 */     this.glMultiDrawElementsIndirectCount = caps.get(1045);
/* 5185 */     this.glPolygonOffsetClamp = caps.get(1046);
/* 5186 */     this.glSpecializeShader = caps.get(1047);
/* 5187 */     this.glDebugMessageEnableAMD = caps.get(1048);
/* 5188 */     this.glDebugMessageInsertAMD = caps.get(1049);
/* 5189 */     this.glDebugMessageCallbackAMD = caps.get(1050);
/* 5190 */     this.glGetDebugMessageLogAMD = caps.get(1051);
/* 5191 */     this.glBlendFuncIndexedAMD = caps.get(1052);
/* 5192 */     this.glBlendFuncSeparateIndexedAMD = caps.get(1053);
/* 5193 */     this.glBlendEquationIndexedAMD = caps.get(1054);
/* 5194 */     this.glBlendEquationSeparateIndexedAMD = caps.get(1055);
/* 5195 */     this.glRenderbufferStorageMultisampleAdvancedAMD = caps.get(1056);
/* 5196 */     this.glNamedRenderbufferStorageMultisampleAdvancedAMD = caps.get(1057);
/* 5197 */     this.glUniform1i64NV = caps.get(1058);
/* 5198 */     this.glUniform2i64NV = caps.get(1059);
/* 5199 */     this.glUniform3i64NV = caps.get(1060);
/* 5200 */     this.glUniform4i64NV = caps.get(1061);
/* 5201 */     this.glUniform1i64vNV = caps.get(1062);
/* 5202 */     this.glUniform2i64vNV = caps.get(1063);
/* 5203 */     this.glUniform3i64vNV = caps.get(1064);
/* 5204 */     this.glUniform4i64vNV = caps.get(1065);
/* 5205 */     this.glUniform1ui64NV = caps.get(1066);
/* 5206 */     this.glUniform2ui64NV = caps.get(1067);
/* 5207 */     this.glUniform3ui64NV = caps.get(1068);
/* 5208 */     this.glUniform4ui64NV = caps.get(1069);
/* 5209 */     this.glUniform1ui64vNV = caps.get(1070);
/* 5210 */     this.glUniform2ui64vNV = caps.get(1071);
/* 5211 */     this.glUniform3ui64vNV = caps.get(1072);
/* 5212 */     this.glUniform4ui64vNV = caps.get(1073);
/* 5213 */     this.glGetUniformi64vNV = caps.get(1074);
/* 5214 */     this.glGetUniformui64vNV = caps.get(1075);
/* 5215 */     this.glProgramUniform1i64NV = caps.get(1076);
/* 5216 */     this.glProgramUniform2i64NV = caps.get(1077);
/* 5217 */     this.glProgramUniform3i64NV = caps.get(1078);
/* 5218 */     this.glProgramUniform4i64NV = caps.get(1079);
/* 5219 */     this.glProgramUniform1i64vNV = caps.get(1080);
/* 5220 */     this.glProgramUniform2i64vNV = caps.get(1081);
/* 5221 */     this.glProgramUniform3i64vNV = caps.get(1082);
/* 5222 */     this.glProgramUniform4i64vNV = caps.get(1083);
/* 5223 */     this.glProgramUniform1ui64NV = caps.get(1084);
/* 5224 */     this.glProgramUniform2ui64NV = caps.get(1085);
/* 5225 */     this.glProgramUniform3ui64NV = caps.get(1086);
/* 5226 */     this.glProgramUniform4ui64NV = caps.get(1087);
/* 5227 */     this.glProgramUniform1ui64vNV = caps.get(1088);
/* 5228 */     this.glProgramUniform2ui64vNV = caps.get(1089);
/* 5229 */     this.glProgramUniform3ui64vNV = caps.get(1090);
/* 5230 */     this.glProgramUniform4ui64vNV = caps.get(1091);
/* 5231 */     this.glVertexAttribParameteriAMD = caps.get(1092);
/* 5232 */     this.glQueryObjectParameteruiAMD = caps.get(1093);
/* 5233 */     this.glGetPerfMonitorGroupsAMD = caps.get(1094);
/* 5234 */     this.glGetPerfMonitorCountersAMD = caps.get(1095);
/* 5235 */     this.glGetPerfMonitorGroupStringAMD = caps.get(1096);
/* 5236 */     this.glGetPerfMonitorCounterStringAMD = caps.get(1097);
/* 5237 */     this.glGetPerfMonitorCounterInfoAMD = caps.get(1098);
/* 5238 */     this.glGenPerfMonitorsAMD = caps.get(1099);
/* 5239 */     this.glDeletePerfMonitorsAMD = caps.get(1100);
/* 5240 */     this.glSelectPerfMonitorCountersAMD = caps.get(1101);
/* 5241 */     this.glBeginPerfMonitorAMD = caps.get(1102);
/* 5242 */     this.glEndPerfMonitorAMD = caps.get(1103);
/* 5243 */     this.glGetPerfMonitorCounterDataAMD = caps.get(1104);
/* 5244 */     this.glSetMultisamplefvAMD = caps.get(1105);
/* 5245 */     this.glTexStorageSparseAMD = caps.get(1106);
/* 5246 */     this.glTextureStorageSparseAMD = caps.get(1107);
/* 5247 */     this.glStencilOpValueAMD = caps.get(1108);
/* 5248 */     this.glTessellationFactorAMD = caps.get(1109);
/* 5249 */     this.glTessellationModeAMD = caps.get(1110);
/* 5250 */     this.glGetTextureHandleARB = caps.get(1111);
/* 5251 */     this.glGetTextureSamplerHandleARB = caps.get(1112);
/* 5252 */     this.glMakeTextureHandleResidentARB = caps.get(1113);
/* 5253 */     this.glMakeTextureHandleNonResidentARB = caps.get(1114);
/* 5254 */     this.glGetImageHandleARB = caps.get(1115);
/* 5255 */     this.glMakeImageHandleResidentARB = caps.get(1116);
/* 5256 */     this.glMakeImageHandleNonResidentARB = caps.get(1117);
/* 5257 */     this.glUniformHandleui64ARB = caps.get(1118);
/* 5258 */     this.glUniformHandleui64vARB = caps.get(1119);
/* 5259 */     this.glProgramUniformHandleui64ARB = caps.get(1120);
/* 5260 */     this.glProgramUniformHandleui64vARB = caps.get(1121);
/* 5261 */     this.glIsTextureHandleResidentARB = caps.get(1122);
/* 5262 */     this.glIsImageHandleResidentARB = caps.get(1123);
/* 5263 */     this.glVertexAttribL1ui64ARB = caps.get(1124);
/* 5264 */     this.glVertexAttribL1ui64vARB = caps.get(1125);
/* 5265 */     this.glGetVertexAttribLui64vARB = caps.get(1126);
/* 5266 */     this.glNamedBufferStorageEXT = caps.get(1127);
/* 5267 */     this.glCreateSyncFromCLeventARB = caps.get(1128);
/* 5268 */     this.glClearNamedBufferDataEXT = caps.get(1129);
/* 5269 */     this.glClearNamedBufferSubDataEXT = caps.get(1130);
/* 5270 */     this.glClampColorARB = caps.get(1131);
/* 5271 */     this.glDispatchComputeGroupSizeARB = caps.get(1132);
/* 5272 */     this.glDebugMessageControlARB = caps.get(1133);
/* 5273 */     this.glDebugMessageInsertARB = caps.get(1134);
/* 5274 */     this.glDebugMessageCallbackARB = caps.get(1135);
/* 5275 */     this.glGetDebugMessageLogARB = caps.get(1136);
/* 5276 */     this.glDrawBuffersARB = caps.get(1137);
/* 5277 */     this.glBlendEquationiARB = caps.get(1138);
/* 5278 */     this.glBlendEquationSeparateiARB = caps.get(1139);
/* 5279 */     this.glBlendFunciARB = caps.get(1140);
/* 5280 */     this.glBlendFuncSeparateiARB = caps.get(1141);
/* 5281 */     this.glDrawArraysInstancedARB = caps.get(1142);
/* 5282 */     this.glDrawElementsInstancedARB = caps.get(1143);
/* 5283 */     this.glPrimitiveBoundingBoxARB = caps.get(1144);
/* 5284 */     this.glNamedFramebufferParameteriEXT = caps.get(1145);
/* 5285 */     this.glGetNamedFramebufferParameterivEXT = caps.get(1146);
/* 5286 */     this.glProgramParameteriARB = caps.get(1147);
/* 5287 */     this.glFramebufferTextureARB = caps.get(1148);
/* 5288 */     this.glFramebufferTextureLayerARB = caps.get(1149);
/* 5289 */     this.glFramebufferTextureFaceARB = caps.get(1150);
/* 5290 */     this.glSpecializeShaderARB = caps.get(1151);
/* 5291 */     this.glProgramUniform1dEXT = caps.get(1152);
/* 5292 */     this.glProgramUniform2dEXT = caps.get(1153);
/* 5293 */     this.glProgramUniform3dEXT = caps.get(1154);
/* 5294 */     this.glProgramUniform4dEXT = caps.get(1155);
/* 5295 */     this.glProgramUniform1dvEXT = caps.get(1156);
/* 5296 */     this.glProgramUniform2dvEXT = caps.get(1157);
/* 5297 */     this.glProgramUniform3dvEXT = caps.get(1158);
/* 5298 */     this.glProgramUniform4dvEXT = caps.get(1159);
/* 5299 */     this.glProgramUniformMatrix2dvEXT = caps.get(1160);
/* 5300 */     this.glProgramUniformMatrix3dvEXT = caps.get(1161);
/* 5301 */     this.glProgramUniformMatrix4dvEXT = caps.get(1162);
/* 5302 */     this.glProgramUniformMatrix2x3dvEXT = caps.get(1163);
/* 5303 */     this.glProgramUniformMatrix2x4dvEXT = caps.get(1164);
/* 5304 */     this.glProgramUniformMatrix3x2dvEXT = caps.get(1165);
/* 5305 */     this.glProgramUniformMatrix3x4dvEXT = caps.get(1166);
/* 5306 */     this.glProgramUniformMatrix4x2dvEXT = caps.get(1167);
/* 5307 */     this.glProgramUniformMatrix4x3dvEXT = caps.get(1168);
/* 5308 */     this.glUniform1i64ARB = caps.get(1169);
/* 5309 */     this.glUniform1i64vARB = caps.get(1170);
/* 5310 */     this.glProgramUniform1i64ARB = caps.get(1171);
/* 5311 */     this.glProgramUniform1i64vARB = caps.get(1172);
/* 5312 */     this.glUniform2i64ARB = caps.get(1173);
/* 5313 */     this.glUniform2i64vARB = caps.get(1174);
/* 5314 */     this.glProgramUniform2i64ARB = caps.get(1175);
/* 5315 */     this.glProgramUniform2i64vARB = caps.get(1176);
/* 5316 */     this.glUniform3i64ARB = caps.get(1177);
/* 5317 */     this.glUniform3i64vARB = caps.get(1178);
/* 5318 */     this.glProgramUniform3i64ARB = caps.get(1179);
/* 5319 */     this.glProgramUniform3i64vARB = caps.get(1180);
/* 5320 */     this.glUniform4i64ARB = caps.get(1181);
/* 5321 */     this.glUniform4i64vARB = caps.get(1182);
/* 5322 */     this.glProgramUniform4i64ARB = caps.get(1183);
/* 5323 */     this.glProgramUniform4i64vARB = caps.get(1184);
/* 5324 */     this.glUniform1ui64ARB = caps.get(1185);
/* 5325 */     this.glUniform1ui64vARB = caps.get(1186);
/* 5326 */     this.glProgramUniform1ui64ARB = caps.get(1187);
/* 5327 */     this.glProgramUniform1ui64vARB = caps.get(1188);
/* 5328 */     this.glUniform2ui64ARB = caps.get(1189);
/* 5329 */     this.glUniform2ui64vARB = caps.get(1190);
/* 5330 */     this.glProgramUniform2ui64ARB = caps.get(1191);
/* 5331 */     this.glProgramUniform2ui64vARB = caps.get(1192);
/* 5332 */     this.glUniform3ui64ARB = caps.get(1193);
/* 5333 */     this.glUniform3ui64vARB = caps.get(1194);
/* 5334 */     this.glProgramUniform3ui64ARB = caps.get(1195);
/* 5335 */     this.glProgramUniform3ui64vARB = caps.get(1196);
/* 5336 */     this.glUniform4ui64ARB = caps.get(1197);
/* 5337 */     this.glUniform4ui64vARB = caps.get(1198);
/* 5338 */     this.glProgramUniform4ui64ARB = caps.get(1199);
/* 5339 */     this.glProgramUniform4ui64vARB = caps.get(1200);
/* 5340 */     this.glGetUniformi64vARB = caps.get(1201);
/* 5341 */     this.glGetUniformui64vARB = caps.get(1202);
/* 5342 */     this.glGetnUniformi64vARB = caps.get(1203);
/* 5343 */     this.glGetnUniformui64vARB = caps.get(1204);
/* 5344 */     this.glColorTable = caps.get(1205);
/* 5345 */     this.glCopyColorTable = caps.get(1206);
/* 5346 */     this.glColorTableParameteriv = caps.get(1207);
/* 5347 */     this.glColorTableParameterfv = caps.get(1208);
/* 5348 */     this.glGetColorTable = caps.get(1209);
/* 5349 */     this.glGetColorTableParameteriv = caps.get(1210);
/* 5350 */     this.glGetColorTableParameterfv = caps.get(1211);
/* 5351 */     this.glColorSubTable = caps.get(1212);
/* 5352 */     this.glCopyColorSubTable = caps.get(1213);
/* 5353 */     this.glConvolutionFilter1D = caps.get(1214);
/* 5354 */     this.glConvolutionFilter2D = caps.get(1215);
/* 5355 */     this.glCopyConvolutionFilter1D = caps.get(1216);
/* 5356 */     this.glCopyConvolutionFilter2D = caps.get(1217);
/* 5357 */     this.glGetConvolutionFilter = caps.get(1218);
/* 5358 */     this.glSeparableFilter2D = caps.get(1219);
/* 5359 */     this.glGetSeparableFilter = caps.get(1220);
/* 5360 */     this.glConvolutionParameteri = caps.get(1221);
/* 5361 */     this.glConvolutionParameteriv = caps.get(1222);
/* 5362 */     this.glConvolutionParameterf = caps.get(1223);
/* 5363 */     this.glConvolutionParameterfv = caps.get(1224);
/* 5364 */     this.glGetConvolutionParameteriv = caps.get(1225);
/* 5365 */     this.glGetConvolutionParameterfv = caps.get(1226);
/* 5366 */     this.glHistogram = caps.get(1227);
/* 5367 */     this.glResetHistogram = caps.get(1228);
/* 5368 */     this.glGetHistogram = caps.get(1229);
/* 5369 */     this.glGetHistogramParameteriv = caps.get(1230);
/* 5370 */     this.glGetHistogramParameterfv = caps.get(1231);
/* 5371 */     this.glMinmax = caps.get(1232);
/* 5372 */     this.glResetMinmax = caps.get(1233);
/* 5373 */     this.glGetMinmax = caps.get(1234);
/* 5374 */     this.glGetMinmaxParameteriv = caps.get(1235);
/* 5375 */     this.glGetMinmaxParameterfv = caps.get(1236);
/* 5376 */     this.glMultiDrawArraysIndirectCountARB = caps.get(1237);
/* 5377 */     this.glMultiDrawElementsIndirectCountARB = caps.get(1238);
/* 5378 */     this.glVertexAttribDivisorARB = caps.get(1239);
/* 5379 */     this.glVertexArrayVertexAttribDivisorEXT = caps.get(1240);
/* 5380 */     this.glCurrentPaletteMatrixARB = caps.get(1241);
/* 5381 */     this.glMatrixIndexuivARB = caps.get(1242);
/* 5382 */     this.glMatrixIndexubvARB = caps.get(1243);
/* 5383 */     this.glMatrixIndexusvARB = caps.get(1244);
/* 5384 */     this.glMatrixIndexPointerARB = caps.get(1245);
/* 5385 */     this.glSampleCoverageARB = caps.get(1246);
/* 5386 */     this.glActiveTextureARB = caps.get(1247);
/* 5387 */     this.glClientActiveTextureARB = caps.get(1248);
/* 5388 */     this.glMultiTexCoord1fARB = caps.get(1249);
/* 5389 */     this.glMultiTexCoord1sARB = caps.get(1250);
/* 5390 */     this.glMultiTexCoord1iARB = caps.get(1251);
/* 5391 */     this.glMultiTexCoord1dARB = caps.get(1252);
/* 5392 */     this.glMultiTexCoord1fvARB = caps.get(1253);
/* 5393 */     this.glMultiTexCoord1svARB = caps.get(1254);
/* 5394 */     this.glMultiTexCoord1ivARB = caps.get(1255);
/* 5395 */     this.glMultiTexCoord1dvARB = caps.get(1256);
/* 5396 */     this.glMultiTexCoord2fARB = caps.get(1257);
/* 5397 */     this.glMultiTexCoord2sARB = caps.get(1258);
/* 5398 */     this.glMultiTexCoord2iARB = caps.get(1259);
/* 5399 */     this.glMultiTexCoord2dARB = caps.get(1260);
/* 5400 */     this.glMultiTexCoord2fvARB = caps.get(1261);
/* 5401 */     this.glMultiTexCoord2svARB = caps.get(1262);
/* 5402 */     this.glMultiTexCoord2ivARB = caps.get(1263);
/* 5403 */     this.glMultiTexCoord2dvARB = caps.get(1264);
/* 5404 */     this.glMultiTexCoord3fARB = caps.get(1265);
/* 5405 */     this.glMultiTexCoord3sARB = caps.get(1266);
/* 5406 */     this.glMultiTexCoord3iARB = caps.get(1267);
/* 5407 */     this.glMultiTexCoord3dARB = caps.get(1268);
/* 5408 */     this.glMultiTexCoord3fvARB = caps.get(1269);
/* 5409 */     this.glMultiTexCoord3svARB = caps.get(1270);
/* 5410 */     this.glMultiTexCoord3ivARB = caps.get(1271);
/* 5411 */     this.glMultiTexCoord3dvARB = caps.get(1272);
/* 5412 */     this.glMultiTexCoord4fARB = caps.get(1273);
/* 5413 */     this.glMultiTexCoord4sARB = caps.get(1274);
/* 5414 */     this.glMultiTexCoord4iARB = caps.get(1275);
/* 5415 */     this.glMultiTexCoord4dARB = caps.get(1276);
/* 5416 */     this.glMultiTexCoord4fvARB = caps.get(1277);
/* 5417 */     this.glMultiTexCoord4svARB = caps.get(1278);
/* 5418 */     this.glMultiTexCoord4ivARB = caps.get(1279);
/* 5419 */     this.glMultiTexCoord4dvARB = caps.get(1280);
/* 5420 */     this.glGenQueriesARB = caps.get(1281);
/* 5421 */     this.glDeleteQueriesARB = caps.get(1282);
/* 5422 */     this.glIsQueryARB = caps.get(1283);
/* 5423 */     this.glBeginQueryARB = caps.get(1284);
/* 5424 */     this.glEndQueryARB = caps.get(1285);
/* 5425 */     this.glGetQueryivARB = caps.get(1286);
/* 5426 */     this.glGetQueryObjectivARB = caps.get(1287);
/* 5427 */     this.glGetQueryObjectuivARB = caps.get(1288);
/* 5428 */     this.glMaxShaderCompilerThreadsARB = caps.get(1289);
/* 5429 */     this.glPointParameterfARB = caps.get(1290);
/* 5430 */     this.glPointParameterfvARB = caps.get(1291);
/* 5431 */     this.glGetGraphicsResetStatusARB = caps.get(1292);
/* 5432 */     this.glGetnMapdvARB = caps.get(1293);
/* 5433 */     this.glGetnMapfvARB = caps.get(1294);
/* 5434 */     this.glGetnMapivARB = caps.get(1295);
/* 5435 */     this.glGetnPixelMapfvARB = caps.get(1296);
/* 5436 */     this.glGetnPixelMapuivARB = caps.get(1297);
/* 5437 */     this.glGetnPixelMapusvARB = caps.get(1298);
/* 5438 */     this.glGetnPolygonStippleARB = caps.get(1299);
/* 5439 */     this.glGetnTexImageARB = caps.get(1300);
/* 5440 */     this.glReadnPixelsARB = caps.get(1301);
/* 5441 */     this.glGetnColorTableARB = caps.get(1302);
/* 5442 */     this.glGetnConvolutionFilterARB = caps.get(1303);
/* 5443 */     this.glGetnSeparableFilterARB = caps.get(1304);
/* 5444 */     this.glGetnHistogramARB = caps.get(1305);
/* 5445 */     this.glGetnMinmaxARB = caps.get(1306);
/* 5446 */     this.glGetnCompressedTexImageARB = caps.get(1307);
/* 5447 */     this.glGetnUniformfvARB = caps.get(1308);
/* 5448 */     this.glGetnUniformivARB = caps.get(1309);
/* 5449 */     this.glGetnUniformuivARB = caps.get(1310);
/* 5450 */     this.glGetnUniformdvARB = caps.get(1311);
/* 5451 */     this.glFramebufferSampleLocationsfvARB = caps.get(1312);
/* 5452 */     this.glNamedFramebufferSampleLocationsfvARB = caps.get(1313);
/* 5453 */     this.glEvaluateDepthValuesARB = caps.get(1314);
/* 5454 */     this.glMinSampleShadingARB = caps.get(1315);
/* 5455 */     this.glDeleteObjectARB = caps.get(1316);
/* 5456 */     this.glGetHandleARB = caps.get(1317);
/* 5457 */     this.glDetachObjectARB = caps.get(1318);
/* 5458 */     this.glCreateShaderObjectARB = caps.get(1319);
/* 5459 */     this.glShaderSourceARB = caps.get(1320);
/* 5460 */     this.glCompileShaderARB = caps.get(1321);
/* 5461 */     this.glCreateProgramObjectARB = caps.get(1322);
/* 5462 */     this.glAttachObjectARB = caps.get(1323);
/* 5463 */     this.glLinkProgramARB = caps.get(1324);
/* 5464 */     this.glUseProgramObjectARB = caps.get(1325);
/* 5465 */     this.glValidateProgramARB = caps.get(1326);
/* 5466 */     this.glUniform1fARB = caps.get(1327);
/* 5467 */     this.glUniform2fARB = caps.get(1328);
/* 5468 */     this.glUniform3fARB = caps.get(1329);
/* 5469 */     this.glUniform4fARB = caps.get(1330);
/* 5470 */     this.glUniform1iARB = caps.get(1331);
/* 5471 */     this.glUniform2iARB = caps.get(1332);
/* 5472 */     this.glUniform3iARB = caps.get(1333);
/* 5473 */     this.glUniform4iARB = caps.get(1334);
/* 5474 */     this.glUniform1fvARB = caps.get(1335);
/* 5475 */     this.glUniform2fvARB = caps.get(1336);
/* 5476 */     this.glUniform3fvARB = caps.get(1337);
/* 5477 */     this.glUniform4fvARB = caps.get(1338);
/* 5478 */     this.glUniform1ivARB = caps.get(1339);
/* 5479 */     this.glUniform2ivARB = caps.get(1340);
/* 5480 */     this.glUniform3ivARB = caps.get(1341);
/* 5481 */     this.glUniform4ivARB = caps.get(1342);
/* 5482 */     this.glUniformMatrix2fvARB = caps.get(1343);
/* 5483 */     this.glUniformMatrix3fvARB = caps.get(1344);
/* 5484 */     this.glUniformMatrix4fvARB = caps.get(1345);
/* 5485 */     this.glGetObjectParameterfvARB = caps.get(1346);
/* 5486 */     this.glGetObjectParameterivARB = caps.get(1347);
/* 5487 */     this.glGetInfoLogARB = caps.get(1348);
/* 5488 */     this.glGetAttachedObjectsARB = caps.get(1349);
/* 5489 */     this.glGetUniformLocationARB = caps.get(1350);
/* 5490 */     this.glGetActiveUniformARB = caps.get(1351);
/* 5491 */     this.glGetUniformfvARB = caps.get(1352);
/* 5492 */     this.glGetUniformivARB = caps.get(1353);
/* 5493 */     this.glGetShaderSourceARB = caps.get(1354);
/* 5494 */     this.glNamedStringARB = caps.get(1355);
/* 5495 */     this.glDeleteNamedStringARB = caps.get(1356);
/* 5496 */     this.glCompileShaderIncludeARB = caps.get(1357);
/* 5497 */     this.glIsNamedStringARB = caps.get(1358);
/* 5498 */     this.glGetNamedStringARB = caps.get(1359);
/* 5499 */     this.glGetNamedStringivARB = caps.get(1360);
/* 5500 */     this.glBufferPageCommitmentARB = caps.get(1361);
/* 5501 */     this.glNamedBufferPageCommitmentEXT = caps.get(1362);
/* 5502 */     this.glNamedBufferPageCommitmentARB = caps.get(1363);
/* 5503 */     this.glTexPageCommitmentARB = caps.get(1364);
/* 5504 */     this.glTexturePageCommitmentEXT = caps.get(1365);
/* 5505 */     this.glTexBufferARB = caps.get(1366);
/* 5506 */     this.glTextureBufferRangeEXT = caps.get(1367);
/* 5507 */     this.glCompressedTexImage3DARB = caps.get(1368);
/* 5508 */     this.glCompressedTexImage2DARB = caps.get(1369);
/* 5509 */     this.glCompressedTexImage1DARB = caps.get(1370);
/* 5510 */     this.glCompressedTexSubImage3DARB = caps.get(1371);
/* 5511 */     this.glCompressedTexSubImage2DARB = caps.get(1372);
/* 5512 */     this.glCompressedTexSubImage1DARB = caps.get(1373);
/* 5513 */     this.glGetCompressedTexImageARB = caps.get(1374);
/* 5514 */     this.glTextureStorage1DEXT = caps.get(1375);
/* 5515 */     this.glTextureStorage2DEXT = caps.get(1376);
/* 5516 */     this.glTextureStorage3DEXT = caps.get(1377);
/* 5517 */     this.glTextureStorage2DMultisampleEXT = caps.get(1378);
/* 5518 */     this.glTextureStorage3DMultisampleEXT = caps.get(1379);
/* 5519 */     this.glLoadTransposeMatrixfARB = caps.get(1380);
/* 5520 */     this.glLoadTransposeMatrixdARB = caps.get(1381);
/* 5521 */     this.glMultTransposeMatrixfARB = caps.get(1382);
/* 5522 */     this.glMultTransposeMatrixdARB = caps.get(1383);
/* 5523 */     this.glVertexArrayVertexAttribLOffsetEXT = caps.get(1384);
/* 5524 */     this.glVertexArrayBindVertexBufferEXT = caps.get(1385);
/* 5525 */     this.glVertexArrayVertexAttribFormatEXT = caps.get(1386);
/* 5526 */     this.glVertexArrayVertexAttribIFormatEXT = caps.get(1387);
/* 5527 */     this.glVertexArrayVertexAttribLFormatEXT = caps.get(1388);
/* 5528 */     this.glVertexArrayVertexAttribBindingEXT = caps.get(1389);
/* 5529 */     this.glVertexArrayVertexBindingDivisorEXT = caps.get(1390);
/* 5530 */     this.glWeightfvARB = caps.get(1391);
/* 5531 */     this.glWeightbvARB = caps.get(1392);
/* 5532 */     this.glWeightubvARB = caps.get(1393);
/* 5533 */     this.glWeightsvARB = caps.get(1394);
/* 5534 */     this.glWeightusvARB = caps.get(1395);
/* 5535 */     this.glWeightivARB = caps.get(1396);
/* 5536 */     this.glWeightuivARB = caps.get(1397);
/* 5537 */     this.glWeightdvARB = caps.get(1398);
/* 5538 */     this.glWeightPointerARB = caps.get(1399);
/* 5539 */     this.glVertexBlendARB = caps.get(1400);
/* 5540 */     this.glBindBufferARB = caps.get(1401);
/* 5541 */     this.glDeleteBuffersARB = caps.get(1402);
/* 5542 */     this.glGenBuffersARB = caps.get(1403);
/* 5543 */     this.glIsBufferARB = caps.get(1404);
/* 5544 */     this.glBufferDataARB = caps.get(1405);
/* 5545 */     this.glBufferSubDataARB = caps.get(1406);
/* 5546 */     this.glGetBufferSubDataARB = caps.get(1407);
/* 5547 */     this.glMapBufferARB = caps.get(1408);
/* 5548 */     this.glUnmapBufferARB = caps.get(1409);
/* 5549 */     this.glGetBufferParameterivARB = caps.get(1410);
/* 5550 */     this.glGetBufferPointervARB = caps.get(1411);
/* 5551 */     this.glVertexAttrib1sARB = caps.get(1412);
/* 5552 */     this.glVertexAttrib1fARB = caps.get(1413);
/* 5553 */     this.glVertexAttrib1dARB = caps.get(1414);
/* 5554 */     this.glVertexAttrib2sARB = caps.get(1415);
/* 5555 */     this.glVertexAttrib2fARB = caps.get(1416);
/* 5556 */     this.glVertexAttrib2dARB = caps.get(1417);
/* 5557 */     this.glVertexAttrib3sARB = caps.get(1418);
/* 5558 */     this.glVertexAttrib3fARB = caps.get(1419);
/* 5559 */     this.glVertexAttrib3dARB = caps.get(1420);
/* 5560 */     this.glVertexAttrib4sARB = caps.get(1421);
/* 5561 */     this.glVertexAttrib4fARB = caps.get(1422);
/* 5562 */     this.glVertexAttrib4dARB = caps.get(1423);
/* 5563 */     this.glVertexAttrib4NubARB = caps.get(1424);
/* 5564 */     this.glVertexAttrib1svARB = caps.get(1425);
/* 5565 */     this.glVertexAttrib1fvARB = caps.get(1426);
/* 5566 */     this.glVertexAttrib1dvARB = caps.get(1427);
/* 5567 */     this.glVertexAttrib2svARB = caps.get(1428);
/* 5568 */     this.glVertexAttrib2fvARB = caps.get(1429);
/* 5569 */     this.glVertexAttrib2dvARB = caps.get(1430);
/* 5570 */     this.glVertexAttrib3svARB = caps.get(1431);
/* 5571 */     this.glVertexAttrib3fvARB = caps.get(1432);
/* 5572 */     this.glVertexAttrib3dvARB = caps.get(1433);
/* 5573 */     this.glVertexAttrib4fvARB = caps.get(1434);
/* 5574 */     this.glVertexAttrib4bvARB = caps.get(1435);
/* 5575 */     this.glVertexAttrib4svARB = caps.get(1436);
/* 5576 */     this.glVertexAttrib4ivARB = caps.get(1437);
/* 5577 */     this.glVertexAttrib4ubvARB = caps.get(1438);
/* 5578 */     this.glVertexAttrib4usvARB = caps.get(1439);
/* 5579 */     this.glVertexAttrib4uivARB = caps.get(1440);
/* 5580 */     this.glVertexAttrib4dvARB = caps.get(1441);
/* 5581 */     this.glVertexAttrib4NbvARB = caps.get(1442);
/* 5582 */     this.glVertexAttrib4NsvARB = caps.get(1443);
/* 5583 */     this.glVertexAttrib4NivARB = caps.get(1444);
/* 5584 */     this.glVertexAttrib4NubvARB = caps.get(1445);
/* 5585 */     this.glVertexAttrib4NusvARB = caps.get(1446);
/* 5586 */     this.glVertexAttrib4NuivARB = caps.get(1447);
/* 5587 */     this.glVertexAttribPointerARB = caps.get(1448);
/* 5588 */     this.glEnableVertexAttribArrayARB = caps.get(1449);
/* 5589 */     this.glDisableVertexAttribArrayARB = caps.get(1450);
/* 5590 */     this.glProgramStringARB = caps.get(1451);
/* 5591 */     this.glBindProgramARB = caps.get(1452);
/* 5592 */     this.glDeleteProgramsARB = caps.get(1453);
/* 5593 */     this.glGenProgramsARB = caps.get(1454);
/* 5594 */     this.glProgramEnvParameter4dARB = caps.get(1455);
/* 5595 */     this.glProgramEnvParameter4dvARB = caps.get(1456);
/* 5596 */     this.glProgramEnvParameter4fARB = caps.get(1457);
/* 5597 */     this.glProgramEnvParameter4fvARB = caps.get(1458);
/* 5598 */     this.glProgramLocalParameter4dARB = caps.get(1459);
/* 5599 */     this.glProgramLocalParameter4dvARB = caps.get(1460);
/* 5600 */     this.glProgramLocalParameter4fARB = caps.get(1461);
/* 5601 */     this.glProgramLocalParameter4fvARB = caps.get(1462);
/* 5602 */     this.glGetProgramEnvParameterfvARB = caps.get(1463);
/* 5603 */     this.glGetProgramEnvParameterdvARB = caps.get(1464);
/* 5604 */     this.glGetProgramLocalParameterfvARB = caps.get(1465);
/* 5605 */     this.glGetProgramLocalParameterdvARB = caps.get(1466);
/* 5606 */     this.glGetProgramivARB = caps.get(1467);
/* 5607 */     this.glGetProgramStringARB = caps.get(1468);
/* 5608 */     this.glGetVertexAttribfvARB = caps.get(1469);
/* 5609 */     this.glGetVertexAttribdvARB = caps.get(1470);
/* 5610 */     this.glGetVertexAttribivARB = caps.get(1471);
/* 5611 */     this.glGetVertexAttribPointervARB = caps.get(1472);
/* 5612 */     this.glIsProgramARB = caps.get(1473);
/* 5613 */     this.glBindAttribLocationARB = caps.get(1474);
/* 5614 */     this.glGetActiveAttribARB = caps.get(1475);
/* 5615 */     this.glGetAttribLocationARB = caps.get(1476);
/* 5616 */     this.glWindowPos2iARB = caps.get(1477);
/* 5617 */     this.glWindowPos2sARB = caps.get(1478);
/* 5618 */     this.glWindowPos2fARB = caps.get(1479);
/* 5619 */     this.glWindowPos2dARB = caps.get(1480);
/* 5620 */     this.glWindowPos2ivARB = caps.get(1481);
/* 5621 */     this.glWindowPos2svARB = caps.get(1482);
/* 5622 */     this.glWindowPos2fvARB = caps.get(1483);
/* 5623 */     this.glWindowPos2dvARB = caps.get(1484);
/* 5624 */     this.glWindowPos3iARB = caps.get(1485);
/* 5625 */     this.glWindowPos3sARB = caps.get(1486);
/* 5626 */     this.glWindowPos3fARB = caps.get(1487);
/* 5627 */     this.glWindowPos3dARB = caps.get(1488);
/* 5628 */     this.glWindowPos3ivARB = caps.get(1489);
/* 5629 */     this.glWindowPos3svARB = caps.get(1490);
/* 5630 */     this.glWindowPos3fvARB = caps.get(1491);
/* 5631 */     this.glWindowPos3dvARB = caps.get(1492);
/* 5632 */     this.glUniformBufferEXT = caps.get(1493);
/* 5633 */     this.glGetUniformBufferSizeEXT = caps.get(1494);
/* 5634 */     this.glGetUniformOffsetEXT = caps.get(1495);
/* 5635 */     this.glBlendColorEXT = caps.get(1496);
/* 5636 */     this.glBlendEquationSeparateEXT = caps.get(1497);
/* 5637 */     this.glBlendFuncSeparateEXT = caps.get(1498);
/* 5638 */     this.glBlendEquationEXT = caps.get(1499);
/* 5639 */     this.glLockArraysEXT = caps.get(1500);
/* 5640 */     this.glUnlockArraysEXT = caps.get(1501);
/* 5641 */     this.glLabelObjectEXT = caps.get(1502);
/* 5642 */     this.glGetObjectLabelEXT = caps.get(1503);
/* 5643 */     this.glInsertEventMarkerEXT = caps.get(1504);
/* 5644 */     this.glPushGroupMarkerEXT = caps.get(1505);
/* 5645 */     this.glPopGroupMarkerEXT = caps.get(1506);
/* 5646 */     this.glDepthBoundsEXT = caps.get(1507);
/* 5647 */     this.glClientAttribDefaultEXT = caps.get(1508);
/* 5648 */     this.glPushClientAttribDefaultEXT = caps.get(1509);
/* 5649 */     this.glMatrixLoadfEXT = caps.get(1510);
/* 5650 */     this.glMatrixLoaddEXT = caps.get(1511);
/* 5651 */     this.glMatrixMultfEXT = caps.get(1512);
/* 5652 */     this.glMatrixMultdEXT = caps.get(1513);
/* 5653 */     this.glMatrixLoadIdentityEXT = caps.get(1514);
/* 5654 */     this.glMatrixRotatefEXT = caps.get(1515);
/* 5655 */     this.glMatrixRotatedEXT = caps.get(1516);
/* 5656 */     this.glMatrixScalefEXT = caps.get(1517);
/* 5657 */     this.glMatrixScaledEXT = caps.get(1518);
/* 5658 */     this.glMatrixTranslatefEXT = caps.get(1519);
/* 5659 */     this.glMatrixTranslatedEXT = caps.get(1520);
/* 5660 */     this.glMatrixOrthoEXT = caps.get(1521);
/* 5661 */     this.glMatrixFrustumEXT = caps.get(1522);
/* 5662 */     this.glMatrixPushEXT = caps.get(1523);
/* 5663 */     this.glMatrixPopEXT = caps.get(1524);
/* 5664 */     this.glTextureParameteriEXT = caps.get(1525);
/* 5665 */     this.glTextureParameterivEXT = caps.get(1526);
/* 5666 */     this.glTextureParameterfEXT = caps.get(1527);
/* 5667 */     this.glTextureParameterfvEXT = caps.get(1528);
/* 5668 */     this.glTextureImage1DEXT = caps.get(1529);
/* 5669 */     this.glTextureImage2DEXT = caps.get(1530);
/* 5670 */     this.glTextureSubImage1DEXT = caps.get(1531);
/* 5671 */     this.glTextureSubImage2DEXT = caps.get(1532);
/* 5672 */     this.glCopyTextureImage1DEXT = caps.get(1533);
/* 5673 */     this.glCopyTextureImage2DEXT = caps.get(1534);
/* 5674 */     this.glCopyTextureSubImage1DEXT = caps.get(1535);
/* 5675 */     this.glCopyTextureSubImage2DEXT = caps.get(1536);
/* 5676 */     this.glGetTextureImageEXT = caps.get(1537);
/* 5677 */     this.glGetTextureParameterfvEXT = caps.get(1538);
/* 5678 */     this.glGetTextureParameterivEXT = caps.get(1539);
/* 5679 */     this.glGetTextureLevelParameterfvEXT = caps.get(1540);
/* 5680 */     this.glGetTextureLevelParameterivEXT = caps.get(1541);
/* 5681 */     this.glTextureImage3DEXT = caps.get(1542);
/* 5682 */     this.glTextureSubImage3DEXT = caps.get(1543);
/* 5683 */     this.glCopyTextureSubImage3DEXT = caps.get(1544);
/* 5684 */     this.glBindMultiTextureEXT = caps.get(1545);
/* 5685 */     this.glMultiTexCoordPointerEXT = caps.get(1546);
/* 5686 */     this.glMultiTexEnvfEXT = caps.get(1547);
/* 5687 */     this.glMultiTexEnvfvEXT = caps.get(1548);
/* 5688 */     this.glMultiTexEnviEXT = caps.get(1549);
/* 5689 */     this.glMultiTexEnvivEXT = caps.get(1550);
/* 5690 */     this.glMultiTexGendEXT = caps.get(1551);
/* 5691 */     this.glMultiTexGendvEXT = caps.get(1552);
/* 5692 */     this.glMultiTexGenfEXT = caps.get(1553);
/* 5693 */     this.glMultiTexGenfvEXT = caps.get(1554);
/* 5694 */     this.glMultiTexGeniEXT = caps.get(1555);
/* 5695 */     this.glMultiTexGenivEXT = caps.get(1556);
/* 5696 */     this.glGetMultiTexEnvfvEXT = caps.get(1557);
/* 5697 */     this.glGetMultiTexEnvivEXT = caps.get(1558);
/* 5698 */     this.glGetMultiTexGendvEXT = caps.get(1559);
/* 5699 */     this.glGetMultiTexGenfvEXT = caps.get(1560);
/* 5700 */     this.glGetMultiTexGenivEXT = caps.get(1561);
/* 5701 */     this.glMultiTexParameteriEXT = caps.get(1562);
/* 5702 */     this.glMultiTexParameterivEXT = caps.get(1563);
/* 5703 */     this.glMultiTexParameterfEXT = caps.get(1564);
/* 5704 */     this.glMultiTexParameterfvEXT = caps.get(1565);
/* 5705 */     this.glMultiTexImage1DEXT = caps.get(1566);
/* 5706 */     this.glMultiTexImage2DEXT = caps.get(1567);
/* 5707 */     this.glMultiTexSubImage1DEXT = caps.get(1568);
/* 5708 */     this.glMultiTexSubImage2DEXT = caps.get(1569);
/* 5709 */     this.glCopyMultiTexImage1DEXT = caps.get(1570);
/* 5710 */     this.glCopyMultiTexImage2DEXT = caps.get(1571);
/* 5711 */     this.glCopyMultiTexSubImage1DEXT = caps.get(1572);
/* 5712 */     this.glCopyMultiTexSubImage2DEXT = caps.get(1573);
/* 5713 */     this.glGetMultiTexImageEXT = caps.get(1574);
/* 5714 */     this.glGetMultiTexParameterfvEXT = caps.get(1575);
/* 5715 */     this.glGetMultiTexParameterivEXT = caps.get(1576);
/* 5716 */     this.glGetMultiTexLevelParameterfvEXT = caps.get(1577);
/* 5717 */     this.glGetMultiTexLevelParameterivEXT = caps.get(1578);
/* 5718 */     this.glMultiTexImage3DEXT = caps.get(1579);
/* 5719 */     this.glMultiTexSubImage3DEXT = caps.get(1580);
/* 5720 */     this.glCopyMultiTexSubImage3DEXT = caps.get(1581);
/* 5721 */     this.glEnableClientStateIndexedEXT = caps.get(1582);
/* 5722 */     this.glDisableClientStateIndexedEXT = caps.get(1583);
/* 5723 */     this.glEnableClientStateiEXT = caps.get(1584);
/* 5724 */     this.glDisableClientStateiEXT = caps.get(1585);
/* 5725 */     this.glGetFloatIndexedvEXT = caps.get(1586);
/* 5726 */     this.glGetDoubleIndexedvEXT = caps.get(1587);
/* 5727 */     this.glGetPointerIndexedvEXT = caps.get(1588);
/* 5728 */     this.glGetFloati_vEXT = caps.get(1589);
/* 5729 */     this.glGetDoublei_vEXT = caps.get(1590);
/* 5730 */     this.glGetPointeri_vEXT = caps.get(1591);
/* 5731 */     this.glEnableIndexedEXT = caps.get(1592);
/* 5732 */     this.glDisableIndexedEXT = caps.get(1593);
/* 5733 */     this.glIsEnabledIndexedEXT = caps.get(1594);
/* 5734 */     this.glGetIntegerIndexedvEXT = caps.get(1595);
/* 5735 */     this.glGetBooleanIndexedvEXT = caps.get(1596);
/* 5736 */     this.glNamedProgramStringEXT = caps.get(1597);
/* 5737 */     this.glNamedProgramLocalParameter4dEXT = caps.get(1598);
/* 5738 */     this.glNamedProgramLocalParameter4dvEXT = caps.get(1599);
/* 5739 */     this.glNamedProgramLocalParameter4fEXT = caps.get(1600);
/* 5740 */     this.glNamedProgramLocalParameter4fvEXT = caps.get(1601);
/* 5741 */     this.glGetNamedProgramLocalParameterdvEXT = caps.get(1602);
/* 5742 */     this.glGetNamedProgramLocalParameterfvEXT = caps.get(1603);
/* 5743 */     this.glGetNamedProgramivEXT = caps.get(1604);
/* 5744 */     this.glGetNamedProgramStringEXT = caps.get(1605);
/* 5745 */     this.glCompressedTextureImage3DEXT = caps.get(1606);
/* 5746 */     this.glCompressedTextureImage2DEXT = caps.get(1607);
/* 5747 */     this.glCompressedTextureImage1DEXT = caps.get(1608);
/* 5748 */     this.glCompressedTextureSubImage3DEXT = caps.get(1609);
/* 5749 */     this.glCompressedTextureSubImage2DEXT = caps.get(1610);
/* 5750 */     this.glCompressedTextureSubImage1DEXT = caps.get(1611);
/* 5751 */     this.glGetCompressedTextureImageEXT = caps.get(1612);
/* 5752 */     this.glCompressedMultiTexImage3DEXT = caps.get(1613);
/* 5753 */     this.glCompressedMultiTexImage2DEXT = caps.get(1614);
/* 5754 */     this.glCompressedMultiTexImage1DEXT = caps.get(1615);
/* 5755 */     this.glCompressedMultiTexSubImage3DEXT = caps.get(1616);
/* 5756 */     this.glCompressedMultiTexSubImage2DEXT = caps.get(1617);
/* 5757 */     this.glCompressedMultiTexSubImage1DEXT = caps.get(1618);
/* 5758 */     this.glGetCompressedMultiTexImageEXT = caps.get(1619);
/* 5759 */     this.glMatrixLoadTransposefEXT = caps.get(1620);
/* 5760 */     this.glMatrixLoadTransposedEXT = caps.get(1621);
/* 5761 */     this.glMatrixMultTransposefEXT = caps.get(1622);
/* 5762 */     this.glMatrixMultTransposedEXT = caps.get(1623);
/* 5763 */     this.glNamedBufferDataEXT = caps.get(1624);
/* 5764 */     this.glNamedBufferSubDataEXT = caps.get(1625);
/* 5765 */     this.glMapNamedBufferEXT = caps.get(1626);
/* 5766 */     this.glUnmapNamedBufferEXT = caps.get(1627);
/* 5767 */     this.glGetNamedBufferParameterivEXT = caps.get(1628);
/* 5768 */     this.glGetNamedBufferSubDataEXT = caps.get(1629);
/* 5769 */     this.glProgramUniform1fEXT = caps.get(1630);
/* 5770 */     this.glProgramUniform2fEXT = caps.get(1631);
/* 5771 */     this.glProgramUniform3fEXT = caps.get(1632);
/* 5772 */     this.glProgramUniform4fEXT = caps.get(1633);
/* 5773 */     this.glProgramUniform1iEXT = caps.get(1634);
/* 5774 */     this.glProgramUniform2iEXT = caps.get(1635);
/* 5775 */     this.glProgramUniform3iEXT = caps.get(1636);
/* 5776 */     this.glProgramUniform4iEXT = caps.get(1637);
/* 5777 */     this.glProgramUniform1fvEXT = caps.get(1638);
/* 5778 */     this.glProgramUniform2fvEXT = caps.get(1639);
/* 5779 */     this.glProgramUniform3fvEXT = caps.get(1640);
/* 5780 */     this.glProgramUniform4fvEXT = caps.get(1641);
/* 5781 */     this.glProgramUniform1ivEXT = caps.get(1642);
/* 5782 */     this.glProgramUniform2ivEXT = caps.get(1643);
/* 5783 */     this.glProgramUniform3ivEXT = caps.get(1644);
/* 5784 */     this.glProgramUniform4ivEXT = caps.get(1645);
/* 5785 */     this.glProgramUniformMatrix2fvEXT = caps.get(1646);
/* 5786 */     this.glProgramUniformMatrix3fvEXT = caps.get(1647);
/* 5787 */     this.glProgramUniformMatrix4fvEXT = caps.get(1648);
/* 5788 */     this.glProgramUniformMatrix2x3fvEXT = caps.get(1649);
/* 5789 */     this.glProgramUniformMatrix3x2fvEXT = caps.get(1650);
/* 5790 */     this.glProgramUniformMatrix2x4fvEXT = caps.get(1651);
/* 5791 */     this.glProgramUniformMatrix4x2fvEXT = caps.get(1652);
/* 5792 */     this.glProgramUniformMatrix3x4fvEXT = caps.get(1653);
/* 5793 */     this.glProgramUniformMatrix4x3fvEXT = caps.get(1654);
/* 5794 */     this.glTextureBufferEXT = caps.get(1655);
/* 5795 */     this.glMultiTexBufferEXT = caps.get(1656);
/* 5796 */     this.glTextureParameterIivEXT = caps.get(1657);
/* 5797 */     this.glTextureParameterIuivEXT = caps.get(1658);
/* 5798 */     this.glGetTextureParameterIivEXT = caps.get(1659);
/* 5799 */     this.glGetTextureParameterIuivEXT = caps.get(1660);
/* 5800 */     this.glMultiTexParameterIivEXT = caps.get(1661);
/* 5801 */     this.glMultiTexParameterIuivEXT = caps.get(1662);
/* 5802 */     this.glGetMultiTexParameterIivEXT = caps.get(1663);
/* 5803 */     this.glGetMultiTexParameterIuivEXT = caps.get(1664);
/* 5804 */     this.glProgramUniform1uiEXT = caps.get(1665);
/* 5805 */     this.glProgramUniform2uiEXT = caps.get(1666);
/* 5806 */     this.glProgramUniform3uiEXT = caps.get(1667);
/* 5807 */     this.glProgramUniform4uiEXT = caps.get(1668);
/* 5808 */     this.glProgramUniform1uivEXT = caps.get(1669);
/* 5809 */     this.glProgramUniform2uivEXT = caps.get(1670);
/* 5810 */     this.glProgramUniform3uivEXT = caps.get(1671);
/* 5811 */     this.glProgramUniform4uivEXT = caps.get(1672);
/* 5812 */     this.glNamedProgramLocalParameters4fvEXT = caps.get(1673);
/* 5813 */     this.glNamedProgramLocalParameterI4iEXT = caps.get(1674);
/* 5814 */     this.glNamedProgramLocalParameterI4ivEXT = caps.get(1675);
/* 5815 */     this.glNamedProgramLocalParametersI4ivEXT = caps.get(1676);
/* 5816 */     this.glNamedProgramLocalParameterI4uiEXT = caps.get(1677);
/* 5817 */     this.glNamedProgramLocalParameterI4uivEXT = caps.get(1678);
/* 5818 */     this.glNamedProgramLocalParametersI4uivEXT = caps.get(1679);
/* 5819 */     this.glGetNamedProgramLocalParameterIivEXT = caps.get(1680);
/* 5820 */     this.glGetNamedProgramLocalParameterIuivEXT = caps.get(1681);
/* 5821 */     this.glNamedRenderbufferStorageEXT = caps.get(1682);
/* 5822 */     this.glGetNamedRenderbufferParameterivEXT = caps.get(1683);
/* 5823 */     this.glNamedRenderbufferStorageMultisampleEXT = caps.get(1684);
/* 5824 */     this.glNamedRenderbufferStorageMultisampleCoverageEXT = caps.get(1685);
/* 5825 */     this.glCheckNamedFramebufferStatusEXT = caps.get(1686);
/* 5826 */     this.glNamedFramebufferTexture1DEXT = caps.get(1687);
/* 5827 */     this.glNamedFramebufferTexture2DEXT = caps.get(1688);
/* 5828 */     this.glNamedFramebufferTexture3DEXT = caps.get(1689);
/* 5829 */     this.glNamedFramebufferRenderbufferEXT = caps.get(1690);
/* 5830 */     this.glGetNamedFramebufferAttachmentParameterivEXT = caps.get(1691);
/* 5831 */     this.glGenerateTextureMipmapEXT = caps.get(1692);
/* 5832 */     this.glGenerateMultiTexMipmapEXT = caps.get(1693);
/* 5833 */     this.glFramebufferDrawBufferEXT = caps.get(1694);
/* 5834 */     this.glFramebufferDrawBuffersEXT = caps.get(1695);
/* 5835 */     this.glFramebufferReadBufferEXT = caps.get(1696);
/* 5836 */     this.glGetFramebufferParameterivEXT = caps.get(1697);
/* 5837 */     this.glNamedCopyBufferSubDataEXT = caps.get(1698);
/* 5838 */     this.glNamedFramebufferTextureEXT = caps.get(1699);
/* 5839 */     this.glNamedFramebufferTextureLayerEXT = caps.get(1700);
/* 5840 */     this.glNamedFramebufferTextureFaceEXT = caps.get(1701);
/* 5841 */     this.glTextureRenderbufferEXT = caps.get(1702);
/* 5842 */     this.glMultiTexRenderbufferEXT = caps.get(1703);
/* 5843 */     this.glVertexArrayVertexOffsetEXT = caps.get(1704);
/* 5844 */     this.glVertexArrayColorOffsetEXT = caps.get(1705);
/* 5845 */     this.glVertexArrayEdgeFlagOffsetEXT = caps.get(1706);
/* 5846 */     this.glVertexArrayIndexOffsetEXT = caps.get(1707);
/* 5847 */     this.glVertexArrayNormalOffsetEXT = caps.get(1708);
/* 5848 */     this.glVertexArrayTexCoordOffsetEXT = caps.get(1709);
/* 5849 */     this.glVertexArrayMultiTexCoordOffsetEXT = caps.get(1710);
/* 5850 */     this.glVertexArrayFogCoordOffsetEXT = caps.get(1711);
/* 5851 */     this.glVertexArraySecondaryColorOffsetEXT = caps.get(1712);
/* 5852 */     this.glVertexArrayVertexAttribOffsetEXT = caps.get(1713);
/* 5853 */     this.glVertexArrayVertexAttribIOffsetEXT = caps.get(1714);
/* 5854 */     this.glEnableVertexArrayEXT = caps.get(1715);
/* 5855 */     this.glDisableVertexArrayEXT = caps.get(1716);
/* 5856 */     this.glEnableVertexArrayAttribEXT = caps.get(1717);
/* 5857 */     this.glDisableVertexArrayAttribEXT = caps.get(1718);
/* 5858 */     this.glGetVertexArrayIntegervEXT = caps.get(1719);
/* 5859 */     this.glGetVertexArrayPointervEXT = caps.get(1720);
/* 5860 */     this.glGetVertexArrayIntegeri_vEXT = caps.get(1721);
/* 5861 */     this.glGetVertexArrayPointeri_vEXT = caps.get(1722);
/* 5862 */     this.glMapNamedBufferRangeEXT = caps.get(1723);
/* 5863 */     this.glFlushMappedNamedBufferRangeEXT = caps.get(1724);
/* 5864 */     this.glColorMaskIndexedEXT = caps.get(1725);
/* 5865 */     this.glDrawArraysInstancedEXT = caps.get(1726);
/* 5866 */     this.glDrawElementsInstancedEXT = caps.get(1727);
/* 5867 */     this.glEGLImageTargetTexStorageEXT = caps.get(1728);
/* 5868 */     this.glEGLImageTargetTextureStorageEXT = caps.get(1729);
/* 5869 */     this.glBufferStorageExternalEXT = caps.get(1730);
/* 5870 */     this.glNamedBufferStorageExternalEXT = caps.get(1731);
/* 5871 */     this.glShadingRateEXT = caps.get(1732);
/* 5872 */     this.glShadingRateCombinerOpsEXT = caps.get(1733);
/* 5873 */     this.glFramebufferShadingRateEXT = caps.get(1734);
/* 5874 */     this.glGetFragmentShadingRatesEXT = caps.get(1735);
/* 5875 */     this.glBlitFramebufferEXT = caps.get(1736);
/* 5876 */     this.glBlitFramebufferLayersEXT = caps.get(1737);
/* 5877 */     this.glBlitFramebufferLayerEXT = caps.get(1738);
/* 5878 */     this.glRenderbufferStorageMultisampleEXT = caps.get(1739);
/* 5879 */     this.glIsRenderbufferEXT = caps.get(1740);
/* 5880 */     this.glBindRenderbufferEXT = caps.get(1741);
/* 5881 */     this.glDeleteRenderbuffersEXT = caps.get(1742);
/* 5882 */     this.glGenRenderbuffersEXT = caps.get(1743);
/* 5883 */     this.glRenderbufferStorageEXT = caps.get(1744);
/* 5884 */     this.glGetRenderbufferParameterivEXT = caps.get(1745);
/* 5885 */     this.glIsFramebufferEXT = caps.get(1746);
/* 5886 */     this.glBindFramebufferEXT = caps.get(1747);
/* 5887 */     this.glDeleteFramebuffersEXT = caps.get(1748);
/* 5888 */     this.glGenFramebuffersEXT = caps.get(1749);
/* 5889 */     this.glCheckFramebufferStatusEXT = caps.get(1750);
/* 5890 */     this.glFramebufferTexture1DEXT = caps.get(1751);
/* 5891 */     this.glFramebufferTexture2DEXT = caps.get(1752);
/* 5892 */     this.glFramebufferTexture3DEXT = caps.get(1753);
/* 5893 */     this.glFramebufferRenderbufferEXT = caps.get(1754);
/* 5894 */     this.glGetFramebufferAttachmentParameterivEXT = caps.get(1755);
/* 5895 */     this.glGenerateMipmapEXT = caps.get(1756);
/* 5896 */     this.glProgramParameteriEXT = caps.get(1757);
/* 5897 */     this.glFramebufferTextureEXT = caps.get(1758);
/* 5898 */     this.glFramebufferTextureLayerEXT = caps.get(1759);
/* 5899 */     this.glFramebufferTextureFaceEXT = caps.get(1760);
/* 5900 */     this.glProgramEnvParameters4fvEXT = caps.get(1761);
/* 5901 */     this.glProgramLocalParameters4fvEXT = caps.get(1762);
/* 5902 */     this.glVertexAttribI1iEXT = caps.get(1763);
/* 5903 */     this.glVertexAttribI2iEXT = caps.get(1764);
/* 5904 */     this.glVertexAttribI3iEXT = caps.get(1765);
/* 5905 */     this.glVertexAttribI4iEXT = caps.get(1766);
/* 5906 */     this.glVertexAttribI1uiEXT = caps.get(1767);
/* 5907 */     this.glVertexAttribI2uiEXT = caps.get(1768);
/* 5908 */     this.glVertexAttribI3uiEXT = caps.get(1769);
/* 5909 */     this.glVertexAttribI4uiEXT = caps.get(1770);
/* 5910 */     this.glVertexAttribI1ivEXT = caps.get(1771);
/* 5911 */     this.glVertexAttribI2ivEXT = caps.get(1772);
/* 5912 */     this.glVertexAttribI3ivEXT = caps.get(1773);
/* 5913 */     this.glVertexAttribI4ivEXT = caps.get(1774);
/* 5914 */     this.glVertexAttribI1uivEXT = caps.get(1775);
/* 5915 */     this.glVertexAttribI2uivEXT = caps.get(1776);
/* 5916 */     this.glVertexAttribI3uivEXT = caps.get(1777);
/* 5917 */     this.glVertexAttribI4uivEXT = caps.get(1778);
/* 5918 */     this.glVertexAttribI4bvEXT = caps.get(1779);
/* 5919 */     this.glVertexAttribI4svEXT = caps.get(1780);
/* 5920 */     this.glVertexAttribI4ubvEXT = caps.get(1781);
/* 5921 */     this.glVertexAttribI4usvEXT = caps.get(1782);
/* 5922 */     this.glVertexAttribIPointerEXT = caps.get(1783);
/* 5923 */     this.glGetVertexAttribIivEXT = caps.get(1784);
/* 5924 */     this.glGetVertexAttribIuivEXT = caps.get(1785);
/* 5925 */     this.glGetUniformuivEXT = caps.get(1786);
/* 5926 */     this.glBindFragDataLocationEXT = caps.get(1787);
/* 5927 */     this.glGetFragDataLocationEXT = caps.get(1788);
/* 5928 */     this.glUniform1uiEXT = caps.get(1789);
/* 5929 */     this.glUniform2uiEXT = caps.get(1790);
/* 5930 */     this.glUniform3uiEXT = caps.get(1791);
/* 5931 */     this.glUniform4uiEXT = caps.get(1792);
/* 5932 */     this.glUniform1uivEXT = caps.get(1793);
/* 5933 */     this.glUniform2uivEXT = caps.get(1794);
/* 5934 */     this.glUniform3uivEXT = caps.get(1795);
/* 5935 */     this.glUniform4uivEXT = caps.get(1796);
/* 5936 */     this.glGetUnsignedBytevEXT = caps.get(1797);
/* 5937 */     this.glGetUnsignedBytei_vEXT = caps.get(1798);
/* 5938 */     this.glDeleteMemoryObjectsEXT = caps.get(1799);
/* 5939 */     this.glIsMemoryObjectEXT = caps.get(1800);
/* 5940 */     this.glCreateMemoryObjectsEXT = caps.get(1801);
/* 5941 */     this.glMemoryObjectParameterivEXT = caps.get(1802);
/* 5942 */     this.glGetMemoryObjectParameterivEXT = caps.get(1803);
/* 5943 */     this.glTexStorageMem2DEXT = caps.get(1804);
/* 5944 */     this.glTexStorageMem2DMultisampleEXT = caps.get(1805);
/* 5945 */     this.glTexStorageMem3DEXT = caps.get(1806);
/* 5946 */     this.glTexStorageMem3DMultisampleEXT = caps.get(1807);
/* 5947 */     this.glBufferStorageMemEXT = caps.get(1808);
/* 5948 */     this.glTextureStorageMem2DEXT = caps.get(1809);
/* 5949 */     this.glTextureStorageMem2DMultisampleEXT = caps.get(1810);
/* 5950 */     this.glTextureStorageMem3DEXT = caps.get(1811);
/* 5951 */     this.glTextureStorageMem3DMultisampleEXT = caps.get(1812);
/* 5952 */     this.glNamedBufferStorageMemEXT = caps.get(1813);
/* 5953 */     this.glTexStorageMem1DEXT = caps.get(1814);
/* 5954 */     this.glTextureStorageMem1DEXT = caps.get(1815);
/* 5955 */     this.glImportMemoryFdEXT = caps.get(1816);
/* 5956 */     this.glImportMemoryWin32HandleEXT = caps.get(1817);
/* 5957 */     this.glImportMemoryWin32NameEXT = caps.get(1818);
/* 5958 */     this.glDrawMeshTasksEXT = caps.get(1819);
/* 5959 */     this.glDrawMeshTasksIndirectEXT = caps.get(1820);
/* 5960 */     this.glMultiDrawMeshTasksIndirectEXT = caps.get(1821);
/* 5961 */     this.glMultiDrawMeshTasksIndirectCountEXT = caps.get(1822);
/* 5962 */     this.glPointParameterfEXT = caps.get(1823);
/* 5963 */     this.glPointParameterfvEXT = caps.get(1824);
/* 5964 */     this.glPolygonOffsetClampEXT = caps.get(1825);
/* 5965 */     this.glProvokingVertexEXT = caps.get(1826);
/* 5966 */     this.glRasterSamplesEXT = caps.get(1827);
/* 5967 */     this.glSecondaryColor3bEXT = caps.get(1828);
/* 5968 */     this.glSecondaryColor3sEXT = caps.get(1829);
/* 5969 */     this.glSecondaryColor3iEXT = caps.get(1830);
/* 5970 */     this.glSecondaryColor3fEXT = caps.get(1831);
/* 5971 */     this.glSecondaryColor3dEXT = caps.get(1832);
/* 5972 */     this.glSecondaryColor3ubEXT = caps.get(1833);
/* 5973 */     this.glSecondaryColor3usEXT = caps.get(1834);
/* 5974 */     this.glSecondaryColor3uiEXT = caps.get(1835);
/* 5975 */     this.glSecondaryColor3bvEXT = caps.get(1836);
/* 5976 */     this.glSecondaryColor3svEXT = caps.get(1837);
/* 5977 */     this.glSecondaryColor3ivEXT = caps.get(1838);
/* 5978 */     this.glSecondaryColor3fvEXT = caps.get(1839);
/* 5979 */     this.glSecondaryColor3dvEXT = caps.get(1840);
/* 5980 */     this.glSecondaryColor3ubvEXT = caps.get(1841);
/* 5981 */     this.glSecondaryColor3usvEXT = caps.get(1842);
/* 5982 */     this.glSecondaryColor3uivEXT = caps.get(1843);
/* 5983 */     this.glSecondaryColorPointerEXT = caps.get(1844);
/* 5984 */     this.glGenSemaphoresEXT = caps.get(1845);
/* 5985 */     this.glDeleteSemaphoresEXT = caps.get(1846);
/* 5986 */     this.glIsSemaphoreEXT = caps.get(1847);
/* 5987 */     this.glSemaphoreParameterui64vEXT = caps.get(1848);
/* 5988 */     this.glGetSemaphoreParameterui64vEXT = caps.get(1849);
/* 5989 */     this.glWaitSemaphoreEXT = caps.get(1850);
/* 5990 */     this.glSignalSemaphoreEXT = caps.get(1851);
/* 5991 */     this.glImportSemaphoreFdEXT = caps.get(1852);
/* 5992 */     this.glImportSemaphoreWin32HandleEXT = caps.get(1853);
/* 5993 */     this.glImportSemaphoreWin32NameEXT = caps.get(1854);
/* 5994 */     this.glUseShaderProgramEXT = caps.get(1855);
/* 5995 */     this.glActiveProgramEXT = caps.get(1856);
/* 5996 */     this.glCreateShaderProgramEXT = caps.get(1857);
/* 5997 */     this.glFramebufferFetchBarrierEXT = caps.get(1858);
/* 5998 */     this.glBindImageTextureEXT = caps.get(1859);
/* 5999 */     this.glMemoryBarrierEXT = caps.get(1860);
/* 6000 */     this.glStencilClearTagEXT = caps.get(1861);
/* 6001 */     this.glActiveStencilFaceEXT = caps.get(1862);
/* 6002 */     this.glTexBufferEXT = caps.get(1863);
/* 6003 */     this.glClearColorIiEXT = caps.get(1864);
/* 6004 */     this.glClearColorIuiEXT = caps.get(1865);
/* 6005 */     this.glTexParameterIivEXT = caps.get(1866);
/* 6006 */     this.glTexParameterIuivEXT = caps.get(1867);
/* 6007 */     this.glGetTexParameterIivEXT = caps.get(1868);
/* 6008 */     this.glGetTexParameterIuivEXT = caps.get(1869);
/* 6009 */     this.glTexStorage1DEXT = caps.get(1870);
/* 6010 */     this.glTexStorage2DEXT = caps.get(1871);
/* 6011 */     this.glTexStorage3DEXT = caps.get(1872);
/* 6012 */     this.glGetQueryObjecti64vEXT = caps.get(1873);
/* 6013 */     this.glGetQueryObjectui64vEXT = caps.get(1874);
/* 6014 */     this.glBindBufferRangeEXT = caps.get(1875);
/* 6015 */     this.glBindBufferOffsetEXT = caps.get(1876);
/* 6016 */     this.glBindBufferBaseEXT = caps.get(1877);
/* 6017 */     this.glBeginTransformFeedbackEXT = caps.get(1878);
/* 6018 */     this.glEndTransformFeedbackEXT = caps.get(1879);
/* 6019 */     this.glTransformFeedbackVaryingsEXT = caps.get(1880);
/* 6020 */     this.glGetTransformFeedbackVaryingEXT = caps.get(1881);
/* 6021 */     this.glVertexAttribL1dEXT = caps.get(1882);
/* 6022 */     this.glVertexAttribL2dEXT = caps.get(1883);
/* 6023 */     this.glVertexAttribL3dEXT = caps.get(1884);
/* 6024 */     this.glVertexAttribL4dEXT = caps.get(1885);
/* 6025 */     this.glVertexAttribL1dvEXT = caps.get(1886);
/* 6026 */     this.glVertexAttribL2dvEXT = caps.get(1887);
/* 6027 */     this.glVertexAttribL3dvEXT = caps.get(1888);
/* 6028 */     this.glVertexAttribL4dvEXT = caps.get(1889);
/* 6029 */     this.glVertexAttribLPointerEXT = caps.get(1890);
/* 6030 */     this.glGetVertexAttribLdvEXT = caps.get(1891);
/* 6031 */     this.glAcquireKeyedMutexWin32EXT = caps.get(1892);
/* 6032 */     this.glReleaseKeyedMutexWin32EXT = caps.get(1893);
/* 6033 */     this.glWindowRectanglesEXT = caps.get(1894);
/* 6034 */     this.glImportSyncEXT = caps.get(1895);
/* 6035 */     this.glFrameTerminatorGREMEDY = caps.get(1896);
/* 6036 */     this.glStringMarkerGREMEDY = caps.get(1897);
/* 6037 */     this.glApplyFramebufferAttachmentCMAAINTEL = caps.get(1898);
/* 6038 */     this.glSyncTextureINTEL = caps.get(1899);
/* 6039 */     this.glUnmapTexture2DINTEL = caps.get(1900);
/* 6040 */     this.glMapTexture2DINTEL = caps.get(1901);
/* 6041 */     this.glBeginPerfQueryINTEL = caps.get(1902);
/* 6042 */     this.glCreatePerfQueryINTEL = caps.get(1903);
/* 6043 */     this.glDeletePerfQueryINTEL = caps.get(1904);
/* 6044 */     this.glEndPerfQueryINTEL = caps.get(1905);
/* 6045 */     this.glGetFirstPerfQueryIdINTEL = caps.get(1906);
/* 6046 */     this.glGetNextPerfQueryIdINTEL = caps.get(1907);
/* 6047 */     this.glGetPerfCounterInfoINTEL = caps.get(1908);
/* 6048 */     this.glGetPerfQueryDataINTEL = caps.get(1909);
/* 6049 */     this.glGetPerfQueryIdByNameINTEL = caps.get(1910);
/* 6050 */     this.glGetPerfQueryInfoINTEL = caps.get(1911);
/* 6051 */     this.glBlendBarrierKHR = caps.get(1912);
/* 6052 */     this.glMaxShaderCompilerThreadsKHR = caps.get(1913);
/* 6053 */     this.glFramebufferParameteriMESA = caps.get(1914);
/* 6054 */     this.glGetFramebufferParameterivMESA = caps.get(1915);
/* 6055 */     this.glAlphaToCoverageDitherControlNV = caps.get(1916);
/* 6056 */     this.glMultiDrawArraysIndirectBindlessNV = caps.get(1917);
/* 6057 */     this.glMultiDrawElementsIndirectBindlessNV = caps.get(1918);
/* 6058 */     this.glMultiDrawArraysIndirectBindlessCountNV = caps.get(1919);
/* 6059 */     this.glMultiDrawElementsIndirectBindlessCountNV = caps.get(1920);
/* 6060 */     this.glGetTextureHandleNV = caps.get(1921);
/* 6061 */     this.glGetTextureSamplerHandleNV = caps.get(1922);
/* 6062 */     this.glMakeTextureHandleResidentNV = caps.get(1923);
/* 6063 */     this.glMakeTextureHandleNonResidentNV = caps.get(1924);
/* 6064 */     this.glGetImageHandleNV = caps.get(1925);
/* 6065 */     this.glMakeImageHandleResidentNV = caps.get(1926);
/* 6066 */     this.glMakeImageHandleNonResidentNV = caps.get(1927);
/* 6067 */     this.glUniformHandleui64NV = caps.get(1928);
/* 6068 */     this.glUniformHandleui64vNV = caps.get(1929);
/* 6069 */     this.glProgramUniformHandleui64NV = caps.get(1930);
/* 6070 */     this.glProgramUniformHandleui64vNV = caps.get(1931);
/* 6071 */     this.glIsTextureHandleResidentNV = caps.get(1932);
/* 6072 */     this.glIsImageHandleResidentNV = caps.get(1933);
/* 6073 */     this.glBlendParameteriNV = caps.get(1934);
/* 6074 */     this.glBlendBarrierNV = caps.get(1935);
/* 6075 */     this.glViewportPositionWScaleNV = caps.get(1936);
/* 6076 */     this.glCreateStatesNV = caps.get(1937);
/* 6077 */     this.glDeleteStatesNV = caps.get(1938);
/* 6078 */     this.glIsStateNV = caps.get(1939);
/* 6079 */     this.glStateCaptureNV = caps.get(1940);
/* 6080 */     this.glGetCommandHeaderNV = caps.get(1941);
/* 6081 */     this.glGetStageIndexNV = caps.get(1942);
/* 6082 */     this.glDrawCommandsNV = caps.get(1943);
/* 6083 */     this.glDrawCommandsAddressNV = caps.get(1944);
/* 6084 */     this.glDrawCommandsStatesNV = caps.get(1945);
/* 6085 */     this.glDrawCommandsStatesAddressNV = caps.get(1946);
/* 6086 */     this.glCreateCommandListsNV = caps.get(1947);
/* 6087 */     this.glDeleteCommandListsNV = caps.get(1948);
/* 6088 */     this.glIsCommandListNV = caps.get(1949);
/* 6089 */     this.glListDrawCommandsStatesClientNV = caps.get(1950);
/* 6090 */     this.glCommandListSegmentsNV = caps.get(1951);
/* 6091 */     this.glCompileCommandListNV = caps.get(1952);
/* 6092 */     this.glCallCommandListNV = caps.get(1953);
/* 6093 */     this.glBeginConditionalRenderNV = caps.get(1954);
/* 6094 */     this.glEndConditionalRenderNV = caps.get(1955);
/* 6095 */     this.glSubpixelPrecisionBiasNV = caps.get(1956);
/* 6096 */     this.glConservativeRasterParameterfNV = caps.get(1957);
/* 6097 */     this.glConservativeRasterParameteriNV = caps.get(1958);
/* 6098 */     this.glCopyImageSubDataNV = caps.get(1959);
/* 6099 */     this.glDepthRangedNV = caps.get(1960);
/* 6100 */     this.glClearDepthdNV = caps.get(1961);
/* 6101 */     this.glDepthBoundsdNV = caps.get(1962);
/* 6102 */     this.glDrawTextureNV = caps.get(1963);
/* 6103 */     this.glDrawVkImageNV = caps.get(1964);
/* 6104 */     this.glGetVkProcAddrNV = caps.get(1965);
/* 6105 */     this.glWaitVkSemaphoreNV = caps.get(1966);
/* 6106 */     this.glSignalVkSemaphoreNV = caps.get(1967);
/* 6107 */     this.glSignalVkFenceNV = caps.get(1968);
/* 6108 */     this.glGetMultisamplefvNV = caps.get(1969);
/* 6109 */     this.glSampleMaskIndexedNV = caps.get(1970);
/* 6110 */     this.glTexRenderbufferNV = caps.get(1971);
/* 6111 */     this.glDeleteFencesNV = caps.get(1972);
/* 6112 */     this.glGenFencesNV = caps.get(1973);
/* 6113 */     this.glIsFenceNV = caps.get(1974);
/* 6114 */     this.glTestFenceNV = caps.get(1975);
/* 6115 */     this.glGetFenceivNV = caps.get(1976);
/* 6116 */     this.glFinishFenceNV = caps.get(1977);
/* 6117 */     this.glSetFenceNV = caps.get(1978);
/* 6118 */     this.glFragmentCoverageColorNV = caps.get(1979);
/* 6119 */     this.glCoverageModulationTableNV = caps.get(1980);
/* 6120 */     this.glGetCoverageModulationTableNV = caps.get(1981);
/* 6121 */     this.glCoverageModulationNV = caps.get(1982);
/* 6122 */     this.glRenderbufferStorageMultisampleCoverageNV = caps.get(1983);
/* 6123 */     this.glRenderGpuMaskNV = caps.get(1984);
/* 6124 */     this.glMulticastBufferSubDataNV = caps.get(1985);
/* 6125 */     this.glMulticastCopyBufferSubDataNV = caps.get(1986);
/* 6126 */     this.glMulticastCopyImageSubDataNV = caps.get(1987);
/* 6127 */     this.glMulticastBlitFramebufferNV = caps.get(1988);
/* 6128 */     this.glMulticastFramebufferSampleLocationsfvNV = caps.get(1989);
/* 6129 */     this.glMulticastBarrierNV = caps.get(1990);
/* 6130 */     this.glMulticastWaitSyncNV = caps.get(1991);
/* 6131 */     this.glMulticastGetQueryObjectivNV = caps.get(1992);
/* 6132 */     this.glMulticastGetQueryObjectuivNV = caps.get(1993);
/* 6133 */     this.glMulticastGetQueryObjecti64vNV = caps.get(1994);
/* 6134 */     this.glMulticastGetQueryObjectui64vNV = caps.get(1995);
/* 6135 */     this.glVertex2hNV = caps.get(1996);
/* 6136 */     this.glVertex2hvNV = caps.get(1997);
/* 6137 */     this.glVertex3hNV = caps.get(1998);
/* 6138 */     this.glVertex3hvNV = caps.get(1999);
/* 6139 */     this.glVertex4hNV = caps.get(2000);
/* 6140 */     this.glVertex4hvNV = caps.get(2001);
/* 6141 */     this.glNormal3hNV = caps.get(2002);
/* 6142 */     this.glNormal3hvNV = caps.get(2003);
/* 6143 */     this.glColor3hNV = caps.get(2004);
/* 6144 */     this.glColor3hvNV = caps.get(2005);
/* 6145 */     this.glColor4hNV = caps.get(2006);
/* 6146 */     this.glColor4hvNV = caps.get(2007);
/* 6147 */     this.glTexCoord1hNV = caps.get(2008);
/* 6148 */     this.glTexCoord1hvNV = caps.get(2009);
/* 6149 */     this.glTexCoord2hNV = caps.get(2010);
/* 6150 */     this.glTexCoord2hvNV = caps.get(2011);
/* 6151 */     this.glTexCoord3hNV = caps.get(2012);
/* 6152 */     this.glTexCoord3hvNV = caps.get(2013);
/* 6153 */     this.glTexCoord4hNV = caps.get(2014);
/* 6154 */     this.glTexCoord4hvNV = caps.get(2015);
/* 6155 */     this.glMultiTexCoord1hNV = caps.get(2016);
/* 6156 */     this.glMultiTexCoord1hvNV = caps.get(2017);
/* 6157 */     this.glMultiTexCoord2hNV = caps.get(2018);
/* 6158 */     this.glMultiTexCoord2hvNV = caps.get(2019);
/* 6159 */     this.glMultiTexCoord3hNV = caps.get(2020);
/* 6160 */     this.glMultiTexCoord3hvNV = caps.get(2021);
/* 6161 */     this.glMultiTexCoord4hNV = caps.get(2022);
/* 6162 */     this.glMultiTexCoord4hvNV = caps.get(2023);
/* 6163 */     this.glFogCoordhNV = caps.get(2024);
/* 6164 */     this.glFogCoordhvNV = caps.get(2025);
/* 6165 */     this.glSecondaryColor3hNV = caps.get(2026);
/* 6166 */     this.glSecondaryColor3hvNV = caps.get(2027);
/* 6167 */     this.glVertexWeighthNV = caps.get(2028);
/* 6168 */     this.glVertexWeighthvNV = caps.get(2029);
/* 6169 */     this.glVertexAttrib1hNV = caps.get(2030);
/* 6170 */     this.glVertexAttrib1hvNV = caps.get(2031);
/* 6171 */     this.glVertexAttrib2hNV = caps.get(2032);
/* 6172 */     this.glVertexAttrib2hvNV = caps.get(2033);
/* 6173 */     this.glVertexAttrib3hNV = caps.get(2034);
/* 6174 */     this.glVertexAttrib3hvNV = caps.get(2035);
/* 6175 */     this.glVertexAttrib4hNV = caps.get(2036);
/* 6176 */     this.glVertexAttrib4hvNV = caps.get(2037);
/* 6177 */     this.glVertexAttribs1hvNV = caps.get(2038);
/* 6178 */     this.glVertexAttribs2hvNV = caps.get(2039);
/* 6179 */     this.glVertexAttribs3hvNV = caps.get(2040);
/* 6180 */     this.glVertexAttribs4hvNV = caps.get(2041);
/* 6181 */     this.glGetInternalformatSampleivNV = caps.get(2042);
/* 6182 */     this.glGetMemoryObjectDetachedResourcesuivNV = caps.get(2043);
/* 6183 */     this.glResetMemoryObjectParameterNV = caps.get(2044);
/* 6184 */     this.glTexAttachMemoryNV = caps.get(2045);
/* 6185 */     this.glBufferAttachMemoryNV = caps.get(2046);
/* 6186 */     this.glTextureAttachMemoryNV = caps.get(2047);
/* 6187 */     this.glNamedBufferAttachMemoryNV = caps.get(2048);
/* 6188 */     this.glBufferPageCommitmentMemNV = caps.get(2049);
/* 6189 */     this.glNamedBufferPageCommitmentMemNV = caps.get(2050);
/* 6190 */     this.glTexPageCommitmentMemNV = caps.get(2051);
/* 6191 */     this.glTexturePageCommitmentMemNV = caps.get(2052);
/* 6192 */     this.glDrawMeshTasksNV = caps.get(2053);
/* 6193 */     this.glDrawMeshTasksIndirectNV = caps.get(2054);
/* 6194 */     this.glMultiDrawMeshTasksIndirectNV = caps.get(2055);
/* 6195 */     this.glMultiDrawMeshTasksIndirectCountNV = caps.get(2056);
/* 6196 */     this.glPathCommandsNV = caps.get(2057);
/* 6197 */     this.glPathCoordsNV = caps.get(2058);
/* 6198 */     this.glPathSubCommandsNV = caps.get(2059);
/* 6199 */     this.glPathSubCoordsNV = caps.get(2060);
/* 6200 */     this.glPathStringNV = caps.get(2061);
/* 6201 */     this.glPathGlyphsNV = caps.get(2062);
/* 6202 */     this.glPathGlyphRangeNV = caps.get(2063);
/* 6203 */     this.glPathGlyphIndexArrayNV = caps.get(2064);
/* 6204 */     this.glPathMemoryGlyphIndexArrayNV = caps.get(2065);
/* 6205 */     this.glCopyPathNV = caps.get(2066);
/* 6206 */     this.glWeightPathsNV = caps.get(2067);
/* 6207 */     this.glInterpolatePathsNV = caps.get(2068);
/* 6208 */     this.glTransformPathNV = caps.get(2069);
/* 6209 */     this.glPathParameterivNV = caps.get(2070);
/* 6210 */     this.glPathParameteriNV = caps.get(2071);
/* 6211 */     this.glPathParameterfvNV = caps.get(2072);
/* 6212 */     this.glPathParameterfNV = caps.get(2073);
/* 6213 */     this.glPathDashArrayNV = caps.get(2074);
/* 6214 */     this.glGenPathsNV = caps.get(2075);
/* 6215 */     this.glDeletePathsNV = caps.get(2076);
/* 6216 */     this.glIsPathNV = caps.get(2077);
/* 6217 */     this.glPathStencilFuncNV = caps.get(2078);
/* 6218 */     this.glPathStencilDepthOffsetNV = caps.get(2079);
/* 6219 */     this.glStencilFillPathNV = caps.get(2080);
/* 6220 */     this.glStencilStrokePathNV = caps.get(2081);
/* 6221 */     this.glStencilFillPathInstancedNV = caps.get(2082);
/* 6222 */     this.glStencilStrokePathInstancedNV = caps.get(2083);
/* 6223 */     this.glPathCoverDepthFuncNV = caps.get(2084);
/* 6224 */     this.glPathColorGenNV = caps.get(2085);
/* 6225 */     this.glPathTexGenNV = caps.get(2086);
/* 6226 */     this.glPathFogGenNV = caps.get(2087);
/* 6227 */     this.glCoverFillPathNV = caps.get(2088);
/* 6228 */     this.glCoverStrokePathNV = caps.get(2089);
/* 6229 */     this.glCoverFillPathInstancedNV = caps.get(2090);
/* 6230 */     this.glCoverStrokePathInstancedNV = caps.get(2091);
/* 6231 */     this.glStencilThenCoverFillPathNV = caps.get(2092);
/* 6232 */     this.glStencilThenCoverStrokePathNV = caps.get(2093);
/* 6233 */     this.glStencilThenCoverFillPathInstancedNV = caps.get(2094);
/* 6234 */     this.glStencilThenCoverStrokePathInstancedNV = caps.get(2095);
/* 6235 */     this.glPathGlyphIndexRangeNV = caps.get(2096);
/* 6236 */     this.glProgramPathFragmentInputGenNV = caps.get(2097);
/* 6237 */     this.glGetPathParameterivNV = caps.get(2098);
/* 6238 */     this.glGetPathParameterfvNV = caps.get(2099);
/* 6239 */     this.glGetPathCommandsNV = caps.get(2100);
/* 6240 */     this.glGetPathCoordsNV = caps.get(2101);
/* 6241 */     this.glGetPathDashArrayNV = caps.get(2102);
/* 6242 */     this.glGetPathMetricsNV = caps.get(2103);
/* 6243 */     this.glGetPathMetricRangeNV = caps.get(2104);
/* 6244 */     this.glGetPathSpacingNV = caps.get(2105);
/* 6245 */     this.glGetPathColorGenivNV = caps.get(2106);
/* 6246 */     this.glGetPathColorGenfvNV = caps.get(2107);
/* 6247 */     this.glGetPathTexGenivNV = caps.get(2108);
/* 6248 */     this.glGetPathTexGenfvNV = caps.get(2109);
/* 6249 */     this.glIsPointInFillPathNV = caps.get(2110);
/* 6250 */     this.glIsPointInStrokePathNV = caps.get(2111);
/* 6251 */     this.glGetPathLengthNV = caps.get(2112);
/* 6252 */     this.glPointAlongPathNV = caps.get(2113);
/* 6253 */     this.glMatrixLoad3x2fNV = caps.get(2114);
/* 6254 */     this.glMatrixLoad3x3fNV = caps.get(2115);
/* 6255 */     this.glMatrixLoadTranspose3x3fNV = caps.get(2116);
/* 6256 */     this.glMatrixMult3x2fNV = caps.get(2117);
/* 6257 */     this.glMatrixMult3x3fNV = caps.get(2118);
/* 6258 */     this.glMatrixMultTranspose3x3fNV = caps.get(2119);
/* 6259 */     this.glGetProgramResourcefvNV = caps.get(2120);
/* 6260 */     this.glPixelDataRangeNV = caps.get(2121);
/* 6261 */     this.glFlushPixelDataRangeNV = caps.get(2122);
/* 6262 */     this.glPointParameteriNV = caps.get(2123);
/* 6263 */     this.glPointParameterivNV = caps.get(2124);
/* 6264 */     this.glPrimitiveRestartNV = caps.get(2125);
/* 6265 */     this.glPrimitiveRestartIndexNV = caps.get(2126);
/* 6266 */     this.glQueryResourceNV = caps.get(2127);
/* 6267 */     this.glGenQueryResourceTagNV = caps.get(2128);
/* 6268 */     this.glDeleteQueryResourceTagNV = caps.get(2129);
/* 6269 */     this.glQueryResourceTagNV = caps.get(2130);
/* 6270 */     this.glFramebufferSampleLocationsfvNV = caps.get(2131);
/* 6271 */     this.glNamedFramebufferSampleLocationsfvNV = caps.get(2132);
/* 6272 */     this.glResolveDepthValuesNV = caps.get(2133);
/* 6273 */     this.glScissorExclusiveArrayvNV = caps.get(2134);
/* 6274 */     this.glScissorExclusiveNV = caps.get(2135);
/* 6275 */     this.glMakeBufferResidentNV = caps.get(2136);
/* 6276 */     this.glMakeBufferNonResidentNV = caps.get(2137);
/* 6277 */     this.glIsBufferResidentNV = caps.get(2138);
/* 6278 */     this.glMakeNamedBufferResidentNV = caps.get(2139);
/* 6279 */     this.glMakeNamedBufferNonResidentNV = caps.get(2140);
/* 6280 */     this.glIsNamedBufferResidentNV = caps.get(2141);
/* 6281 */     this.glGetBufferParameterui64vNV = caps.get(2142);
/* 6282 */     this.glGetNamedBufferParameterui64vNV = caps.get(2143);
/* 6283 */     this.glGetIntegerui64vNV = caps.get(2144);
/* 6284 */     this.glUniformui64NV = caps.get(2145);
/* 6285 */     this.glUniformui64vNV = caps.get(2146);
/* 6286 */     this.glProgramUniformui64NV = caps.get(2147);
/* 6287 */     this.glProgramUniformui64vNV = caps.get(2148);
/* 6288 */     this.glBindShadingRateImageNV = caps.get(2149);
/* 6289 */     this.glShadingRateImagePaletteNV = caps.get(2150);
/* 6290 */     this.glGetShadingRateImagePaletteNV = caps.get(2151);
/* 6291 */     this.glShadingRateImageBarrierNV = caps.get(2152);
/* 6292 */     this.glShadingRateSampleOrderNV = caps.get(2153);
/* 6293 */     this.glShadingRateSampleOrderCustomNV = caps.get(2154);
/* 6294 */     this.glGetShadingRateSampleLocationivNV = caps.get(2155);
/* 6295 */     this.glTextureBarrierNV = caps.get(2156);
/* 6296 */     this.glTexImage2DMultisampleCoverageNV = caps.get(2157);
/* 6297 */     this.glTexImage3DMultisampleCoverageNV = caps.get(2158);
/* 6298 */     this.glTextureImage2DMultisampleNV = caps.get(2159);
/* 6299 */     this.glTextureImage3DMultisampleNV = caps.get(2160);
/* 6300 */     this.glTextureImage2DMultisampleCoverageNV = caps.get(2161);
/* 6301 */     this.glTextureImage3DMultisampleCoverageNV = caps.get(2162);
/* 6302 */     this.glCreateSemaphoresNV = caps.get(2163);
/* 6303 */     this.glSemaphoreParameterivNV = caps.get(2164);
/* 6304 */     this.glGetSemaphoreParameterivNV = caps.get(2165);
/* 6305 */     this.glBeginTransformFeedbackNV = caps.get(2166);
/* 6306 */     this.glEndTransformFeedbackNV = caps.get(2167);
/* 6307 */     this.glTransformFeedbackAttribsNV = caps.get(2168);
/* 6308 */     this.glBindBufferRangeNV = caps.get(2169);
/* 6309 */     this.glBindBufferOffsetNV = caps.get(2170);
/* 6310 */     this.glBindBufferBaseNV = caps.get(2171);
/* 6311 */     this.glTransformFeedbackVaryingsNV = caps.get(2172);
/* 6312 */     this.glActiveVaryingNV = caps.get(2173);
/* 6313 */     this.glGetVaryingLocationNV = caps.get(2174);
/* 6314 */     this.glGetActiveVaryingNV = caps.get(2175);
/* 6315 */     this.glGetTransformFeedbackVaryingNV = caps.get(2176);
/* 6316 */     this.glTransformFeedbackStreamAttribsNV = caps.get(2177);
/* 6317 */     this.glBindTransformFeedbackNV = caps.get(2178);
/* 6318 */     this.glDeleteTransformFeedbacksNV = caps.get(2179);
/* 6319 */     this.glGenTransformFeedbacksNV = caps.get(2180);
/* 6320 */     this.glIsTransformFeedbackNV = caps.get(2181);
/* 6321 */     this.glPauseTransformFeedbackNV = caps.get(2182);
/* 6322 */     this.glResumeTransformFeedbackNV = caps.get(2183);
/* 6323 */     this.glDrawTransformFeedbackNV = caps.get(2184);
/* 6324 */     this.glVertexArrayRangeNV = caps.get(2185);
/* 6325 */     this.glFlushVertexArrayRangeNV = caps.get(2186);
/* 6326 */     this.glVertexAttribL1i64NV = caps.get(2187);
/* 6327 */     this.glVertexAttribL2i64NV = caps.get(2188);
/* 6328 */     this.glVertexAttribL3i64NV = caps.get(2189);
/* 6329 */     this.glVertexAttribL4i64NV = caps.get(2190);
/* 6330 */     this.glVertexAttribL1i64vNV = caps.get(2191);
/* 6331 */     this.glVertexAttribL2i64vNV = caps.get(2192);
/* 6332 */     this.glVertexAttribL3i64vNV = caps.get(2193);
/* 6333 */     this.glVertexAttribL4i64vNV = caps.get(2194);
/* 6334 */     this.glVertexAttribL1ui64NV = caps.get(2195);
/* 6335 */     this.glVertexAttribL2ui64NV = caps.get(2196);
/* 6336 */     this.glVertexAttribL3ui64NV = caps.get(2197);
/* 6337 */     this.glVertexAttribL4ui64NV = caps.get(2198);
/* 6338 */     this.glVertexAttribL1ui64vNV = caps.get(2199);
/* 6339 */     this.glVertexAttribL2ui64vNV = caps.get(2200);
/* 6340 */     this.glVertexAttribL3ui64vNV = caps.get(2201);
/* 6341 */     this.glVertexAttribL4ui64vNV = caps.get(2202);
/* 6342 */     this.glGetVertexAttribLi64vNV = caps.get(2203);
/* 6343 */     this.glGetVertexAttribLui64vNV = caps.get(2204);
/* 6344 */     this.glVertexAttribLFormatNV = caps.get(2205);
/* 6345 */     this.glBufferAddressRangeNV = caps.get(2206);
/* 6346 */     this.glVertexFormatNV = caps.get(2207);
/* 6347 */     this.glNormalFormatNV = caps.get(2208);
/* 6348 */     this.glColorFormatNV = caps.get(2209);
/* 6349 */     this.glIndexFormatNV = caps.get(2210);
/* 6350 */     this.glTexCoordFormatNV = caps.get(2211);
/* 6351 */     this.glEdgeFlagFormatNV = caps.get(2212);
/* 6352 */     this.glSecondaryColorFormatNV = caps.get(2213);
/* 6353 */     this.glFogCoordFormatNV = caps.get(2214);
/* 6354 */     this.glVertexAttribFormatNV = caps.get(2215);
/* 6355 */     this.glVertexAttribIFormatNV = caps.get(2216);
/* 6356 */     this.glGetIntegerui64i_vNV = caps.get(2217);
/* 6357 */     this.glViewportSwizzleNV = caps.get(2218);
/* 6358 */     this.glBeginConditionalRenderNVX = caps.get(2219);
/* 6359 */     this.glEndConditionalRenderNVX = caps.get(2220);
/* 6360 */     this.glAsyncCopyImageSubDataNVX = caps.get(2221);
/* 6361 */     this.glAsyncCopyBufferSubDataNVX = caps.get(2222);
/* 6362 */     this.glUploadGpuMaskNVX = caps.get(2223);
/* 6363 */     this.glMulticastViewportArrayvNVX = caps.get(2224);
/* 6364 */     this.glMulticastScissorArrayvNVX = caps.get(2225);
/* 6365 */     this.glMulticastViewportPositionWScaleNVX = caps.get(2226);
/* 6366 */     this.glCreateProgressFenceNVX = caps.get(2227);
/* 6367 */     this.glSignalSemaphoreui64NVX = caps.get(2228);
/* 6368 */     this.glWaitSemaphoreui64NVX = caps.get(2229);
/* 6369 */     this.glClientWaitSemaphoreui64NVX = caps.get(2230);
/* 6370 */     this.glFramebufferTextureMultiviewOVR = caps.get(2231);
/* 6371 */     this.glNamedFramebufferTextureMultiviewOVR = caps.get(2232);
/*      */     
/* 6373 */     this.addresses = ThreadLocalUtil.setupAddressBuffer(caps);
/*      */   }
/*      */ 
/*      */   
/*      */   public PointerBuffer getAddressBuffer() {
/* 6378 */     return this.addresses;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void initialize() {}
/*      */ 
/*      */   
/*      */   private static boolean check_GL11(FunctionProvider provider, PointerBuffer caps, Set<String> ext, boolean fc) {
/* 6387 */     if (!ext.contains("OpenGL11")) {
/* 6388 */       return false;
/*      */     }
/*      */     
/* 6391 */     int flag0 = (!fc || ext.contains("GL_NV_vertex_buffer_unified_memory")) ? 0 : Integer.MIN_VALUE;
/*      */     
/* 6393 */     return (((fc || Checks.checkFunctions(provider, caps, new int[] { 2, 3, 4, 5, 6, 8, 10, 11, 13, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 52, 53, 54, 56, 64, 65, 66, 67, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 85, 86, 87, 88, 90, 93, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 110, 112, 113, 114, 115, 116, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 138, 140, 141, 142, 143, 144, 145, 146, 147, 148, 150, 151, 152, 153, 154, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 192, 193, 194, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 248, 249, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334 }, new String[] { "glAccum", "glAlphaFunc", "glAreTexturesResident", "glArrayElement", "glBegin", "glBitmap", "glCallList", "glCallLists", "glClearAccum", "glClearIndex", "glClipPlane", "glColor3b", "glColor3s", "glColor3i", "glColor3f", "glColor3d", "glColor3ub", "glColor3us", "glColor3ui", "glColor3bv", "glColor3sv", "glColor3iv", "glColor3fv", "glColor3dv", "glColor3ubv", "glColor3usv", "glColor3uiv", "glColor4b", "glColor4s", "glColor4i", "glColor4f", "glColor4d", "glColor4ub", "glColor4us", "glColor4ui", "glColor4bv", "glColor4sv", "glColor4iv", "glColor4fv", "glColor4dv", "glColor4ubv", "glColor4usv", "glColor4uiv", "glColorMaterial", "glColorPointer", "glCopyPixels", "glDeleteLists", "glDrawPixels", "glEdgeFlag", "glEdgeFlagv", "glEdgeFlagPointer", "glEnd", "glEvalCoord1f", "glEvalCoord1fv", "glEvalCoord1d", "glEvalCoord1dv", "glEvalCoord2f", "glEvalCoord2fv", "glEvalCoord2d", "glEvalCoord2dv", "glEvalMesh1", "glEvalMesh2", "glEvalPoint1", "glEvalPoint2", "glFeedbackBuffer", "glFogi", "glFogiv", "glFogf", "glFogfv", "glGenLists", "glGetClipPlane", "glGetLightiv", "glGetLightfv", "glGetMapiv", "glGetMapfv", "glGetMapdv", "glGetMaterialiv", "glGetMaterialfv", "glGetPixelMapfv", "glGetPixelMapusv", "glGetPixelMapuiv", "glGetPolygonStipple", "glGetTexEnviv", "glGetTexEnvfv", "glGetTexGeniv", "glGetTexGenfv", "glGetTexGendv", "glIndexi", "glIndexub", "glIndexs", "glIndexf", "glIndexd", "glIndexiv", "glIndexubv", "glIndexsv", "glIndexfv", "glIndexdv", "glIndexMask", "glIndexPointer", "glInitNames", "glInterleavedArrays", "glIsList", "glLightModeli", "glLightModelf", "glLightModeliv", "glLightModelfv", "glLighti", "glLightf", "glLightiv", "glLightfv", "glLineStipple", "glListBase", "glLoadMatrixf", "glLoadMatrixd", "glLoadIdentity", "glLoadName", "glMap1f", "glMap1d", "glMap2f", "glMap2d", "glMapGrid1f", "glMapGrid1d", "glMapGrid2f", "glMapGrid2d", "glMateriali", "glMaterialf", "glMaterialiv", "glMaterialfv", "glMatrixMode", "glMultMatrixf", "glMultMatrixd", "glFrustum", "glNewList", "glEndList", "glNormal3f", "glNormal3b", "glNormal3s", "glNormal3i", "glNormal3d", "glNormal3fv", "glNormal3bv", "glNormal3sv", "glNormal3iv", "glNormal3dv", "glNormalPointer", "glOrtho", "glPassThrough", "glPixelMapfv", "glPixelMapusv", "glPixelMapuiv", "glPixelTransferi", "glPixelTransferf", "glPixelZoom", "glPolygonStipple", "glPushAttrib", "glPushClientAttrib", "glPopAttrib", "glPopClientAttrib", "glPopMatrix", "glPopName", "glPrioritizeTextures", "glPushMatrix", "glPushName", "glRasterPos2i", "glRasterPos2s", "glRasterPos2f", "glRasterPos2d", "glRasterPos2iv", "glRasterPos2sv", "glRasterPos2fv", "glRasterPos2dv", "glRasterPos3i", "glRasterPos3s", "glRasterPos3f", "glRasterPos3d", "glRasterPos3iv", "glRasterPos3sv", "glRasterPos3fv", "glRasterPos3dv", "glRasterPos4i", "glRasterPos4s", "glRasterPos4f", "glRasterPos4d", "glRasterPos4iv", "glRasterPos4sv", "glRasterPos4fv", "glRasterPos4dv", "glRecti", "glRects", "glRectf", "glRectd", "glRectiv", "glRectsv", "glRectfv", "glRectdv", "glRenderMode", "glRotatef", "glRotated", "glScalef", "glScaled", "glSelectBuffer", "glShadeModel", "glTexCoord1f", "glTexCoord1s", "glTexCoord1i", "glTexCoord1d", "glTexCoord1fv", "glTexCoord1sv", "glTexCoord1iv", "glTexCoord1dv", "glTexCoord2f", "glTexCoord2s", "glTexCoord2i", "glTexCoord2d", "glTexCoord2fv", "glTexCoord2sv", "glTexCoord2iv", "glTexCoord2dv", "glTexCoord3f", "glTexCoord3s", "glTexCoord3i", "glTexCoord3d", "glTexCoord3fv", "glTexCoord3sv", "glTexCoord3iv", "glTexCoord3dv", "glTexCoord4f", "glTexCoord4s", "glTexCoord4i", "glTexCoord4d", "glTexCoord4fv", "glTexCoord4sv", "glTexCoord4iv", "glTexCoord4dv", "glTexCoordPointer", "glTexEnvi", "glTexEnviv", "glTexEnvf", "glTexEnvfv", "glTexGeni", "glTexGeniv", "glTexGenf", "glTexGenfv", "glTexGend", "glTexGendv", "glTranslatef", "glTranslated", "glVertex2f", "glVertex2s", "glVertex2i", "glVertex2d", "glVertex2fv", "glVertex2sv", "glVertex2iv", "glVertex2dv", "glVertex3f", "glVertex3s", "glVertex3i", "glVertex3d", "glVertex3fv", "glVertex3sv", "glVertex3iv", "glVertex3dv", "glVertex4f", "glVertex4s", "glVertex4i", "glVertex4d", "glVertex4fv", "glVertex4sv", "glVertex4iv", "glVertex4dv", "glVertexPointer"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6434 */         })) && Checks.checkFunctions(provider, caps, new int[] { 0, 1, 7, 9, 12, 14, 15, 17, 51, 55, 
/*      */           57, 58, 59, flag0 + 60, 61, 62, 63, flag0 + 68, 83, 84, 
/*      */           89, 91, 92, 94, 95, 96, 97, 98, 109, 111, 
/*      */           117, 118, 119, 120, 121, 122, 137, 139, 149, 155, 
/*      */           190, 191, 195, 196, 197, 232, 233, 247, 250, 251, 
/*      */           252, 296, 297, 298, 299, 300, 301, 302, 303, 304, 
/*      */           305, 306, 307, 335 }, new String[] { 
/*      */           "glEnable", "glDisable", "glBindTexture", "glBlendFunc", "glClear", "glClearColor", "glClearDepth", "glClearStencil", "glColorMask", "glCullFace", 
/*      */           "glDepthFunc", "glDepthMask", "glDepthRange", "glDisableClientState", "glDrawArrays", "glDrawBuffer", "glDrawElements", "glEnableClientState", "glFinish", "glFlush", 
/*      */           "glFrontFace", "glGenTextures", "glDeleteTextures", "glGetBooleanv", "glGetFloatv", "glGetIntegerv", "glGetDoublev", "glGetError", "glGetPointerv", "glGetString", 
/*      */           "glGetTexImage", "glGetTexLevelParameteriv", "glGetTexLevelParameterfv", "glGetTexParameteriv", "glGetTexParameterfv", "glHint", "glIsEnabled", "glIsTexture", "glLineWidth", "glLogicOp", 
/*      */           "glPixelStorei", "glPixelStoref", "glPointSize", "glPolygonMode", "glPolygonOffset", "glReadBuffer", "glReadPixels", "glScissor", "glStencilFunc", "glStencilMask", 
/*      */           "glStencilOp", "glTexImage1D", "glTexImage2D", "glCopyTexImage1D", "glCopyTexImage2D", "glCopyTexSubImage1D", "glCopyTexSubImage2D", "glTexParameteri", "glTexParameteriv", "glTexParameterf", 
/* 6447 */           "glTexParameterfv", "glTexSubImage1D", "glTexSubImage2D", "glViewport" })) || Checks.reportMissing("GL", "OpenGL11"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL12(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6451 */     if (!ext.contains("OpenGL12")) {
/* 6452 */       return false;
/*      */     }
/*      */     
/* 6455 */     return (Checks.checkFunctions(provider, caps, new int[] { 336, 337, 338, 339 }, new String[] { "glTexImage3D", "glTexSubImage3D", "glCopyTexSubImage3D", "glDrawRangeElements"
/*      */ 
/*      */ 
/*      */         
/* 6459 */         }) || Checks.reportMissing("GL", "OpenGL12"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL13(FunctionProvider provider, PointerBuffer caps, Set<String> ext, boolean fc) {
/* 6463 */     if (!ext.contains("OpenGL13")) {
/* 6464 */       return false;
/*      */     }
/*      */     
/* 6467 */     return (((fc || Checks.checkFunctions(provider, caps, new int[] { 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385 }, new String[] { "glClientActiveTexture", "glMultiTexCoord1f", "glMultiTexCoord1s", "glMultiTexCoord1i", "glMultiTexCoord1d", "glMultiTexCoord1fv", "glMultiTexCoord1sv", "glMultiTexCoord1iv", "glMultiTexCoord1dv", "glMultiTexCoord2f", "glMultiTexCoord2s", "glMultiTexCoord2i", "glMultiTexCoord2d", "glMultiTexCoord2fv", "glMultiTexCoord2sv", "glMultiTexCoord2iv", "glMultiTexCoord2dv", "glMultiTexCoord3f", "glMultiTexCoord3s", "glMultiTexCoord3i", "glMultiTexCoord3d", "glMultiTexCoord3fv", "glMultiTexCoord3sv", "glMultiTexCoord3iv", "glMultiTexCoord3dv", "glMultiTexCoord4f", "glMultiTexCoord4s", "glMultiTexCoord4i", "glMultiTexCoord4d", "glMultiTexCoord4fv", "glMultiTexCoord4sv", "glMultiTexCoord4iv", "glMultiTexCoord4dv", "glLoadTransposeMatrixf", "glLoadTransposeMatrixd", "glMultTransposeMatrixf", "glMultTransposeMatrixd"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6478 */         })) && Checks.checkFunctions(provider, caps, new int[] {
/*      */           340, 341, 342, 343, 344, 345, 346, 347, 348 }, new String[] {
/*      */           
/*      */           "glCompressedTexImage3D", "glCompressedTexImage2D", "glCompressedTexImage1D", "glCompressedTexSubImage3D", "glCompressedTexSubImage2D", "glCompressedTexSubImage1D", "glGetCompressedTexImage", "glSampleCoverage", "glActiveTexture"
/*      */         
/* 6483 */         })) || Checks.reportMissing("GL", "OpenGL13"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL14(FunctionProvider provider, PointerBuffer caps, Set<String> ext, boolean fc) {
/* 6487 */     if (!ext.contains("OpenGL14")) {
/* 6488 */       return false;
/*      */     }
/*      */     
/* 6491 */     return (((fc || Checks.checkFunctions(provider, caps, new int[] { 388, 389, 390, 391, 392, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432 }, new String[] { "glFogCoordf", "glFogCoordd", "glFogCoordfv", "glFogCoorddv", "glFogCoordPointer", "glSecondaryColor3b", "glSecondaryColor3s", "glSecondaryColor3i", "glSecondaryColor3f", "glSecondaryColor3d", "glSecondaryColor3ub", "glSecondaryColor3us", "glSecondaryColor3ui", "glSecondaryColor3bv", "glSecondaryColor3sv", "glSecondaryColor3iv", "glSecondaryColor3fv", "glSecondaryColor3dv", "glSecondaryColor3ubv", "glSecondaryColor3usv", "glSecondaryColor3uiv", "glSecondaryColorPointer", "glWindowPos2i", "glWindowPos2s", "glWindowPos2f", "glWindowPos2d", "glWindowPos2iv", "glWindowPos2sv", "glWindowPos2fv", "glWindowPos2dv", "glWindowPos3i", "glWindowPos3s", "glWindowPos3f", "glWindowPos3d", "glWindowPos3iv", "glWindowPos3sv", "glWindowPos3fv", "glWindowPos3dv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6501 */         })) && Checks.checkFunctions(provider, caps, new int[] {
/*      */           386, 387, 393, 394, 395, 396, 397, 398, 416 }, new String[] {
/*      */           
/*      */           "glBlendColor", "glBlendEquation", "glMultiDrawArrays", "glMultiDrawElements", "glPointParameterf", "glPointParameteri", "glPointParameterfv", "glPointParameteriv", "glBlendFuncSeparate"
/*      */         
/* 6506 */         })) || Checks.reportMissing("GL", "OpenGL14"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL15(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6510 */     if (!ext.contains("OpenGL15")) {
/* 6511 */       return false;
/*      */     }
/*      */     
/* 6514 */     return (Checks.checkFunctions(provider, caps, new int[] { 433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451 }, new String[] { "glBindBuffer", "glDeleteBuffers", "glGenBuffers", "glIsBuffer", "glBufferData", "glBufferSubData", "glGetBufferSubData", "glMapBuffer", "glUnmapBuffer", "glGetBufferParameteriv", "glGetBufferPointerv", "glGenQueries", "glDeleteQueries", "glIsQuery", "glBeginQuery", "glEndQuery", "glGetQueryiv", "glGetQueryObjectiv", "glGetQueryObjectuiv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6520 */         }) || Checks.reportMissing("GL", "OpenGL15"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL20(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6524 */     if (!ext.contains("OpenGL20")) {
/* 6525 */       return false;
/*      */     }
/*      */     
/* 6528 */     return (Checks.checkFunctions(provider, caps, new int[] { 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544 }, new String[] { "glCreateProgram", "glDeleteProgram", "glIsProgram", "glCreateShader", "glDeleteShader", "glIsShader", "glAttachShader", "glDetachShader", "glShaderSource", "glCompileShader", "glLinkProgram", "glUseProgram", "glValidateProgram", "glUniform1f", "glUniform2f", "glUniform3f", "glUniform4f", "glUniform1i", "glUniform2i", "glUniform3i", "glUniform4i", "glUniform1fv", "glUniform2fv", "glUniform3fv", "glUniform4fv", "glUniform1iv", "glUniform2iv", "glUniform3iv", "glUniform4iv", "glUniformMatrix2fv", "glUniformMatrix3fv", "glUniformMatrix4fv", "glGetShaderiv", "glGetProgramiv", "glGetShaderInfoLog", "glGetProgramInfoLog", "glGetAttachedShaders", "glGetUniformLocation", "glGetActiveUniform", "glGetUniformfv", "glGetUniformiv", "glGetShaderSource", "glVertexAttrib1f", "glVertexAttrib1s", "glVertexAttrib1d", "glVertexAttrib2f", "glVertexAttrib2s", "glVertexAttrib2d", "glVertexAttrib3f", "glVertexAttrib3s", "glVertexAttrib3d", "glVertexAttrib4f", "glVertexAttrib4s", "glVertexAttrib4d", "glVertexAttrib4Nub", "glVertexAttrib1fv", "glVertexAttrib1sv", "glVertexAttrib1dv", "glVertexAttrib2fv", "glVertexAttrib2sv", "glVertexAttrib2dv", "glVertexAttrib3fv", "glVertexAttrib3sv", "glVertexAttrib3dv", "glVertexAttrib4fv", "glVertexAttrib4sv", "glVertexAttrib4dv", "glVertexAttrib4iv", "glVertexAttrib4bv", "glVertexAttrib4ubv", "glVertexAttrib4usv", "glVertexAttrib4uiv", "glVertexAttrib4Nbv", "glVertexAttrib4Nsv", "glVertexAttrib4Niv", "glVertexAttrib4Nubv", "glVertexAttrib4Nusv", "glVertexAttrib4Nuiv", "glVertexAttribPointer", "glEnableVertexAttribArray", "glDisableVertexAttribArray", "glBindAttribLocation", "glGetActiveAttrib", "glGetAttribLocation", "glGetVertexAttribiv", "glGetVertexAttribfv", "glGetVertexAttribdv", "glGetVertexAttribPointerv", "glDrawBuffers", "glBlendEquationSeparate", "glStencilOpSeparate", "glStencilFuncSeparate", "glStencilMaskSeparate"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6548 */         }) || Checks.reportMissing("GL", "OpenGL20"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL21(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6552 */     if (!ext.contains("OpenGL21")) {
/* 6553 */       return false;
/*      */     }
/*      */     
/* 6556 */     return (Checks.checkFunctions(provider, caps, new int[] { 545, 546, 547, 548, 549, 550 }, new String[] { "glUniformMatrix2x3fv", "glUniformMatrix3x2fv", "glUniformMatrix2x4fv", "glUniformMatrix4x2fv", "glUniformMatrix3x4fv", "glUniformMatrix4x3fv"
/*      */ 
/*      */ 
/*      */         
/* 6560 */         }) || Checks.reportMissing("GL", "OpenGL21"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL30(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6564 */     if (!ext.contains("OpenGL30")) {
/* 6565 */       return false;
/*      */     }
/*      */     
/* 6568 */     return (Checks.checkFunctions(provider, caps, new int[] { 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634 }, new String[] { "glGetStringi", "glClearBufferiv", "glClearBufferuiv", "glClearBufferfv", "glClearBufferfi", "glVertexAttribI1i", "glVertexAttribI2i", "glVertexAttribI3i", "glVertexAttribI4i", "glVertexAttribI1ui", "glVertexAttribI2ui", "glVertexAttribI3ui", "glVertexAttribI4ui", "glVertexAttribI1iv", "glVertexAttribI2iv", "glVertexAttribI3iv", "glVertexAttribI4iv", "glVertexAttribI1uiv", "glVertexAttribI2uiv", "glVertexAttribI3uiv", "glVertexAttribI4uiv", "glVertexAttribI4bv", "glVertexAttribI4sv", "glVertexAttribI4ubv", "glVertexAttribI4usv", "glVertexAttribIPointer", "glGetVertexAttribIiv", "glGetVertexAttribIuiv", "glUniform1ui", "glUniform2ui", "glUniform3ui", "glUniform4ui", "glUniform1uiv", "glUniform2uiv", "glUniform3uiv", "glUniform4uiv", "glGetUniformuiv", "glBindFragDataLocation", "glGetFragDataLocation", "glBeginConditionalRender", "glEndConditionalRender", "glMapBufferRange", "glFlushMappedBufferRange", "glClampColor", "glIsRenderbuffer", "glBindRenderbuffer", "glDeleteRenderbuffers", "glGenRenderbuffers", "glRenderbufferStorage", "glRenderbufferStorageMultisample", "glGetRenderbufferParameteriv", "glIsFramebuffer", "glBindFramebuffer", "glDeleteFramebuffers", "glGenFramebuffers", "glCheckFramebufferStatus", "glFramebufferTexture1D", "glFramebufferTexture2D", "glFramebufferTexture3D", "glFramebufferTextureLayer", "glFramebufferRenderbuffer", "glGetFramebufferAttachmentParameteriv", "glBlitFramebuffer", "glGenerateMipmap", "glTexParameterIiv", "glTexParameterIuiv", "glGetTexParameterIiv", "glGetTexParameterIuiv", "glColorMaski", "glGetBooleani_v", "glGetIntegeri_v", "glEnablei", "glDisablei", "glIsEnabledi", "glBindBufferRange", "glBindBufferBase", "glBeginTransformFeedback", "glEndTransformFeedback", "glTransformFeedbackVaryings", "glGetTransformFeedbackVarying", "glBindVertexArray", "glDeleteVertexArrays", "glGenVertexArrays", "glIsVertexArray"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6587 */         }) || Checks.reportMissing("GL", "OpenGL30"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL31(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6591 */     if (!ext.contains("OpenGL31")) {
/* 6592 */       return false;
/*      */     }
/*      */     
/* 6595 */     return (Checks.checkFunctions(provider, caps, new int[] { 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646 }, new String[] { "glDrawArraysInstanced", "glDrawElementsInstanced", "glCopyBufferSubData", "glPrimitiveRestartIndex", "glTexBuffer", "glGetUniformIndices", "glGetActiveUniformsiv", "glGetActiveUniformName", "glGetUniformBlockIndex", "glGetActiveUniformBlockiv", "glGetActiveUniformBlockName", "glUniformBlockBinding"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6601 */         }) || Checks.reportMissing("GL", "OpenGL31"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL32(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6605 */     if (!ext.contains("OpenGL32")) {
/* 6606 */       return false;
/*      */     }
/*      */     
/* 6609 */     return (Checks.checkFunctions(provider, caps, new int[] { 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665 }, new String[] { "glGetBufferParameteri64v", "glDrawElementsBaseVertex", "glDrawRangeElementsBaseVertex", "glDrawElementsInstancedBaseVertex", "glMultiDrawElementsBaseVertex", "glProvokingVertex", "glTexImage2DMultisample", "glTexImage3DMultisample", "glGetMultisamplefv", "glSampleMaski", "glFramebufferTexture", "glFenceSync", "glIsSync", "glDeleteSync", "glClientWaitSync", "glWaitSync", "glGetInteger64v", "glGetInteger64i_v", "glGetSynciv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6616 */         }) || Checks.reportMissing("GL", "OpenGL32"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL33(FunctionProvider provider, PointerBuffer caps, Set<String> ext, boolean fc) {
/* 6620 */     if (!ext.contains("OpenGL33")) {
/* 6621 */       return false;
/*      */     }
/*      */     
/* 6624 */     return (((fc || Checks.checkFunctions(provider, caps, new int[] { 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715 }, new String[] { "glVertexP2ui", "glVertexP3ui", "glVertexP4ui", "glVertexP2uiv", "glVertexP3uiv", "glVertexP4uiv", "glTexCoordP1ui", "glTexCoordP2ui", "glTexCoordP3ui", "glTexCoordP4ui", "glTexCoordP1uiv", "glTexCoordP2uiv", "glTexCoordP3uiv", "glTexCoordP4uiv", "glMultiTexCoordP1ui", "glMultiTexCoordP2ui", "glMultiTexCoordP3ui", "glMultiTexCoordP4ui", "glMultiTexCoordP1uiv", "glMultiTexCoordP2uiv", "glMultiTexCoordP3uiv", "glMultiTexCoordP4uiv", "glNormalP3ui", "glNormalP3uiv", "glColorP3ui", "glColorP4ui", "glColorP3uiv", "glColorP4uiv", "glSecondaryColorP3ui", "glSecondaryColorP3uiv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6633 */         })) && Checks.checkFunctions(provider, caps, new int[] { 
/*      */           666, 667, 668, 669, 670, 671, 672, 673, 674, 675,
/*      */           
/*      */           676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 
/*      */           716, 717, 718, 719, 720, 721, 722, 723
/*      */         }, new String[] { 
/*      */           "glBindFragDataLocationIndexed", "glGetFragDataIndex", "glGenSamplers", "glDeleteSamplers", "glIsSampler", "glBindSampler", "glSamplerParameteri", "glSamplerParameterf", "glSamplerParameteriv", "glSamplerParameterfv", 
/*      */           "glSamplerParameterIiv", "glSamplerParameterIuiv", "glGetSamplerParameteriv", "glGetSamplerParameterfv", "glGetSamplerParameterIiv", "glGetSamplerParameterIuiv", "glQueryCounter", "glGetQueryObjecti64v", "glGetQueryObjectui64v", "glVertexAttribDivisor", 
/* 6641 */           "glVertexAttribP1ui", "glVertexAttribP2ui", "glVertexAttribP3ui", "glVertexAttribP4ui", "glVertexAttribP1uiv", "glVertexAttribP2uiv", "glVertexAttribP3uiv", "glVertexAttribP4uiv" })) || Checks.reportMissing("GL", "OpenGL33"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL40(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6645 */     if (!ext.contains("OpenGL40")) {
/* 6646 */       return false;
/*      */     }
/*      */     
/* 6649 */     return (Checks.checkFunctions(provider, caps, new int[] { 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769 }, new String[] { "glBlendEquationi", "glBlendEquationSeparatei", "glBlendFunci", "glBlendFuncSeparatei", "glDrawArraysIndirect", "glDrawElementsIndirect", "glUniform1d", "glUniform2d", "glUniform3d", "glUniform4d", "glUniform1dv", "glUniform2dv", "glUniform3dv", "glUniform4dv", "glUniformMatrix2dv", "glUniformMatrix3dv", "glUniformMatrix4dv", "glUniformMatrix2x3dv", "glUniformMatrix2x4dv", "glUniformMatrix3x2dv", "glUniformMatrix3x4dv", "glUniformMatrix4x2dv", "glUniformMatrix4x3dv", "glGetUniformdv", "glMinSampleShading", "glGetSubroutineUniformLocation", "glGetSubroutineIndex", "glGetActiveSubroutineUniformiv", "glGetActiveSubroutineUniformName", "glGetActiveSubroutineName", "glUniformSubroutinesuiv", "glGetUniformSubroutineuiv", "glGetProgramStageiv", "glPatchParameteri", "glPatchParameterfv", "glBindTransformFeedback", "glDeleteTransformFeedbacks", "glGenTransformFeedbacks", "glIsTransformFeedback", "glPauseTransformFeedback", "glResumeTransformFeedback", "glDrawTransformFeedback", "glDrawTransformFeedbackStream", "glBeginQueryIndexed", "glEndQueryIndexed", "glGetQueryIndexediv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6661 */         }) || Checks.reportMissing("GL", "OpenGL40"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL41(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6665 */     if (!ext.contains("OpenGL41")) {
/* 6666 */       return false;
/*      */     }
/*      */     
/* 6669 */     return (Checks.checkFunctions(provider, caps, new int[] { 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857 }, new String[] { "glReleaseShaderCompiler", "glShaderBinary", "glGetShaderPrecisionFormat", "glDepthRangef", "glClearDepthf", "glGetProgramBinary", "glProgramBinary", "glProgramParameteri", "glUseProgramStages", "glActiveShaderProgram", "glCreateShaderProgramv", "glBindProgramPipeline", "glDeleteProgramPipelines", "glGenProgramPipelines", "glIsProgramPipeline", "glGetProgramPipelineiv", "glProgramUniform1i", "glProgramUniform2i", "glProgramUniform3i", "glProgramUniform4i", "glProgramUniform1ui", "glProgramUniform2ui", "glProgramUniform3ui", "glProgramUniform4ui", "glProgramUniform1f", "glProgramUniform2f", "glProgramUniform3f", "glProgramUniform4f", "glProgramUniform1d", "glProgramUniform2d", "glProgramUniform3d", "glProgramUniform4d", "glProgramUniform1iv", "glProgramUniform2iv", "glProgramUniform3iv", "glProgramUniform4iv", "glProgramUniform1uiv", "glProgramUniform2uiv", "glProgramUniform3uiv", "glProgramUniform4uiv", "glProgramUniform1fv", "glProgramUniform2fv", "glProgramUniform3fv", "glProgramUniform4fv", "glProgramUniform1dv", "glProgramUniform2dv", "glProgramUniform3dv", "glProgramUniform4dv", "glProgramUniformMatrix2fv", "glProgramUniformMatrix3fv", "glProgramUniformMatrix4fv", "glProgramUniformMatrix2dv", "glProgramUniformMatrix3dv", "glProgramUniformMatrix4dv", "glProgramUniformMatrix2x3fv", "glProgramUniformMatrix3x2fv", "glProgramUniformMatrix2x4fv", "glProgramUniformMatrix4x2fv", "glProgramUniformMatrix3x4fv", "glProgramUniformMatrix4x3fv", "glProgramUniformMatrix2x3dv", "glProgramUniformMatrix3x2dv", "glProgramUniformMatrix2x4dv", "glProgramUniformMatrix4x2dv", "glProgramUniformMatrix3x4dv", "glProgramUniformMatrix4x3dv", "glValidateProgramPipeline", "glGetProgramPipelineInfoLog", "glVertexAttribL1d", "glVertexAttribL2d", "glVertexAttribL3d", "glVertexAttribL4d", "glVertexAttribL1dv", "glVertexAttribL2dv", "glVertexAttribL3dv", "glVertexAttribL4dv", "glVertexAttribLPointer", "glGetVertexAttribLdv", "glViewportArrayv", "glViewportIndexedf", "glViewportIndexedfv", "glScissorArrayv", "glScissorIndexed", "glScissorIndexedv", "glDepthRangeArrayv", "glDepthRangeIndexed", "glGetFloati_v", "glGetDoublei_v"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6691 */         }) || Checks.reportMissing("GL", "OpenGL41"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL42(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6695 */     if (!ext.contains("OpenGL42")) {
/* 6696 */       return false;
/*      */     }
/*      */     
/* 6699 */     return (Checks.checkFunctions(provider, caps, new int[] { 858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869 }, new String[] { "glGetActiveAtomicCounterBufferiv", "glTexStorage1D", "glTexStorage2D", "glTexStorage3D", "glDrawTransformFeedbackInstanced", "glDrawTransformFeedbackStreamInstanced", "glDrawArraysInstancedBaseInstance", "glDrawElementsInstancedBaseInstance", "glDrawElementsInstancedBaseVertexBaseInstance", "glBindImageTexture", "glMemoryBarrier", "glGetInternalformativ"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6705 */         }) || Checks.reportMissing("GL", "OpenGL42"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL43(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6709 */     if (!ext.contains("OpenGL43")) {
/* 6710 */       return false;
/*      */     }
/*      */     
/* 6713 */     return (Checks.checkFunctions(provider, caps, new int[] { 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912 }, new String[] { "glClearBufferData", "glClearBufferSubData", "glDispatchCompute", "glDispatchComputeIndirect", "glCopyImageSubData", "glDebugMessageControl", "glDebugMessageInsert", "glDebugMessageCallback", "glGetDebugMessageLog", "glPushDebugGroup", "glPopDebugGroup", "glObjectLabel", "glGetObjectLabel", "glObjectPtrLabel", "glGetObjectPtrLabel", "glFramebufferParameteri", "glGetFramebufferParameteriv", "glGetInternalformati64v", "glInvalidateTexSubImage", "glInvalidateTexImage", "glInvalidateBufferSubData", "glInvalidateBufferData", "glInvalidateFramebuffer", "glInvalidateSubFramebuffer", "glMultiDrawArraysIndirect", "glMultiDrawElementsIndirect", "glGetProgramInterfaceiv", "glGetProgramResourceIndex", "glGetProgramResourceName", "glGetProgramResourceiv", "glGetProgramResourceLocation", "glGetProgramResourceLocationIndex", "glShaderStorageBlockBinding", "glTexBufferRange", "glTexStorage2DMultisample", "glTexStorage3DMultisample", "glTextureView", "glBindVertexBuffer", "glVertexAttribFormat", "glVertexAttribIFormat", "glVertexAttribLFormat", "glVertexAttribBinding", "glVertexBindingDivisor"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6725 */         }) || Checks.reportMissing("GL", "OpenGL43"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL44(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6729 */     if (!ext.contains("OpenGL44")) {
/* 6730 */       return false;
/*      */     }
/*      */     
/* 6733 */     return (Checks.checkFunctions(provider, caps, new int[] { 913, 914, 915, 916, 917, 918, 919, 920, 921 }, new String[] { "glBufferStorage", "glClearTexSubImage", "glClearTexImage", "glBindBuffersBase", "glBindBuffersRange", "glBindTextures", "glBindSamplers", "glBindImageTextures", "glBindVertexBuffers"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6738 */         }) || Checks.reportMissing("GL", "OpenGL44"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL45(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6742 */     if (!ext.contains("OpenGL45")) {
/* 6743 */       return false;
/*      */     }
/*      */     
/* 6746 */     int flag0 = (provider.getFunctionAddress("glGetMapdv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6747 */     int flag1 = (provider.getFunctionAddress("glGetMapfv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6748 */     int flag2 = (provider.getFunctionAddress("glGetMapiv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6749 */     int flag3 = (provider.getFunctionAddress("glGetPixelMapfv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6750 */     int flag4 = (provider.getFunctionAddress("glGetPixelMapuiv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6751 */     int flag5 = (provider.getFunctionAddress("glGetPixelMapusv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6752 */     int flag6 = (provider.getFunctionAddress("glGetPolygonStipple") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6753 */     int flag7 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetColorTable") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6754 */     int flag8 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetConvolutionFilter") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6755 */     int flag9 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetSeparableFilter") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6756 */     int flag10 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetHistogram") != 0L) ? 0 : Integer.MIN_VALUE;
/* 6757 */     int flag11 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetMinmax") != 0L) ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 6759 */       Checks.checkFunctions(provider, caps, new int[] { 922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1033, 1040, 1042, 1043 }, new String[] { "glClipControl", "glCreateTransformFeedbacks", "glTransformFeedbackBufferBase", "glTransformFeedbackBufferRange", "glGetTransformFeedbackiv", "glGetTransformFeedbacki_v", "glGetTransformFeedbacki64_v", "glCreateBuffers", "glNamedBufferStorage", "glNamedBufferData", "glNamedBufferSubData", "glCopyNamedBufferSubData", "glClearNamedBufferData", "glClearNamedBufferSubData", "glMapNamedBuffer", "glMapNamedBufferRange", "glUnmapNamedBuffer", "glFlushMappedNamedBufferRange", "glGetNamedBufferParameteriv", "glGetNamedBufferParameteri64v", "glGetNamedBufferPointerv", "glGetNamedBufferSubData", "glCreateFramebuffers", "glNamedFramebufferRenderbuffer", "glNamedFramebufferParameteri", "glNamedFramebufferTexture", "glNamedFramebufferTextureLayer", "glNamedFramebufferDrawBuffer", "glNamedFramebufferDrawBuffers", "glNamedFramebufferReadBuffer", "glInvalidateNamedFramebufferData", "glInvalidateNamedFramebufferSubData", "glClearNamedFramebufferiv", "glClearNamedFramebufferuiv", "glClearNamedFramebufferfv", "glClearNamedFramebufferfi", "glBlitNamedFramebuffer", "glCheckNamedFramebufferStatus", "glGetNamedFramebufferParameteriv", "glGetNamedFramebufferAttachmentParameteriv", "glCreateRenderbuffers", "glNamedRenderbufferStorage", "glNamedRenderbufferStorageMultisample", "glGetNamedRenderbufferParameteriv", "glCreateTextures", "glTextureBuffer", "glTextureBufferRange", "glTextureStorage1D", "glTextureStorage2D", "glTextureStorage3D", "glTextureStorage2DMultisample", "glTextureStorage3DMultisample", "glTextureSubImage1D", "glTextureSubImage2D", "glTextureSubImage3D", "glCompressedTextureSubImage1D", "glCompressedTextureSubImage2D", "glCompressedTextureSubImage3D", "glCopyTextureSubImage1D", "glCopyTextureSubImage2D", "glCopyTextureSubImage3D", "glTextureParameterf", "glTextureParameterfv", "glTextureParameteri", "glTextureParameterIiv", "glTextureParameterIuiv", "glTextureParameteriv", "glGenerateTextureMipmap", "glBindTextureUnit", "glGetTextureImage", "glGetCompressedTextureImage", "glGetTextureLevelParameterfv", "glGetTextureLevelParameteriv", "glGetTextureParameterfv", "glGetTextureParameterIiv", "glGetTextureParameterIuiv", "glGetTextureParameteriv", "glCreateVertexArrays", "glDisableVertexArrayAttrib", "glEnableVertexArrayAttrib", "glVertexArrayElementBuffer", "glVertexArrayVertexBuffer", "glVertexArrayVertexBuffers", "glVertexArrayAttribFormat", "glVertexArrayAttribIFormat", "glVertexArrayAttribLFormat", "glVertexArrayAttribBinding", "glVertexArrayBindingDivisor", "glGetVertexArrayiv", "glGetVertexArrayIndexediv", "glGetVertexArrayIndexed64iv", "glCreateSamplers", "glCreateProgramPipelines", "glCreateQueries", "glGetQueryBufferObjectiv", "glGetQueryBufferObjectuiv", "glGetQueryBufferObjecti64v", "glGetQueryBufferObjectui64v", "glMemoryBarrierByRegion", "glGetTextureSubImage", "glGetCompressedTextureSubImage", "glTextureBarrier", "glGetGraphicsResetStatus", "glReadnPixels", "glGetnUniformfv", "glGetnUniformiv", "glGetnUniformuiv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6787 */         }) || Checks.reportMissing("GL", "OpenGL45"));
/*      */   }
/*      */   
/*      */   private static boolean check_GL46(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6791 */     if (!ext.contains("OpenGL46")) {
/* 6792 */       return false;
/*      */     }
/*      */     
/* 6795 */     return (Checks.checkFunctions(provider, caps, new int[] { 1044, 1045, 1046, 1047 }, new String[] { "glMultiDrawArraysIndirectCount", "glMultiDrawElementsIndirectCount", "glPolygonOffsetClamp", "glSpecializeShader"
/*      */ 
/*      */ 
/*      */         
/* 6799 */         }) || Checks.reportMissing("GL", "OpenGL46"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_debug_output(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6803 */     if (!ext.contains("GL_AMD_debug_output")) {
/* 6804 */       return false;
/*      */     }
/*      */     
/* 6807 */     return (Checks.checkFunctions(provider, caps, new int[] { 1048, 1049, 1050, 1051 }, new String[] { "glDebugMessageEnableAMD", "glDebugMessageInsertAMD", "glDebugMessageCallbackAMD", "glGetDebugMessageLogAMD"
/*      */ 
/*      */ 
/*      */         
/* 6811 */         }) || Checks.reportMissing("GL", "GL_AMD_debug_output"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_draw_buffers_blend(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6815 */     if (!ext.contains("GL_AMD_draw_buffers_blend")) {
/* 6816 */       return false;
/*      */     }
/*      */     
/* 6819 */     return (Checks.checkFunctions(provider, caps, new int[] { 1052, 1053, 1054, 1055 }, new String[] { "glBlendFuncIndexedAMD", "glBlendFuncSeparateIndexedAMD", "glBlendEquationIndexedAMD", "glBlendEquationSeparateIndexedAMD"
/*      */ 
/*      */ 
/*      */         
/* 6823 */         }) || Checks.reportMissing("GL", "GL_AMD_draw_buffers_blend"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_framebuffer_multisample_advanced(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6827 */     if (!ext.contains("GL_AMD_framebuffer_multisample_advanced")) {
/* 6828 */       return false;
/*      */     }
/*      */     
/* 6831 */     return (Checks.checkFunctions(provider, caps, new int[] { 1056, 1057 }, new String[] { "glRenderbufferStorageMultisampleAdvancedAMD", "glNamedRenderbufferStorageMultisampleAdvancedAMD"
/*      */ 
/*      */ 
/*      */         
/* 6835 */         }) || Checks.reportMissing("GL", "GL_AMD_framebuffer_multisample_advanced"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_gpu_shader_int64(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6839 */     if (!ext.contains("GL_AMD_gpu_shader_int64")) {
/* 6840 */       return false;
/*      */     }
/*      */     
/* 6843 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 6845 */       Checks.checkFunctions(provider, caps, new int[] { 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, flag0 + 1076, flag0 + 1077, flag0 + 1078, flag0 + 1079, flag0 + 1080, flag0 + 1081, flag0 + 1082, flag0 + 1083, flag0 + 1084, flag0 + 1085, flag0 + 1086, flag0 + 1087, flag0 + 1088, flag0 + 1089, flag0 + 1090, flag0 + 1091 }, new String[] { "glUniform1i64NV", "glUniform2i64NV", "glUniform3i64NV", "glUniform4i64NV", "glUniform1i64vNV", "glUniform2i64vNV", "glUniform3i64vNV", "glUniform4i64vNV", "glUniform1ui64NV", "glUniform2ui64NV", "glUniform3ui64NV", "glUniform4ui64NV", "glUniform1ui64vNV", "glUniform2ui64vNV", "glUniform3ui64vNV", "glUniform4ui64vNV", "glGetUniformi64vNV", "glGetUniformui64vNV", "glProgramUniform1i64NV", "glProgramUniform2i64NV", "glProgramUniform3i64NV", "glProgramUniform4i64NV", "glProgramUniform1i64vNV", "glProgramUniform2i64vNV", "glProgramUniform3i64vNV", "glProgramUniform4i64vNV", "glProgramUniform1ui64NV", "glProgramUniform2ui64NV", "glProgramUniform3ui64NV", "glProgramUniform4ui64NV", "glProgramUniform1ui64vNV", "glProgramUniform2ui64vNV", "glProgramUniform3ui64vNV", "glProgramUniform4ui64vNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6856 */         }) || Checks.reportMissing("GL", "GL_AMD_gpu_shader_int64"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_interleaved_elements(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6860 */     if (!ext.contains("GL_AMD_interleaved_elements")) {
/* 6861 */       return false;
/*      */     }
/*      */     
/* 6864 */     return (Checks.checkFunctions(provider, caps, new int[] { 1092 }, new String[] { "glVertexAttribParameteriAMD"
/*      */ 
/*      */ 
/*      */         
/* 6868 */         }) || Checks.reportMissing("GL", "GL_AMD_interleaved_elements"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_occlusion_query_event(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6872 */     if (!ext.contains("GL_AMD_occlusion_query_event")) {
/* 6873 */       return false;
/*      */     }
/*      */     
/* 6876 */     return (Checks.checkFunctions(provider, caps, new int[] { 1093 }, new String[] { "glQueryObjectParameteruiAMD"
/*      */ 
/*      */ 
/*      */         
/* 6880 */         }) || Checks.reportMissing("GL", "GL_AMD_occlusion_query_event"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_performance_monitor(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6884 */     if (!ext.contains("GL_AMD_performance_monitor")) {
/* 6885 */       return false;
/*      */     }
/*      */     
/* 6888 */     return (Checks.checkFunctions(provider, caps, new int[] { 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104 }, new String[] { "glGetPerfMonitorGroupsAMD", "glGetPerfMonitorCountersAMD", "glGetPerfMonitorGroupStringAMD", "glGetPerfMonitorCounterStringAMD", "glGetPerfMonitorCounterInfoAMD", "glGenPerfMonitorsAMD", "glDeletePerfMonitorsAMD", "glSelectPerfMonitorCountersAMD", "glBeginPerfMonitorAMD", "glEndPerfMonitorAMD", "glGetPerfMonitorCounterDataAMD"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6894 */         }) || Checks.reportMissing("GL", "GL_AMD_performance_monitor"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_sample_positions(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6898 */     if (!ext.contains("GL_AMD_sample_positions")) {
/* 6899 */       return false;
/*      */     }
/*      */     
/* 6902 */     return (Checks.checkFunctions(provider, caps, new int[] { 1105 }, new String[] { "glSetMultisamplefvAMD"
/*      */ 
/*      */ 
/*      */         
/* 6906 */         }) || Checks.reportMissing("GL", "GL_AMD_sample_positions"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_sparse_texture(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6910 */     if (!ext.contains("GL_AMD_sparse_texture")) {
/* 6911 */       return false;
/*      */     }
/*      */     
/* 6914 */     return (Checks.checkFunctions(provider, caps, new int[] { 1106, 1107 }, new String[] { "glTexStorageSparseAMD", "glTextureStorageSparseAMD"
/*      */ 
/*      */ 
/*      */         
/* 6918 */         }) || Checks.reportMissing("GL", "GL_AMD_sparse_texture"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_stencil_operation_extended(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6922 */     if (!ext.contains("GL_AMD_stencil_operation_extended")) {
/* 6923 */       return false;
/*      */     }
/*      */     
/* 6926 */     return (Checks.checkFunctions(provider, caps, new int[] { 1108 }, new String[] { "glStencilOpValueAMD"
/*      */ 
/*      */ 
/*      */         
/* 6930 */         }) || Checks.reportMissing("GL", "GL_AMD_stencil_operation_extended"));
/*      */   }
/*      */   
/*      */   private static boolean check_AMD_vertex_shader_tessellator(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6934 */     if (!ext.contains("GL_AMD_vertex_shader_tessellator")) {
/* 6935 */       return false;
/*      */     }
/*      */     
/* 6938 */     return (Checks.checkFunctions(provider, caps, new int[] { 1109, 1110 }, new String[] { "glTessellationFactorAMD", "glTessellationModeAMD"
/*      */ 
/*      */ 
/*      */         
/* 6942 */         }) || Checks.reportMissing("GL", "GL_AMD_vertex_shader_tessellator"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_base_instance(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6946 */     if (!ext.contains("GL_ARB_base_instance")) {
/* 6947 */       return false;
/*      */     }
/*      */     
/* 6950 */     return (Checks.checkFunctions(provider, caps, new int[] { 864, 865, 866 }, new String[] { "glDrawArraysInstancedBaseInstance", "glDrawElementsInstancedBaseInstance", "glDrawElementsInstancedBaseVertexBaseInstance"
/*      */ 
/*      */ 
/*      */         
/* 6954 */         }) || Checks.reportMissing("GL", "GL_ARB_base_instance"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_bindless_texture(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6958 */     if (!ext.contains("GL_ARB_bindless_texture")) {
/* 6959 */       return false;
/*      */     }
/*      */     
/* 6962 */     return (Checks.checkFunctions(provider, caps, new int[] { 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118, 1119, 1120, 1121, 1122, 1123, 1124, 1125, 1126 }, new String[] { "glGetTextureHandleARB", "glGetTextureSamplerHandleARB", "glMakeTextureHandleResidentARB", "glMakeTextureHandleNonResidentARB", "glGetImageHandleARB", "glMakeImageHandleResidentARB", "glMakeImageHandleNonResidentARB", "glUniformHandleui64ARB", "glUniformHandleui64vARB", "glProgramUniformHandleui64ARB", "glProgramUniformHandleui64vARB", "glIsTextureHandleResidentARB", "glIsImageHandleResidentARB", "glVertexAttribL1ui64ARB", "glVertexAttribL1ui64vARB", "glGetVertexAttribLui64vARB"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6969 */         }) || Checks.reportMissing("GL", "GL_ARB_bindless_texture"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_blend_func_extended(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6973 */     if (!ext.contains("GL_ARB_blend_func_extended")) {
/* 6974 */       return false;
/*      */     }
/*      */     
/* 6977 */     return (Checks.checkFunctions(provider, caps, new int[] { 666, 667 }, new String[] { "glBindFragDataLocationIndexed", "glGetFragDataIndex"
/*      */ 
/*      */ 
/*      */         
/* 6981 */         }) || Checks.reportMissing("GL", "GL_ARB_blend_func_extended"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_buffer_storage(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6985 */     if (!ext.contains("GL_ARB_buffer_storage")) {
/* 6986 */       return false;
/*      */     }
/*      */     
/* 6989 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 6991 */       Checks.checkFunctions(provider, caps, new int[] { 913, flag0 + 1127 }, new String[] { "glBufferStorage", "glNamedBufferStorageEXT"
/*      */ 
/*      */ 
/*      */         
/* 6995 */         }) || Checks.reportMissing("GL", "GL_ARB_buffer_storage"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_cl_event(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 6999 */     if (!ext.contains("GL_ARB_cl_event")) {
/* 7000 */       return false;
/*      */     }
/*      */     
/* 7003 */     return (Checks.checkFunctions(provider, caps, new int[] { 1128 }, new String[] { "glCreateSyncFromCLeventARB"
/*      */ 
/*      */ 
/*      */         
/* 7007 */         }) || Checks.reportMissing("GL", "GL_ARB_cl_event"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_clear_buffer_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7011 */     if (!ext.contains("GL_ARB_clear_buffer_object")) {
/* 7012 */       return false;
/*      */     }
/*      */     
/* 7015 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7017 */       Checks.checkFunctions(provider, caps, new int[] { 870, 871, flag0 + 1129, flag0 + 1130 }, new String[] { "glClearBufferData", "glClearBufferSubData", "glClearNamedBufferDataEXT", "glClearNamedBufferSubDataEXT"
/*      */ 
/*      */ 
/*      */         
/* 7021 */         }) || Checks.reportMissing("GL", "GL_ARB_clear_buffer_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_clear_texture(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7025 */     if (!ext.contains("GL_ARB_clear_texture")) {
/* 7026 */       return false;
/*      */     }
/*      */     
/* 7029 */     return (Checks.checkFunctions(provider, caps, new int[] { 914, 915 }, new String[] { "glClearTexSubImage", "glClearTexImage"
/*      */ 
/*      */ 
/*      */         
/* 7033 */         }) || Checks.reportMissing("GL", "GL_ARB_clear_texture"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_clip_control(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7037 */     if (!ext.contains("GL_ARB_clip_control")) {
/* 7038 */       return false;
/*      */     }
/*      */     
/* 7041 */     return (Checks.checkFunctions(provider, caps, new int[] { 922 }, new String[] { "glClipControl"
/*      */ 
/*      */ 
/*      */         
/* 7045 */         }) || Checks.reportMissing("GL", "GL_ARB_clip_control"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_color_buffer_float(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7049 */     if (!ext.contains("GL_ARB_color_buffer_float")) {
/* 7050 */       return false;
/*      */     }
/*      */     
/* 7053 */     return (Checks.checkFunctions(provider, caps, new int[] { 1131 }, new String[] { "glClampColorARB"
/*      */ 
/*      */ 
/*      */         
/* 7057 */         }) || Checks.reportMissing("GL", "GL_ARB_color_buffer_float"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_compute_shader(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7061 */     if (!ext.contains("GL_ARB_compute_shader")) {
/* 7062 */       return false;
/*      */     }
/*      */     
/* 7065 */     return (Checks.checkFunctions(provider, caps, new int[] { 872, 873 }, new String[] { "glDispatchCompute", "glDispatchComputeIndirect"
/*      */ 
/*      */ 
/*      */         
/* 7069 */         }) || Checks.reportMissing("GL", "GL_ARB_compute_shader"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_compute_variable_group_size(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7073 */     if (!ext.contains("GL_ARB_compute_variable_group_size")) {
/* 7074 */       return false;
/*      */     }
/*      */     
/* 7077 */     return (Checks.checkFunctions(provider, caps, new int[] { 1132 }, new String[] { "glDispatchComputeGroupSizeARB"
/*      */ 
/*      */ 
/*      */         
/* 7081 */         }) || Checks.reportMissing("GL", "GL_ARB_compute_variable_group_size"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_copy_buffer(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7085 */     if (!ext.contains("GL_ARB_copy_buffer")) {
/* 7086 */       return false;
/*      */     }
/*      */     
/* 7089 */     return (Checks.checkFunctions(provider, caps, new int[] { 637 }, new String[] { "glCopyBufferSubData"
/*      */ 
/*      */ 
/*      */         
/* 7093 */         }) || Checks.reportMissing("GL", "GL_ARB_copy_buffer"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_copy_image(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7097 */     if (!ext.contains("GL_ARB_copy_image")) {
/* 7098 */       return false;
/*      */     }
/*      */     
/* 7101 */     return (Checks.checkFunctions(provider, caps, new int[] { 874 }, new String[] { "glCopyImageSubData"
/*      */ 
/*      */ 
/*      */         
/* 7105 */         }) || Checks.reportMissing("GL", "GL_ARB_copy_image"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_debug_output(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7109 */     if (!ext.contains("GL_ARB_debug_output")) {
/* 7110 */       return false;
/*      */     }
/*      */     
/* 7113 */     return (Checks.checkFunctions(provider, caps, new int[] { 1133, 1134, 1135, 1136 }, new String[] { "glDebugMessageControlARB", "glDebugMessageInsertARB", "glDebugMessageCallbackARB", "glGetDebugMessageLogARB"
/*      */ 
/*      */ 
/*      */         
/* 7117 */         }) || Checks.reportMissing("GL", "GL_ARB_debug_output"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_direct_state_access(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7121 */     if (!ext.contains("GL_ARB_direct_state_access")) {
/* 7122 */       return false;
/*      */     }
/*      */     
/* 7125 */     int flag0 = ARB_transform_feedback2(ext) ? 0 : Integer.MIN_VALUE;
/* 7126 */     int flag1 = ARB_uniform_buffer_object(ext) ? 0 : Integer.MIN_VALUE;
/* 7127 */     int flag6 = ARB_buffer_storage(ext) ? 0 : Integer.MIN_VALUE;
/* 7128 */     int flag7 = ARB_copy_buffer(ext) ? 0 : Integer.MIN_VALUE;
/* 7129 */     int flag8 = ARB_clear_texture(ext) ? 0 : Integer.MIN_VALUE;
/* 7130 */     int flag10 = ARB_map_buffer_range(ext) ? 0 : Integer.MIN_VALUE;
/* 7131 */     int flag12 = ARB_framebuffer_object(ext) ? 0 : Integer.MIN_VALUE;
/* 7132 */     int flag14 = ARB_framebuffer_no_attachments(ext) ? 0 : Integer.MIN_VALUE;
/* 7133 */     int flag20 = ARB_invalidate_subdata(ext) ? 0 : Integer.MIN_VALUE;
/* 7134 */     int flag34 = ARB_texture_buffer_object(ext) ? 0 : Integer.MIN_VALUE;
/* 7135 */     int flag35 = ARB_texture_buffer_range(ext) ? 0 : Integer.MIN_VALUE;
/* 7136 */     int flag36 = ARB_texture_storage(ext) ? 0 : Integer.MIN_VALUE;
/* 7137 */     int flag39 = ARB_texture_storage_multisample(ext) ? 0 : Integer.MIN_VALUE;
/* 7138 */     int flag42 = ARB_vertex_array_object(ext) ? 0 : Integer.MIN_VALUE;
/* 7139 */     int flag46 = ARB_vertex_attrib_binding(ext) ? 0 : Integer.MIN_VALUE;
/* 7140 */     int flag47 = ARB_multi_bind(ext) ? 0 : Integer.MIN_VALUE;
/* 7141 */     int flag56 = ARB_sampler_objects(ext) ? 0 : Integer.MIN_VALUE;
/* 7142 */     int flag57 = ARB_separate_shader_objects(ext) ? 0 : Integer.MIN_VALUE;
/* 7143 */     int flag58 = ARB_query_buffer_object(ext) ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7145 */       Checks.checkFunctions(provider, caps, new int[] { flag0 + 923, flag1 + 924, flag1 + 925, flag0 + 926, flag0 + 927, flag0 + 928, 929, flag6 + 930, 931, 932, flag7 + 933, flag8 + 934, flag8 + 935, 936, flag10 + 937, 938, flag10 + 939, 940, 941, 942, 943, flag12 + 944, flag12 + 945, flag14 + 946, flag12 + 947, flag12 + 948, flag12 + 949, flag12 + 950, flag12 + 951, flag20 + 952, flag20 + 953, flag12 + 954, flag12 + 955, flag12 + 956, flag12 + 957, flag12 + 958, flag12 + 959, flag14 + 960, flag12 + 961, flag12 + 962, flag12 + 963, flag12 + 964, flag12 + 965, 966, flag34 + 967, flag35 + 968, flag36 + 969, flag36 + 970, flag36 + 971, flag39 + 972, flag39 + 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, flag12 + 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, flag42 + 999, flag42 + 1000, flag42 + 1001, flag42 + 1002, flag46 + 1003, flag47 + 1004, flag46 + 1005, flag46 + 1006, flag46 + 1007, flag46 + 1008, flag46 + 1009, flag42 + 1010, flag42 + 1011, flag42 + 1012, flag56 + 1013, flag57 + 1014, 1015, flag58 + 1018, flag58 + 1016, flag58 + 1019, flag58 + 1017 }, new String[] { "glCreateTransformFeedbacks", "glTransformFeedbackBufferBase", "glTransformFeedbackBufferRange", "glGetTransformFeedbackiv", "glGetTransformFeedbacki_v", "glGetTransformFeedbacki64_v", "glCreateBuffers", "glNamedBufferStorage", "glNamedBufferData", "glNamedBufferSubData", "glCopyNamedBufferSubData", "glClearNamedBufferData", "glClearNamedBufferSubData", "glMapNamedBuffer", "glMapNamedBufferRange", "glUnmapNamedBuffer", "glFlushMappedNamedBufferRange", "glGetNamedBufferParameteriv", "glGetNamedBufferParameteri64v", "glGetNamedBufferPointerv", "glGetNamedBufferSubData", "glCreateFramebuffers", "glNamedFramebufferRenderbuffer", "glNamedFramebufferParameteri", "glNamedFramebufferTexture", "glNamedFramebufferTextureLayer", "glNamedFramebufferDrawBuffer", "glNamedFramebufferDrawBuffers", "glNamedFramebufferReadBuffer", "glInvalidateNamedFramebufferData", "glInvalidateNamedFramebufferSubData", "glClearNamedFramebufferiv", "glClearNamedFramebufferuiv", "glClearNamedFramebufferfv", "glClearNamedFramebufferfi", "glBlitNamedFramebuffer", "glCheckNamedFramebufferStatus", "glGetNamedFramebufferParameteriv", "glGetNamedFramebufferAttachmentParameteriv", "glCreateRenderbuffers", "glNamedRenderbufferStorage", "glNamedRenderbufferStorageMultisample", "glGetNamedRenderbufferParameteriv", "glCreateTextures", "glTextureBuffer", "glTextureBufferRange", "glTextureStorage1D", "glTextureStorage2D", "glTextureStorage3D", "glTextureStorage2DMultisample", "glTextureStorage3DMultisample", "glTextureSubImage1D", "glTextureSubImage2D", "glTextureSubImage3D", "glCompressedTextureSubImage1D", "glCompressedTextureSubImage2D", "glCompressedTextureSubImage3D", "glCopyTextureSubImage1D", "glCopyTextureSubImage2D", "glCopyTextureSubImage3D", "glTextureParameterf", "glTextureParameterfv", "glTextureParameteri", "glTextureParameterIiv", "glTextureParameterIuiv", "glTextureParameteriv", "glGenerateTextureMipmap", "glBindTextureUnit", "glGetTextureImage", "glGetCompressedTextureImage", "glGetTextureLevelParameterfv", "glGetTextureLevelParameteriv", "glGetTextureParameterfv", "glGetTextureParameterIiv", "glGetTextureParameterIuiv", "glGetTextureParameteriv", "glCreateVertexArrays", "glDisableVertexArrayAttrib", "glEnableVertexArrayAttrib", "glVertexArrayElementBuffer", "glVertexArrayVertexBuffer", "glVertexArrayVertexBuffers", "glVertexArrayAttribFormat", "glVertexArrayAttribIFormat", "glVertexArrayAttribLFormat", "glVertexArrayAttribBinding", "glVertexArrayBindingDivisor", "glGetVertexArrayiv", "glGetVertexArrayIndexediv", "glGetVertexArrayIndexed64iv", "glCreateSamplers", "glCreateProgramPipelines", "glCreateQueries", "glGetQueryBufferObjecti64v", "glGetQueryBufferObjectiv", "glGetQueryBufferObjectui64v", "glGetQueryBufferObjectuiv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7176 */         }) || Checks.reportMissing("GL", "GL_ARB_direct_state_access"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_draw_buffers(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7180 */     if (!ext.contains("GL_ARB_draw_buffers")) {
/* 7181 */       return false;
/*      */     }
/*      */     
/* 7184 */     return (Checks.checkFunctions(provider, caps, new int[] { 1137 }, new String[] { "glDrawBuffersARB"
/*      */ 
/*      */ 
/*      */         
/* 7188 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_buffers"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_draw_buffers_blend(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7192 */     if (!ext.contains("GL_ARB_draw_buffers_blend")) {
/* 7193 */       return false;
/*      */     }
/*      */     
/* 7196 */     return (Checks.checkFunctions(provider, caps, new int[] { 1138, 1139, 1140, 1141 }, new String[] { "glBlendEquationiARB", "glBlendEquationSeparateiARB", "glBlendFunciARB", "glBlendFuncSeparateiARB"
/*      */ 
/*      */ 
/*      */         
/* 7200 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_buffers_blend"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_draw_elements_base_vertex(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7204 */     if (!ext.contains("GL_ARB_draw_elements_base_vertex")) {
/* 7205 */       return false;
/*      */     }
/*      */     
/* 7208 */     return (Checks.checkFunctions(provider, caps, new int[] { 648, 649, 650, 651 }, new String[] { "glDrawElementsBaseVertex", "glDrawRangeElementsBaseVertex", "glDrawElementsInstancedBaseVertex", "glMultiDrawElementsBaseVertex"
/*      */ 
/*      */ 
/*      */         
/* 7212 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_elements_base_vertex"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_draw_indirect(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7216 */     if (!ext.contains("GL_ARB_draw_indirect")) {
/* 7217 */       return false;
/*      */     }
/*      */     
/* 7220 */     return (Checks.checkFunctions(provider, caps, new int[] { 728, 729 }, new String[] { "glDrawArraysIndirect", "glDrawElementsIndirect"
/*      */ 
/*      */ 
/*      */         
/* 7224 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_indirect"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_draw_instanced(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7228 */     if (!ext.contains("GL_ARB_draw_instanced")) {
/* 7229 */       return false;
/*      */     }
/*      */     
/* 7232 */     return (Checks.checkFunctions(provider, caps, new int[] { 1142, 1143 }, new String[] { "glDrawArraysInstancedARB", "glDrawElementsInstancedARB"
/*      */ 
/*      */ 
/*      */         
/* 7236 */         }) || Checks.reportMissing("GL", "GL_ARB_draw_instanced"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_ES2_compatibility(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7240 */     if (!ext.contains("GL_ARB_ES2_compatibility")) {
/* 7241 */       return false;
/*      */     }
/*      */     
/* 7244 */     return (Checks.checkFunctions(provider, caps, new int[] { 770, 771, 772, 773, 774 }, new String[] { "glReleaseShaderCompiler", "glShaderBinary", "glGetShaderPrecisionFormat", "glDepthRangef", "glClearDepthf"
/*      */ 
/*      */ 
/*      */         
/* 7248 */         }) || Checks.reportMissing("GL", "GL_ARB_ES2_compatibility"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_ES3_1_compatibility(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7252 */     if (!ext.contains("GL_ARB_ES3_1_compatibility")) {
/* 7253 */       return false;
/*      */     }
/*      */     
/* 7256 */     return (Checks.checkFunctions(provider, caps, new int[] { 1020 }, new String[] { "glMemoryBarrierByRegion"
/*      */ 
/*      */ 
/*      */         
/* 7260 */         }) || Checks.reportMissing("GL", "GL_ARB_ES3_1_compatibility"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_ES3_2_compatibility(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7264 */     if (!ext.contains("GL_ARB_ES3_2_compatibility")) {
/* 7265 */       return false;
/*      */     }
/*      */     
/* 7268 */     return (Checks.checkFunctions(provider, caps, new int[] { 1144 }, new String[] { "glPrimitiveBoundingBoxARB"
/*      */ 
/*      */ 
/*      */         
/* 7272 */         }) || Checks.reportMissing("GL", "GL_ARB_ES3_2_compatibility"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_framebuffer_no_attachments(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7276 */     if (!ext.contains("GL_ARB_framebuffer_no_attachments")) {
/* 7277 */       return false;
/*      */     }
/*      */     
/* 7280 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7282 */       Checks.checkFunctions(provider, caps, new int[] { 885, 886, flag0 + 1145, flag0 + 1146 }, new String[] { "glFramebufferParameteri", "glGetFramebufferParameteriv", "glNamedFramebufferParameteriEXT", "glGetNamedFramebufferParameterivEXT"
/*      */ 
/*      */ 
/*      */         
/* 7286 */         }) || Checks.reportMissing("GL", "GL_ARB_framebuffer_no_attachments"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_framebuffer_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7290 */     if (!ext.contains("GL_ARB_framebuffer_object")) {
/* 7291 */       return false;
/*      */     }
/*      */     
/* 7294 */     return (Checks.checkFunctions(provider, caps, new int[] { 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614 }, new String[] { "glIsRenderbuffer", "glBindRenderbuffer", "glDeleteRenderbuffers", "glGenRenderbuffers", "glRenderbufferStorage", "glRenderbufferStorageMultisample", "glGetRenderbufferParameteriv", "glIsFramebuffer", "glBindFramebuffer", "glDeleteFramebuffers", "glGenFramebuffers", "glCheckFramebufferStatus", "glFramebufferTexture1D", "glFramebufferTexture2D", "glFramebufferTexture3D", "glFramebufferTextureLayer", "glFramebufferRenderbuffer", "glGetFramebufferAttachmentParameteriv", "glBlitFramebuffer", "glGenerateMipmap"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7301 */         }) || Checks.reportMissing("GL", "GL_ARB_framebuffer_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_geometry_shader4(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7305 */     if (!ext.contains("GL_ARB_geometry_shader4")) {
/* 7306 */       return false;
/*      */     }
/*      */     
/* 7309 */     return (Checks.checkFunctions(provider, caps, new int[] { 1147, 1148, 1149, 1150 }, new String[] { "glProgramParameteriARB", "glFramebufferTextureARB", "glFramebufferTextureLayerARB", "glFramebufferTextureFaceARB"
/*      */ 
/*      */ 
/*      */         
/* 7313 */         }) || Checks.reportMissing("GL", "GL_ARB_geometry_shader4"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_get_program_binary(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7317 */     if (!ext.contains("GL_ARB_get_program_binary")) {
/* 7318 */       return false;
/*      */     }
/*      */     
/* 7321 */     return (Checks.checkFunctions(provider, caps, new int[] { 775, 776, 777 }, new String[] { "glGetProgramBinary", "glProgramBinary", "glProgramParameteri"
/*      */ 
/*      */ 
/*      */         
/* 7325 */         }) || Checks.reportMissing("GL", "GL_ARB_get_program_binary"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_get_texture_sub_image(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7329 */     if (!ext.contains("GL_ARB_get_texture_sub_image")) {
/* 7330 */       return false;
/*      */     }
/*      */     
/* 7333 */     return (Checks.checkFunctions(provider, caps, new int[] { 1021, 1022 }, new String[] { "glGetTextureSubImage", "glGetCompressedTextureSubImage"
/*      */ 
/*      */ 
/*      */         
/* 7337 */         }) || Checks.reportMissing("GL", "GL_ARB_get_texture_sub_image"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_gl_spirv(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7341 */     if (!ext.contains("GL_ARB_gl_spirv")) {
/* 7342 */       return false;
/*      */     }
/*      */     
/* 7345 */     return (Checks.checkFunctions(provider, caps, new int[] { 1151 }, new String[] { "glSpecializeShaderARB"
/*      */ 
/*      */ 
/*      */         
/* 7349 */         }) || Checks.reportMissing("GL", "GL_ARB_gl_spirv"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_gpu_shader_fp64(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7353 */     if (!ext.contains("GL_ARB_gpu_shader_fp64")) {
/* 7354 */       return false;
/*      */     }
/*      */     
/* 7357 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7359 */       Checks.checkFunctions(provider, caps, new int[] { 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747 }, new String[] { "glUniform1d", "glUniform2d", "glUniform3d", "glUniform4d", "glUniform1dv", "glUniform2dv", "glUniform3dv", "glUniform4dv", "glUniformMatrix2dv", "glUniformMatrix3dv", "glUniformMatrix4dv", "glUniformMatrix2x3dv", "glUniformMatrix2x4dv", "glUniformMatrix3x2dv", "glUniformMatrix3x4dv", "glUniformMatrix4x2dv", "glUniformMatrix4x3dv", "glGetUniformdv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7365 */         }) || Checks.reportMissing("GL", "GL_ARB_gpu_shader_fp64"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_gpu_shader_int64(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7369 */     if (!ext.contains("GL_ARB_gpu_shader_int64")) {
/* 7370 */       return false;
/*      */     }
/*      */     
/* 7373 */     return (Checks.checkFunctions(provider, caps, new int[] { 1169, 1170, 1171, 1172, 1173, 1174, 1175, 1176, 1177, 1178, 1179, 1180, 1181, 1182, 1183, 1184, 1185, 1186, 1187, 1188, 1189, 1190, 1191, 1192, 1193, 1194, 1195, 1196, 1197, 1198, 1199, 1200, 1201, 1202, 1203, 1204 }, new String[] { "glUniform1i64ARB", "glUniform1i64vARB", "glProgramUniform1i64ARB", "glProgramUniform1i64vARB", "glUniform2i64ARB", "glUniform2i64vARB", "glProgramUniform2i64ARB", "glProgramUniform2i64vARB", "glUniform3i64ARB", "glUniform3i64vARB", "glProgramUniform3i64ARB", "glProgramUniform3i64vARB", "glUniform4i64ARB", "glUniform4i64vARB", "glProgramUniform4i64ARB", "glProgramUniform4i64vARB", "glUniform1ui64ARB", "glUniform1ui64vARB", "glProgramUniform1ui64ARB", "glProgramUniform1ui64vARB", "glUniform2ui64ARB", "glUniform2ui64vARB", "glProgramUniform2ui64ARB", "glProgramUniform2ui64vARB", "glUniform3ui64ARB", "glUniform3ui64vARB", "glProgramUniform3ui64ARB", "glProgramUniform3ui64vARB", "glUniform4ui64ARB", "glUniform4ui64vARB", "glProgramUniform4ui64ARB", "glProgramUniform4ui64vARB", "glGetUniformi64vARB", "glGetUniformui64vARB", "glGetnUniformi64vARB", "glGetnUniformui64vARB"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7384 */         }) || Checks.reportMissing("GL", "GL_ARB_gpu_shader_int64"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_imaging(FunctionProvider provider, PointerBuffer caps, Set<String> ext, boolean fc) {
/* 7388 */     if (!ext.contains("GL_ARB_imaging")) {
/* 7389 */       return false;
/*      */     }
/*      */     
/* 7392 */     return (((fc || Checks.checkFunctions(provider, caps, new int[] { 1205, 1206, 1207, 1208, 1209, 1210, 1211, 1212, 1213, 1214, 1215, 1216, 1217, 1218, 1219, 1220, 1221, 1222, 1223, 1224, 1225, 1226, 1227, 1228, 1229, 1230, 1231, 1232, 1233, 1234, 1235, 1236 }, new String[] { "glColorTable", "glCopyColorTable", "glColorTableParameteriv", "glColorTableParameterfv", "glGetColorTable", "glGetColorTableParameteriv", "glGetColorTableParameterfv", "glColorSubTable", "glCopyColorSubTable", "glConvolutionFilter1D", "glConvolutionFilter2D", "glCopyConvolutionFilter1D", "glCopyConvolutionFilter2D", "glGetConvolutionFilter", "glSeparableFilter2D", "glGetSeparableFilter", "glConvolutionParameteri", "glConvolutionParameteriv", "glConvolutionParameterf", "glConvolutionParameterfv", "glGetConvolutionParameteriv", "glGetConvolutionParameterfv", "glHistogram", "glResetHistogram", "glGetHistogram", "glGetHistogramParameteriv", "glGetHistogramParameterfv", "glMinmax", "glResetMinmax", "glGetMinmax", "glGetMinmaxParameteriv", "glGetMinmaxParameterfv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7402 */         })) && Checks.checkFunctions(provider, caps, new int[] {
/*      */           386, 387 }, new String[] {
/*      */           "glBlendColor", "glBlendEquation"
/*      */         
/* 7406 */         })) || Checks.reportMissing("GL", "GL_ARB_imaging"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_indirect_parameters(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7410 */     if (!ext.contains("GL_ARB_indirect_parameters")) {
/* 7411 */       return false;
/*      */     }
/*      */     
/* 7414 */     return (Checks.checkFunctions(provider, caps, new int[] { 1237, 1238 }, new String[] { "glMultiDrawArraysIndirectCountARB", "glMultiDrawElementsIndirectCountARB"
/*      */ 
/*      */ 
/*      */         
/* 7418 */         }) || Checks.reportMissing("GL", "GL_ARB_indirect_parameters"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_instanced_arrays(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7422 */     if (!ext.contains("GL_ARB_instanced_arrays")) {
/* 7423 */       return false;
/*      */     }
/*      */     
/* 7426 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7428 */       Checks.checkFunctions(provider, caps, new int[] { 1239 }, new String[] { "glVertexAttribDivisorARB"
/*      */ 
/*      */ 
/*      */         
/* 7432 */         }) || Checks.reportMissing("GL", "GL_ARB_instanced_arrays"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_internalformat_query(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7436 */     if (!ext.contains("GL_ARB_internalformat_query")) {
/* 7437 */       return false;
/*      */     }
/*      */     
/* 7440 */     return (Checks.checkFunctions(provider, caps, new int[] { 869 }, new String[] { "glGetInternalformativ"
/*      */ 
/*      */ 
/*      */         
/* 7444 */         }) || Checks.reportMissing("GL", "GL_ARB_internalformat_query"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_internalformat_query2(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7448 */     if (!ext.contains("GL_ARB_internalformat_query2")) {
/* 7449 */       return false;
/*      */     }
/*      */     
/* 7452 */     return (Checks.checkFunctions(provider, caps, new int[] { 887 }, new String[] { "glGetInternalformati64v"
/*      */ 
/*      */ 
/*      */         
/* 7456 */         }) || Checks.reportMissing("GL", "GL_ARB_internalformat_query2"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_invalidate_subdata(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7460 */     if (!ext.contains("GL_ARB_invalidate_subdata")) {
/* 7461 */       return false;
/*      */     }
/*      */     
/* 7464 */     return (Checks.checkFunctions(provider, caps, new int[] { 888, 889, 890, 891, 892, 893 }, new String[] { "glInvalidateTexSubImage", "glInvalidateTexImage", "glInvalidateBufferSubData", "glInvalidateBufferData", "glInvalidateFramebuffer", "glInvalidateSubFramebuffer"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7469 */         }) || Checks.reportMissing("GL", "GL_ARB_invalidate_subdata"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_map_buffer_range(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7473 */     if (!ext.contains("GL_ARB_map_buffer_range")) {
/* 7474 */       return false;
/*      */     }
/*      */     
/* 7477 */     return (Checks.checkFunctions(provider, caps, new int[] { 592, 593 }, new String[] { "glMapBufferRange", "glFlushMappedBufferRange"
/*      */ 
/*      */ 
/*      */         
/* 7481 */         }) || Checks.reportMissing("GL", "GL_ARB_map_buffer_range"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_matrix_palette(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7485 */     if (!ext.contains("GL_ARB_matrix_palette")) {
/* 7486 */       return false;
/*      */     }
/*      */     
/* 7489 */     return (Checks.checkFunctions(provider, caps, new int[] { 1241, 1242, 1243, 1244, 1245 }, new String[] { "glCurrentPaletteMatrixARB", "glMatrixIndexuivARB", "glMatrixIndexubvARB", "glMatrixIndexusvARB", "glMatrixIndexPointerARB"
/*      */ 
/*      */ 
/*      */         
/* 7493 */         }) || Checks.reportMissing("GL", "GL_ARB_matrix_palette"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_multi_bind(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7497 */     if (!ext.contains("GL_ARB_multi_bind")) {
/* 7498 */       return false;
/*      */     }
/*      */     
/* 7501 */     return (Checks.checkFunctions(provider, caps, new int[] { 916, 917, 918, 919, 920, 921 }, new String[] { "glBindBuffersBase", "glBindBuffersRange", "glBindTextures", "glBindSamplers", "glBindImageTextures", "glBindVertexBuffers"
/*      */ 
/*      */ 
/*      */         
/* 7505 */         }) || Checks.reportMissing("GL", "GL_ARB_multi_bind"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_multi_draw_indirect(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7509 */     if (!ext.contains("GL_ARB_multi_draw_indirect")) {
/* 7510 */       return false;
/*      */     }
/*      */     
/* 7513 */     return (Checks.checkFunctions(provider, caps, new int[] { 894, 895 }, new String[] { "glMultiDrawArraysIndirect", "glMultiDrawElementsIndirect"
/*      */ 
/*      */ 
/*      */         
/* 7517 */         }) || Checks.reportMissing("GL", "GL_ARB_multi_draw_indirect"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_multisample(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7521 */     if (!ext.contains("GL_ARB_multisample")) {
/* 7522 */       return false;
/*      */     }
/*      */     
/* 7525 */     return (Checks.checkFunctions(provider, caps, new int[] { 1246 }, new String[] { "glSampleCoverageARB"
/*      */ 
/*      */ 
/*      */         
/* 7529 */         }) || Checks.reportMissing("GL", "GL_ARB_multisample"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_multitexture(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7533 */     if (!ext.contains("GL_ARB_multitexture")) {
/* 7534 */       return false;
/*      */     }
/*      */     
/* 7537 */     return (Checks.checkFunctions(provider, caps, new int[] { 1247, 1248, 1249, 1250, 1251, 1252, 1253, 1254, 1255, 1256, 1257, 1258, 1259, 1260, 1261, 1262, 1263, 1264, 1265, 1266, 1267, 1268, 1269, 1270, 1271, 1272, 1273, 1274, 1275, 1276, 1277, 1278, 1279, 1280 }, new String[] { "glActiveTextureARB", "glClientActiveTextureARB", "glMultiTexCoord1fARB", "glMultiTexCoord1sARB", "glMultiTexCoord1iARB", "glMultiTexCoord1dARB", "glMultiTexCoord1fvARB", "glMultiTexCoord1svARB", "glMultiTexCoord1ivARB", "glMultiTexCoord1dvARB", "glMultiTexCoord2fARB", "glMultiTexCoord2sARB", "glMultiTexCoord2iARB", "glMultiTexCoord2dARB", "glMultiTexCoord2fvARB", "glMultiTexCoord2svARB", "glMultiTexCoord2ivARB", "glMultiTexCoord2dvARB", "glMultiTexCoord3fARB", "glMultiTexCoord3sARB", "glMultiTexCoord3iARB", "glMultiTexCoord3dARB", "glMultiTexCoord3fvARB", "glMultiTexCoord3svARB", "glMultiTexCoord3ivARB", "glMultiTexCoord3dvARB", "glMultiTexCoord4fARB", "glMultiTexCoord4sARB", "glMultiTexCoord4iARB", "glMultiTexCoord4dARB", "glMultiTexCoord4fvARB", "glMultiTexCoord4svARB", "glMultiTexCoord4ivARB", "glMultiTexCoord4dvARB"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7547 */         }) || Checks.reportMissing("GL", "GL_ARB_multitexture"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_occlusion_query(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7551 */     if (!ext.contains("GL_ARB_occlusion_query")) {
/* 7552 */       return false;
/*      */     }
/*      */     
/* 7555 */     return (Checks.checkFunctions(provider, caps, new int[] { 1281, 1282, 1283, 1284, 1285, 1286, 1287, 1288 }, new String[] { "glGenQueriesARB", "glDeleteQueriesARB", "glIsQueryARB", "glBeginQueryARB", "glEndQueryARB", "glGetQueryivARB", "glGetQueryObjectivARB", "glGetQueryObjectuivARB"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7560 */         }) || Checks.reportMissing("GL", "GL_ARB_occlusion_query"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_parallel_shader_compile(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7564 */     if (!ext.contains("GL_ARB_parallel_shader_compile")) {
/* 7565 */       return false;
/*      */     }
/*      */     
/* 7568 */     return (Checks.checkFunctions(provider, caps, new int[] { 1289 }, new String[] { "glMaxShaderCompilerThreadsARB"
/*      */ 
/*      */ 
/*      */         
/* 7572 */         }) || Checks.reportMissing("GL", "GL_ARB_parallel_shader_compile"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_point_parameters(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7576 */     if (!ext.contains("GL_ARB_point_parameters")) {
/* 7577 */       return false;
/*      */     }
/*      */     
/* 7580 */     return (Checks.checkFunctions(provider, caps, new int[] { 1290, 1291 }, new String[] { "glPointParameterfARB", "glPointParameterfvARB"
/*      */ 
/*      */ 
/*      */         
/* 7584 */         }) || Checks.reportMissing("GL", "GL_ARB_point_parameters"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_polygon_offset_clamp(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7588 */     if (!ext.contains("GL_ARB_polygon_offset_clamp")) {
/* 7589 */       return false;
/*      */     }
/*      */     
/* 7592 */     return (Checks.checkFunctions(provider, caps, new int[] { 1046 }, new String[] { "glPolygonOffsetClamp"
/*      */ 
/*      */ 
/*      */         
/* 7596 */         }) || Checks.reportMissing("GL", "GL_ARB_polygon_offset_clamp"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_program_interface_query(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7600 */     if (!ext.contains("GL_ARB_program_interface_query")) {
/* 7601 */       return false;
/*      */     }
/*      */     
/* 7604 */     return (Checks.checkFunctions(provider, caps, new int[] { 896, 897, 898, 899, 900, 901 }, new String[] { "glGetProgramInterfaceiv", "glGetProgramResourceIndex", "glGetProgramResourceName", "glGetProgramResourceiv", "glGetProgramResourceLocation", "glGetProgramResourceLocationIndex"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7609 */         }) || Checks.reportMissing("GL", "GL_ARB_program_interface_query"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_provoking_vertex(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7613 */     if (!ext.contains("GL_ARB_provoking_vertex")) {
/* 7614 */       return false;
/*      */     }
/*      */     
/* 7617 */     return (Checks.checkFunctions(provider, caps, new int[] { 652 }, new String[] { "glProvokingVertex"
/*      */ 
/*      */ 
/*      */         
/* 7621 */         }) || Checks.reportMissing("GL", "GL_ARB_provoking_vertex"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_robustness(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7625 */     if (!ext.contains("GL_ARB_robustness")) {
/* 7626 */       return false;
/*      */     }
/*      */     
/* 7629 */     int flag0 = (provider.getFunctionAddress("glGetMapdv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7630 */     int flag1 = (provider.getFunctionAddress("glGetMapfv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7631 */     int flag2 = (provider.getFunctionAddress("glGetMapiv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7632 */     int flag3 = (provider.getFunctionAddress("glGetPixelMapfv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7633 */     int flag4 = (provider.getFunctionAddress("glGetPixelMapuiv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7634 */     int flag5 = (provider.getFunctionAddress("glGetPixelMapusv") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7635 */     int flag6 = (provider.getFunctionAddress("glGetPolygonStipple") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7636 */     int flag7 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetColorTable") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7637 */     int flag8 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetConvolutionFilter") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7638 */     int flag9 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetSeparableFilter") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7639 */     int flag10 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetHistogram") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7640 */     int flag11 = (ext.contains("GL_ARB_imaging") && provider.getFunctionAddress("glGetMinmax") != 0L) ? 0 : Integer.MIN_VALUE;
/* 7641 */     int flag12 = ext.contains("OpenGL13") ? 0 : Integer.MIN_VALUE;
/* 7642 */     int flag13 = ext.contains("OpenGL20") ? 0 : Integer.MIN_VALUE;
/* 7643 */     int flag15 = ext.contains("OpenGL30") ? 0 : Integer.MIN_VALUE;
/* 7644 */     int flag16 = ext.contains("OpenGL40") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7646 */       Checks.checkFunctions(provider, caps, new int[] { 1292, flag0 + 1293, flag1 + 1294, flag2 + 1295, flag3 + 1296, flag4 + 1297, flag5 + 1298, flag6 + 1299, 1300, 1301, flag7 + 1302, flag8 + 1303, flag9 + 1304, flag10 + 1305, flag11 + 1306, flag12 + 1307, flag13 + 1308, flag13 + 1309, flag15 + 1310, flag16 + 1311 }, new String[] { "glGetGraphicsResetStatusARB", "glGetnMapdvARB", "glGetnMapfvARB", "glGetnMapivARB", "glGetnPixelMapfvARB", "glGetnPixelMapuivARB", "glGetnPixelMapusvARB", "glGetnPolygonStippleARB", "glGetnTexImageARB", "glReadnPixelsARB", "glGetnColorTableARB", "glGetnConvolutionFilterARB", "glGetnSeparableFilterARB", "glGetnHistogramARB", "glGetnMinmaxARB", "glGetnCompressedTexImageARB", "glGetnUniformfvARB", "glGetnUniformivARB", "glGetnUniformuivARB", "glGetnUniformdvARB"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7654 */         }) || Checks.reportMissing("GL", "GL_ARB_robustness"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_sample_locations(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7658 */     if (!ext.contains("GL_ARB_sample_locations")) {
/* 7659 */       return false;
/*      */     }
/*      */     
/* 7662 */     return (Checks.checkFunctions(provider, caps, new int[] { 1312, 1313, 1314 }, new String[] { "glFramebufferSampleLocationsfvARB", "glNamedFramebufferSampleLocationsfvARB", "glEvaluateDepthValuesARB"
/*      */ 
/*      */ 
/*      */         
/* 7666 */         }) || Checks.reportMissing("GL", "GL_ARB_sample_locations"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_sample_shading(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7670 */     if (!ext.contains("GL_ARB_sample_shading")) {
/* 7671 */       return false;
/*      */     }
/*      */     
/* 7674 */     return (Checks.checkFunctions(provider, caps, new int[] { 1315 }, new String[] { "glMinSampleShadingARB"
/*      */ 
/*      */ 
/*      */         
/* 7678 */         }) || Checks.reportMissing("GL", "GL_ARB_sample_shading"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_sampler_objects(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7682 */     if (!ext.contains("GL_ARB_sampler_objects")) {
/* 7683 */       return false;
/*      */     }
/*      */     
/* 7686 */     return (Checks.checkFunctions(provider, caps, new int[] { 668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681 }, new String[] { "glGenSamplers", "glDeleteSamplers", "glIsSampler", "glBindSampler", "glSamplerParameteri", "glSamplerParameterf", "glSamplerParameteriv", "glSamplerParameterfv", "glSamplerParameterIiv", "glSamplerParameterIuiv", "glGetSamplerParameteriv", "glGetSamplerParameterfv", "glGetSamplerParameterIiv", "glGetSamplerParameterIuiv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7692 */         }) || Checks.reportMissing("GL", "GL_ARB_sampler_objects"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_separate_shader_objects(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7696 */     if (!ext.contains("GL_ARB_separate_shader_objects")) {
/* 7697 */       return false;
/*      */     }
/*      */     
/* 7700 */     return (Checks.checkFunctions(provider, caps, new int[] { 778, 779, 780, 781, 782, 783, 784, 777, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837 }, new String[] { "glUseProgramStages", "glActiveShaderProgram", "glCreateShaderProgramv", "glBindProgramPipeline", "glDeleteProgramPipelines", "glGenProgramPipelines", "glIsProgramPipeline", "glProgramParameteri", "glGetProgramPipelineiv", "glProgramUniform1i", "glProgramUniform2i", "glProgramUniform3i", "glProgramUniform4i", "glProgramUniform1ui", "glProgramUniform2ui", "glProgramUniform3ui", "glProgramUniform4ui", "glProgramUniform1f", "glProgramUniform2f", "glProgramUniform3f", "glProgramUniform4f", "glProgramUniform1d", "glProgramUniform2d", "glProgramUniform3d", "glProgramUniform4d", "glProgramUniform1iv", "glProgramUniform2iv", "glProgramUniform3iv", "glProgramUniform4iv", "glProgramUniform1uiv", "glProgramUniform2uiv", "glProgramUniform3uiv", "glProgramUniform4uiv", "glProgramUniform1fv", "glProgramUniform2fv", "glProgramUniform3fv", "glProgramUniform4fv", "glProgramUniform1dv", "glProgramUniform2dv", "glProgramUniform3dv", "glProgramUniform4dv", "glProgramUniformMatrix2fv", "glProgramUniformMatrix3fv", "glProgramUniformMatrix4fv", "glProgramUniformMatrix2dv", "glProgramUniformMatrix3dv", "glProgramUniformMatrix4dv", "glProgramUniformMatrix2x3fv", "glProgramUniformMatrix3x2fv", "glProgramUniformMatrix2x4fv", "glProgramUniformMatrix4x2fv", "glProgramUniformMatrix3x4fv", "glProgramUniformMatrix4x3fv", "glProgramUniformMatrix2x3dv", "glProgramUniformMatrix3x2dv", "glProgramUniformMatrix2x4dv", "glProgramUniformMatrix4x2dv", "glProgramUniformMatrix3x4dv", "glProgramUniformMatrix4x3dv", "glValidateProgramPipeline", "glGetProgramPipelineInfoLog"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7717 */         }) || Checks.reportMissing("GL", "GL_ARB_separate_shader_objects"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_shader_atomic_counters(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7721 */     if (!ext.contains("GL_ARB_shader_atomic_counters")) {
/* 7722 */       return false;
/*      */     }
/*      */     
/* 7725 */     return (Checks.checkFunctions(provider, caps, new int[] { 858 }, new String[] { "glGetActiveAtomicCounterBufferiv"
/*      */ 
/*      */ 
/*      */         
/* 7729 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_atomic_counters"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_shader_image_load_store(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7733 */     if (!ext.contains("GL_ARB_shader_image_load_store")) {
/* 7734 */       return false;
/*      */     }
/*      */     
/* 7737 */     return (Checks.checkFunctions(provider, caps, new int[] { 867, 868 }, new String[] { "glBindImageTexture", "glMemoryBarrier"
/*      */ 
/*      */ 
/*      */         
/* 7741 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_image_load_store"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_shader_objects(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7745 */     if (!ext.contains("GL_ARB_shader_objects")) {
/* 7746 */       return false;
/*      */     }
/*      */     
/* 7749 */     return (Checks.checkFunctions(provider, caps, new int[] { 1316, 1317, 1318, 1319, 1320, 1321, 1322, 1323, 1324, 1325, 1326, 1327, 1328, 1329, 1330, 1331, 1332, 1333, 1334, 1335, 1336, 1337, 1338, 1339, 1340, 1341, 1342, 1343, 1344, 1345, 1346, 1347, 1348, 1349, 1350, 1351, 1352, 1353, 1354 }, new String[] { "glDeleteObjectARB", "glGetHandleARB", "glDetachObjectARB", "glCreateShaderObjectARB", "glShaderSourceARB", "glCompileShaderARB", "glCreateProgramObjectARB", "glAttachObjectARB", "glLinkProgramARB", "glUseProgramObjectARB", "glValidateProgramARB", "glUniform1fARB", "glUniform2fARB", "glUniform3fARB", "glUniform4fARB", "glUniform1iARB", "glUniform2iARB", "glUniform3iARB", "glUniform4iARB", "glUniform1fvARB", "glUniform2fvARB", "glUniform3fvARB", "glUniform4fvARB", "glUniform1ivARB", "glUniform2ivARB", "glUniform3ivARB", "glUniform4ivARB", "glUniformMatrix2fvARB", "glUniformMatrix3fvARB", "glUniformMatrix4fvARB", "glGetObjectParameterfvARB", "glGetObjectParameterivARB", "glGetInfoLogARB", "glGetAttachedObjectsARB", "glGetUniformLocationARB", "glGetActiveUniformARB", "glGetUniformfvARB", "glGetUniformivARB", "glGetShaderSourceARB"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7760 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_objects"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_shader_storage_buffer_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7764 */     if (!ext.contains("GL_ARB_shader_storage_buffer_object")) {
/* 7765 */       return false;
/*      */     }
/*      */     
/* 7768 */     return (Checks.checkFunctions(provider, caps, new int[] { 902 }, new String[] { "glShaderStorageBlockBinding"
/*      */ 
/*      */ 
/*      */         
/* 7772 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_storage_buffer_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_shader_subroutine(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7776 */     if (!ext.contains("GL_ARB_shader_subroutine")) {
/* 7777 */       return false;
/*      */     }
/*      */     
/* 7780 */     return (Checks.checkFunctions(provider, caps, new int[] { 749, 750, 751, 752, 753, 754, 755, 756 }, new String[] { "glGetSubroutineUniformLocation", "glGetSubroutineIndex", "glGetActiveSubroutineUniformiv", "glGetActiveSubroutineUniformName", "glGetActiveSubroutineName", "glUniformSubroutinesuiv", "glGetUniformSubroutineuiv", "glGetProgramStageiv"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7785 */         }) || Checks.reportMissing("GL", "GL_ARB_shader_subroutine"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_shading_language_include(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7789 */     if (!ext.contains("GL_ARB_shading_language_include")) {
/* 7790 */       return false;
/*      */     }
/*      */     
/* 7793 */     return (Checks.checkFunctions(provider, caps, new int[] { 1355, 1356, 1357, 1358, 1359, 1360 }, new String[] { "glNamedStringARB", "glDeleteNamedStringARB", "glCompileShaderIncludeARB", "glIsNamedStringARB", "glGetNamedStringARB", "glGetNamedStringivARB"
/*      */ 
/*      */ 
/*      */         
/* 7797 */         }) || Checks.reportMissing("GL", "GL_ARB_shading_language_include"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_sparse_buffer(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7801 */     if (!ext.contains("GL_ARB_sparse_buffer")) {
/* 7802 */       return false;
/*      */     }
/*      */     
/* 7805 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE;
/* 7806 */     int flag1 = ext.contains("GL_ARB_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7808 */       Checks.checkFunctions(provider, caps, new int[] { 1361 }, new String[] { "glBufferPageCommitmentARB"
/*      */ 
/*      */ 
/*      */         
/* 7812 */         }) || Checks.reportMissing("GL", "GL_ARB_sparse_buffer"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_sparse_texture(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7816 */     if (!ext.contains("GL_ARB_sparse_texture")) {
/* 7817 */       return false;
/*      */     }
/*      */     
/* 7820 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7822 */       Checks.checkFunctions(provider, caps, new int[] { 1364, flag0 + 1365 }, new String[] { "glTexPageCommitmentARB", "glTexturePageCommitmentEXT"
/*      */ 
/*      */ 
/*      */         
/* 7826 */         }) || Checks.reportMissing("GL", "GL_ARB_sparse_texture"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_sync(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7830 */     if (!ext.contains("GL_ARB_sync")) {
/* 7831 */       return false;
/*      */     }
/*      */     
/* 7834 */     return (Checks.checkFunctions(provider, caps, new int[] { 658, 659, 660, 661, 662, 663, 665 }, new String[] { "glFenceSync", "glIsSync", "glDeleteSync", "glClientWaitSync", "glWaitSync", "glGetInteger64v", "glGetSynciv"
/*      */ 
/*      */ 
/*      */         
/* 7838 */         }) || Checks.reportMissing("GL", "GL_ARB_sync"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_tessellation_shader(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7842 */     if (!ext.contains("GL_ARB_tessellation_shader")) {
/* 7843 */       return false;
/*      */     }
/*      */     
/* 7846 */     return (Checks.checkFunctions(provider, caps, new int[] { 757, 758 }, new String[] { "glPatchParameteri", "glPatchParameterfv"
/*      */ 
/*      */ 
/*      */         
/* 7850 */         }) || Checks.reportMissing("GL", "GL_ARB_tessellation_shader"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_texture_barrier(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7854 */     if (!ext.contains("GL_ARB_texture_barrier")) {
/* 7855 */       return false;
/*      */     }
/*      */     
/* 7858 */     return (Checks.checkFunctions(provider, caps, new int[] { 1023 }, new String[] { "glTextureBarrier"
/*      */ 
/*      */ 
/*      */         
/* 7862 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_barrier"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_texture_buffer_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7866 */     if (!ext.contains("GL_ARB_texture_buffer_object")) {
/* 7867 */       return false;
/*      */     }
/*      */     
/* 7870 */     return (Checks.checkFunctions(provider, caps, new int[] { 1366 }, new String[] { "glTexBufferARB"
/*      */ 
/*      */ 
/*      */         
/* 7874 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_buffer_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_texture_buffer_range(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7878 */     if (!ext.contains("GL_ARB_texture_buffer_range")) {
/* 7879 */       return false;
/*      */     }
/*      */     
/* 7882 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7884 */       Checks.checkFunctions(provider, caps, new int[] { 903, flag0 + 1367 }, new String[] { "glTexBufferRange", "glTextureBufferRangeEXT"
/*      */ 
/*      */ 
/*      */         
/* 7888 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_buffer_range"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_texture_compression(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7892 */     if (!ext.contains("GL_ARB_texture_compression")) {
/* 7893 */       return false;
/*      */     }
/*      */     
/* 7896 */     return (Checks.checkFunctions(provider, caps, new int[] { 1368, 1369, 1370, 1371, 1372, 1373, 1374 }, new String[] { "glCompressedTexImage3DARB", "glCompressedTexImage2DARB", "glCompressedTexImage1DARB", "glCompressedTexSubImage3DARB", "glCompressedTexSubImage2DARB", "glCompressedTexSubImage1DARB", "glGetCompressedTexImageARB"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7901 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_compression"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_texture_multisample(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7905 */     if (!ext.contains("GL_ARB_texture_multisample")) {
/* 7906 */       return false;
/*      */     }
/*      */     
/* 7909 */     return (Checks.checkFunctions(provider, caps, new int[] { 653, 654, 655, 656 }, new String[] { "glTexImage2DMultisample", "glTexImage3DMultisample", "glGetMultisamplefv", "glSampleMaski"
/*      */ 
/*      */ 
/*      */         
/* 7913 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_multisample"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_texture_storage(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7917 */     if (!ext.contains("GL_ARB_texture_storage")) {
/* 7918 */       return false;
/*      */     }
/*      */     
/* 7921 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7923 */       Checks.checkFunctions(provider, caps, new int[] { 859, 860, 861, flag0 + 1375, flag0 + 1376, flag0 + 1377 }, new String[] { "glTexStorage1D", "glTexStorage2D", "glTexStorage3D", "glTextureStorage1DEXT", "glTextureStorage2DEXT", "glTextureStorage3DEXT"
/*      */ 
/*      */ 
/*      */         
/* 7927 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_storage"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_texture_storage_multisample(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7931 */     if (!ext.contains("GL_ARB_texture_storage_multisample")) {
/* 7932 */       return false;
/*      */     }
/*      */     
/* 7935 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 7937 */       Checks.checkFunctions(provider, caps, new int[] { 904, 905, flag0 + 1378, flag0 + 1379 }, new String[] { "glTexStorage2DMultisample", "glTexStorage3DMultisample", "glTextureStorage2DMultisampleEXT", "glTextureStorage3DMultisampleEXT"
/*      */ 
/*      */ 
/*      */         
/* 7941 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_storage_multisample"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_texture_view(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7945 */     if (!ext.contains("GL_ARB_texture_view")) {
/* 7946 */       return false;
/*      */     }
/*      */     
/* 7949 */     return (Checks.checkFunctions(provider, caps, new int[] { 906 }, new String[] { "glTextureView"
/*      */ 
/*      */ 
/*      */         
/* 7953 */         }) || Checks.reportMissing("GL", "GL_ARB_texture_view"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_timer_query(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7957 */     if (!ext.contains("GL_ARB_timer_query")) {
/* 7958 */       return false;
/*      */     }
/*      */     
/* 7961 */     return (Checks.checkFunctions(provider, caps, new int[] { 682, 683, 684 }, new String[] { "glQueryCounter", "glGetQueryObjecti64v", "glGetQueryObjectui64v"
/*      */ 
/*      */ 
/*      */         
/* 7965 */         }) || Checks.reportMissing("GL", "GL_ARB_timer_query"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_transform_feedback2(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7969 */     if (!ext.contains("GL_ARB_transform_feedback2")) {
/* 7970 */       return false;
/*      */     }
/*      */     
/* 7973 */     return (Checks.checkFunctions(provider, caps, new int[] { 759, 760, 761, 762, 763, 764, 765 }, new String[] { "glBindTransformFeedback", "glDeleteTransformFeedbacks", "glGenTransformFeedbacks", "glIsTransformFeedback", "glPauseTransformFeedback", "glResumeTransformFeedback", "glDrawTransformFeedback"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7978 */         }) || Checks.reportMissing("GL", "GL_ARB_transform_feedback2"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_transform_feedback3(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7982 */     if (!ext.contains("GL_ARB_transform_feedback3")) {
/* 7983 */       return false;
/*      */     }
/*      */     
/* 7986 */     return (Checks.checkFunctions(provider, caps, new int[] { 766, 767, 768, 769 }, new String[] { "glDrawTransformFeedbackStream", "glBeginQueryIndexed", "glEndQueryIndexed", "glGetQueryIndexediv"
/*      */ 
/*      */ 
/*      */         
/* 7990 */         }) || Checks.reportMissing("GL", "GL_ARB_transform_feedback3"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_transform_feedback_instanced(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 7994 */     if (!ext.contains("GL_ARB_transform_feedback_instanced")) {
/* 7995 */       return false;
/*      */     }
/*      */     
/* 7998 */     return (Checks.checkFunctions(provider, caps, new int[] { 862, 863 }, new String[] { "glDrawTransformFeedbackInstanced", "glDrawTransformFeedbackStreamInstanced"
/*      */ 
/*      */ 
/*      */         
/* 8002 */         }) || Checks.reportMissing("GL", "GL_ARB_transform_feedback_instanced"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_transpose_matrix(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8006 */     if (!ext.contains("GL_ARB_transpose_matrix")) {
/* 8007 */       return false;
/*      */     }
/*      */     
/* 8010 */     return (Checks.checkFunctions(provider, caps, new int[] { 1380, 1381, 1382, 1383 }, new String[] { "glLoadTransposeMatrixfARB", "glLoadTransposeMatrixdARB", "glMultTransposeMatrixfARB", "glMultTransposeMatrixdARB"
/*      */ 
/*      */ 
/*      */         
/* 8014 */         }) || Checks.reportMissing("GL", "GL_ARB_transpose_matrix"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_uniform_buffer_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8018 */     if (!ext.contains("GL_ARB_uniform_buffer_object")) {
/* 8019 */       return false;
/*      */     }
/*      */     
/* 8022 */     return (Checks.checkFunctions(provider, caps, new int[] { 640, 641, 642, 643, 644, 645, 625, 626, 621, 646 }, new String[] { "glGetUniformIndices", "glGetActiveUniformsiv", "glGetActiveUniformName", "glGetUniformBlockIndex", "glGetActiveUniformBlockiv", "glGetActiveUniformBlockName", "glBindBufferRange", "glBindBufferBase", "glGetIntegeri_v", "glUniformBlockBinding"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8027 */         }) || Checks.reportMissing("GL", "GL_ARB_uniform_buffer_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_vertex_array_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8031 */     if (!ext.contains("GL_ARB_vertex_array_object")) {
/* 8032 */       return false;
/*      */     }
/*      */     
/* 8035 */     return (Checks.checkFunctions(provider, caps, new int[] { 631, 632, 633, 634 }, new String[] { "glBindVertexArray", "glDeleteVertexArrays", "glGenVertexArrays", "glIsVertexArray"
/*      */ 
/*      */ 
/*      */         
/* 8039 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_array_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_vertex_attrib_64bit(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8043 */     if (!ext.contains("GL_ARB_vertex_attrib_64bit")) {
/* 8044 */       return false;
/*      */     }
/*      */     
/* 8047 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 8049 */       Checks.checkFunctions(provider, caps, new int[] { 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, flag0 + 1384 }, new String[] { "glVertexAttribL1d", "glVertexAttribL2d", "glVertexAttribL3d", "glVertexAttribL4d", "glVertexAttribL1dv", "glVertexAttribL2dv", "glVertexAttribL3dv", "glVertexAttribL4dv", "glVertexAttribLPointer", "glGetVertexAttribLdv", "glVertexArrayVertexAttribLOffsetEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8054 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_attrib_64bit"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_vertex_attrib_binding(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8058 */     if (!ext.contains("GL_ARB_vertex_attrib_binding")) {
/* 8059 */       return false;
/*      */     }
/*      */     
/* 8062 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 8064 */       Checks.checkFunctions(provider, caps, new int[] { 907, 908, 909, 910, 911, 912, flag0 + 1385, flag0 + 1386, flag0 + 1387, flag0 + 1388, flag0 + 1389, flag0 + 1390 }, new String[] { "glBindVertexBuffer", "glVertexAttribFormat", "glVertexAttribIFormat", "glVertexAttribLFormat", "glVertexAttribBinding", "glVertexBindingDivisor", "glVertexArrayBindVertexBufferEXT", "glVertexArrayVertexAttribFormatEXT", "glVertexArrayVertexAttribIFormatEXT", "glVertexArrayVertexAttribLFormatEXT", "glVertexArrayVertexAttribBindingEXT", "glVertexArrayVertexBindingDivisorEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8070 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_attrib_binding"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_vertex_blend(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8074 */     if (!ext.contains("GL_ARB_vertex_blend")) {
/* 8075 */       return false;
/*      */     }
/*      */     
/* 8078 */     return (Checks.checkFunctions(provider, caps, new int[] { 1391, 1392, 1393, 1394, 1395, 1396, 1397, 1398, 1399, 1400 }, new String[] { "glWeightfvARB", "glWeightbvARB", "glWeightubvARB", "glWeightsvARB", "glWeightusvARB", "glWeightivARB", "glWeightuivARB", "glWeightdvARB", "glWeightPointerARB", "glVertexBlendARB"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8083 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_blend"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_vertex_buffer_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8087 */     if (!ext.contains("GL_ARB_vertex_buffer_object")) {
/* 8088 */       return false;
/*      */     }
/*      */     
/* 8091 */     return (Checks.checkFunctions(provider, caps, new int[] { 1401, 1402, 1403, 1404, 1405, 1406, 1407, 1408, 1409, 1410, 1411 }, new String[] { "glBindBufferARB", "glDeleteBuffersARB", "glGenBuffersARB", "glIsBufferARB", "glBufferDataARB", "glBufferSubDataARB", "glGetBufferSubDataARB", "glMapBufferARB", "glUnmapBufferARB", "glGetBufferParameterivARB", "glGetBufferPointervARB"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8096 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_buffer_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_vertex_program(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8100 */     if (!ext.contains("GL_ARB_vertex_program")) {
/* 8101 */       return false;
/*      */     }
/*      */     
/* 8104 */     return (Checks.checkFunctions(provider, caps, new int[] { 1412, 1413, 1414, 1415, 1416, 1417, 1418, 1419, 1420, 1421, 1422, 1423, 1424, 1425, 1426, 1427, 1428, 1429, 1430, 1431, 1432, 1433, 1434, 1435, 1436, 1437, 1438, 1439, 1440, 1441, 1442, 1443, 1444, 1445, 1446, 1447, 1448, 1449, 1450, 1451, 1452, 1453, 1454, 1455, 1456, 1457, 1458, 1459, 1460, 1461, 1462, 1463, 1464, 1465, 1466, 1467, 1468, 1469, 1470, 1471, 1472, 1473 }, new String[] { "glVertexAttrib1sARB", "glVertexAttrib1fARB", "glVertexAttrib1dARB", "glVertexAttrib2sARB", "glVertexAttrib2fARB", "glVertexAttrib2dARB", "glVertexAttrib3sARB", "glVertexAttrib3fARB", "glVertexAttrib3dARB", "glVertexAttrib4sARB", "glVertexAttrib4fARB", "glVertexAttrib4dARB", "glVertexAttrib4NubARB", "glVertexAttrib1svARB", "glVertexAttrib1fvARB", "glVertexAttrib1dvARB", "glVertexAttrib2svARB", "glVertexAttrib2fvARB", "glVertexAttrib2dvARB", "glVertexAttrib3svARB", "glVertexAttrib3fvARB", "glVertexAttrib3dvARB", "glVertexAttrib4fvARB", "glVertexAttrib4bvARB", "glVertexAttrib4svARB", "glVertexAttrib4ivARB", "glVertexAttrib4ubvARB", "glVertexAttrib4usvARB", "glVertexAttrib4uivARB", "glVertexAttrib4dvARB", "glVertexAttrib4NbvARB", "glVertexAttrib4NsvARB", "glVertexAttrib4NivARB", "glVertexAttrib4NubvARB", "glVertexAttrib4NusvARB", "glVertexAttrib4NuivARB", "glVertexAttribPointerARB", "glEnableVertexAttribArrayARB", "glDisableVertexAttribArrayARB", "glProgramStringARB", "glBindProgramARB", "glDeleteProgramsARB", "glGenProgramsARB", "glProgramEnvParameter4dARB", "glProgramEnvParameter4dvARB", "glProgramEnvParameter4fARB", "glProgramEnvParameter4fvARB", "glProgramLocalParameter4dARB", "glProgramLocalParameter4dvARB", "glProgramLocalParameter4fARB", "glProgramLocalParameter4fvARB", "glGetProgramEnvParameterfvARB", "glGetProgramEnvParameterdvARB", "glGetProgramLocalParameterfvARB", "glGetProgramLocalParameterdvARB", "glGetProgramivARB", "glGetProgramStringARB", "glGetVertexAttribfvARB", "glGetVertexAttribdvARB", "glGetVertexAttribivARB", "glGetVertexAttribPointervARB", "glIsProgramARB"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8121 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_program"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_vertex_shader(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8125 */     if (!ext.contains("GL_ARB_vertex_shader")) {
/* 8126 */       return false;
/*      */     }
/*      */     
/* 8129 */     return (Checks.checkFunctions(provider, caps, new int[] { 1413, 1412, 1414, 1416, 1415, 1417, 1419, 1418, 1420, 1422, 1421, 1423, 1424, 1426, 1425, 1427, 1429, 1428, 1430, 1432, 1431, 1433, 1434, 1436, 1441, 1437, 1435, 1438, 1439, 1440, 1442, 1443, 1444, 1445, 1446, 1447, 1448, 1449, 1450, 1474, 1475, 1476, 1471, 1469, 1470, 1472 }, new String[] { "glVertexAttrib1fARB", "glVertexAttrib1sARB", "glVertexAttrib1dARB", "glVertexAttrib2fARB", "glVertexAttrib2sARB", "glVertexAttrib2dARB", "glVertexAttrib3fARB", "glVertexAttrib3sARB", "glVertexAttrib3dARB", "glVertexAttrib4fARB", "glVertexAttrib4sARB", "glVertexAttrib4dARB", "glVertexAttrib4NubARB", "glVertexAttrib1fvARB", "glVertexAttrib1svARB", "glVertexAttrib1dvARB", "glVertexAttrib2fvARB", "glVertexAttrib2svARB", "glVertexAttrib2dvARB", "glVertexAttrib3fvARB", "glVertexAttrib3svARB", "glVertexAttrib3dvARB", "glVertexAttrib4fvARB", "glVertexAttrib4svARB", "glVertexAttrib4dvARB", "glVertexAttrib4ivARB", "glVertexAttrib4bvARB", "glVertexAttrib4ubvARB", "glVertexAttrib4usvARB", "glVertexAttrib4uivARB", "glVertexAttrib4NbvARB", "glVertexAttrib4NsvARB", "glVertexAttrib4NivARB", "glVertexAttrib4NubvARB", "glVertexAttrib4NusvARB", "glVertexAttrib4NuivARB", "glVertexAttribPointerARB", "glEnableVertexAttribArrayARB", "glDisableVertexAttribArrayARB", "glBindAttribLocationARB", "glGetActiveAttribARB", "glGetAttribLocationARB", "glGetVertexAttribivARB", "glGetVertexAttribfvARB", "glGetVertexAttribdvARB", "glGetVertexAttribPointervARB"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8142 */         }) || Checks.reportMissing("GL", "GL_ARB_vertex_shader"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_vertex_type_2_10_10_10_rev(FunctionProvider provider, PointerBuffer caps, Set<String> ext, boolean fc) {
/* 8146 */     if (!ext.contains("GL_ARB_vertex_type_2_10_10_10_rev")) {
/* 8147 */       return false;
/*      */     }
/*      */     
/* 8150 */     return (((fc || Checks.checkFunctions(provider, caps, new int[] { 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715 }, new String[] { "glVertexP2ui", "glVertexP3ui", "glVertexP4ui", "glVertexP2uiv", "glVertexP3uiv", "glVertexP4uiv", "glTexCoordP1ui", "glTexCoordP2ui", "glTexCoordP3ui", "glTexCoordP4ui", "glTexCoordP1uiv", "glTexCoordP2uiv", "glTexCoordP3uiv", "glTexCoordP4uiv", "glMultiTexCoordP1ui", "glMultiTexCoordP2ui", "glMultiTexCoordP3ui", "glMultiTexCoordP4ui", "glMultiTexCoordP1uiv", "glMultiTexCoordP2uiv", "glMultiTexCoordP3uiv", "glMultiTexCoordP4uiv", "glNormalP3ui", "glNormalP3uiv", "glColorP3ui", "glColorP4ui", "glColorP3uiv", "glColorP4uiv", "glSecondaryColorP3ui", "glSecondaryColorP3uiv"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8159 */         })) && Checks.checkFunctions(provider, caps, new int[] {
/*      */           716, 717, 718, 719, 720, 721, 722, 723 }, new String[] {
/*      */           
/*      */           "glVertexAttribP1ui", "glVertexAttribP2ui", "glVertexAttribP3ui", "glVertexAttribP4ui", "glVertexAttribP1uiv", "glVertexAttribP2uiv", "glVertexAttribP3uiv", "glVertexAttribP4uiv"
/*      */         
/* 8164 */         })) || Checks.reportMissing("GL", "GL_ARB_vertex_type_2_10_10_10_rev"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_viewport_array(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8168 */     if (!ext.contains("GL_ARB_viewport_array")) {
/* 8169 */       return false;
/*      */     }
/*      */     
/* 8172 */     return (Checks.checkFunctions(provider, caps, new int[] { 848, 849, 850, 851, 852, 853, 854, 855, 856, 857 }, new String[] { "glViewportArrayv", "glViewportIndexedf", "glViewportIndexedfv", "glScissorArrayv", "glScissorIndexed", "glScissorIndexedv", "glDepthRangeArrayv", "glDepthRangeIndexed", "glGetFloati_v", "glGetDoublei_v"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8177 */         }) || Checks.reportMissing("GL", "GL_ARB_viewport_array"));
/*      */   }
/*      */   
/*      */   private static boolean check_ARB_window_pos(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8181 */     if (!ext.contains("GL_ARB_window_pos")) {
/* 8182 */       return false;
/*      */     }
/*      */     
/* 8185 */     return (Checks.checkFunctions(provider, caps, new int[] { 1477, 1478, 1479, 1480, 1481, 1482, 1483, 1484, 1485, 1486, 1487, 1488, 1489, 1490, 1491, 1492 }, new String[] { "glWindowPos2iARB", "glWindowPos2sARB", "glWindowPos2fARB", "glWindowPos2dARB", "glWindowPos2ivARB", "glWindowPos2svARB", "glWindowPos2fvARB", "glWindowPos2dvARB", "glWindowPos3iARB", "glWindowPos3sARB", "glWindowPos3fARB", "glWindowPos3dARB", "glWindowPos3ivARB", "glWindowPos3svARB", "glWindowPos3fvARB", "glWindowPos3dvARB"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8191 */         }) || Checks.reportMissing("GL", "GL_ARB_window_pos"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_bindable_uniform(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8195 */     if (!ext.contains("GL_EXT_bindable_uniform")) {
/* 8196 */       return false;
/*      */     }
/*      */     
/* 8199 */     return (Checks.checkFunctions(provider, caps, new int[] { 1493, 1494, 1495 }, new String[] { "glUniformBufferEXT", "glGetUniformBufferSizeEXT", "glGetUniformOffsetEXT"
/*      */ 
/*      */ 
/*      */         
/* 8203 */         }) || Checks.reportMissing("GL", "GL_EXT_bindable_uniform"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_blend_color(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8207 */     if (!ext.contains("GL_EXT_blend_color")) {
/* 8208 */       return false;
/*      */     }
/*      */     
/* 8211 */     return (Checks.checkFunctions(provider, caps, new int[] { 1496 }, new String[] { "glBlendColorEXT"
/*      */ 
/*      */ 
/*      */         
/* 8215 */         }) || Checks.reportMissing("GL", "GL_EXT_blend_color"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_blend_equation_separate(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8219 */     if (!ext.contains("GL_EXT_blend_equation_separate")) {
/* 8220 */       return false;
/*      */     }
/*      */     
/* 8223 */     return (Checks.checkFunctions(provider, caps, new int[] { 1497 }, new String[] { "glBlendEquationSeparateEXT"
/*      */ 
/*      */ 
/*      */         
/* 8227 */         }) || Checks.reportMissing("GL", "GL_EXT_blend_equation_separate"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_blend_func_separate(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8231 */     if (!ext.contains("GL_EXT_blend_func_separate")) {
/* 8232 */       return false;
/*      */     }
/*      */     
/* 8235 */     return (Checks.checkFunctions(provider, caps, new int[] { 1498 }, new String[] { "glBlendFuncSeparateEXT"
/*      */ 
/*      */ 
/*      */         
/* 8239 */         }) || Checks.reportMissing("GL", "GL_EXT_blend_func_separate"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_blend_minmax(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8243 */     if (!ext.contains("GL_EXT_blend_minmax")) {
/* 8244 */       return false;
/*      */     }
/*      */     
/* 8247 */     return (Checks.checkFunctions(provider, caps, new int[] { 1499 }, new String[] { "glBlendEquationEXT"
/*      */ 
/*      */ 
/*      */         
/* 8251 */         }) || Checks.reportMissing("GL", "GL_EXT_blend_minmax"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_compiled_vertex_array(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8255 */     if (!ext.contains("GL_EXT_compiled_vertex_array")) {
/* 8256 */       return false;
/*      */     }
/*      */     
/* 8259 */     return (Checks.checkFunctions(provider, caps, new int[] { 1500, 1501 }, new String[] { "glLockArraysEXT", "glUnlockArraysEXT"
/*      */ 
/*      */ 
/*      */         
/* 8263 */         }) || Checks.reportMissing("GL", "GL_EXT_compiled_vertex_array"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_debug_label(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8267 */     if (!ext.contains("GL_EXT_debug_label")) {
/* 8268 */       return false;
/*      */     }
/*      */     
/* 8271 */     return (Checks.checkFunctions(provider, caps, new int[] { 1502, 1503 }, new String[] { "glLabelObjectEXT", "glGetObjectLabelEXT"
/*      */ 
/*      */ 
/*      */         
/* 8275 */         }) || Checks.reportMissing("GL", "GL_EXT_debug_label"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_debug_marker(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8279 */     if (!ext.contains("GL_EXT_debug_marker")) {
/* 8280 */       return false;
/*      */     }
/*      */     
/* 8283 */     return (Checks.checkFunctions(provider, caps, new int[] { 1504, 1505, 1506 }, new String[] { "glInsertEventMarkerEXT", "glPushGroupMarkerEXT", "glPopGroupMarkerEXT"
/*      */ 
/*      */ 
/*      */         
/* 8287 */         }) || Checks.reportMissing("GL", "GL_EXT_debug_marker"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_depth_bounds_test(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8291 */     if (!ext.contains("GL_EXT_depth_bounds_test")) {
/* 8292 */       return false;
/*      */     }
/*      */     
/* 8295 */     return (Checks.checkFunctions(provider, caps, new int[] { 1507 }, new String[] { "glDepthBoundsEXT"
/*      */ 
/*      */ 
/*      */         
/* 8299 */         }) || Checks.reportMissing("GL", "GL_EXT_depth_bounds_test"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_direct_state_access(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8303 */     if (!ext.contains("GL_EXT_direct_state_access")) {
/* 8304 */       return false;
/*      */     }
/*      */     
/* 8307 */     int flag0 = ext.contains("OpenGL12") ? 0 : Integer.MIN_VALUE;
/* 8308 */     int flag3 = ext.contains("OpenGL13") ? 0 : Integer.MIN_VALUE;
/* 8309 */     int flag42 = ext.contains("OpenGL30") ? 0 : Integer.MIN_VALUE;
/* 8310 */     int flag55 = ext.contains("GL_ARB_vertex_program") ? 0 : Integer.MIN_VALUE;
/* 8311 */     int flag82 = ext.contains("OpenGL15") ? 0 : Integer.MIN_VALUE;
/* 8312 */     int flag88 = ext.contains("OpenGL20") ? 0 : Integer.MIN_VALUE;
/* 8313 */     int flag107 = ext.contains("OpenGL21") ? 0 : Integer.MIN_VALUE;
/* 8314 */     int flag113 = ext.contains("GL_EXT_texture_buffer_object") ? 0 : Integer.MIN_VALUE;
/* 8315 */     int flag115 = ext.contains("GL_EXT_texture_integer") ? 0 : Integer.MIN_VALUE;
/* 8316 */     int flag123 = ext.contains("GL_EXT_gpu_shader4") ? 0 : Integer.MIN_VALUE;
/* 8317 */     int flag131 = ext.contains("GL_EXT_gpu_program_parameters") ? 0 : Integer.MIN_VALUE;
/* 8318 */     int flag132 = ext.contains("GL_NV_gpu_program4") ? 0 : Integer.MIN_VALUE;
/* 8319 */     int flag143 = ext.contains("GL_NV_framebuffer_multisample_coverage") ? 0 : Integer.MIN_VALUE;
/* 8320 */     int flag157 = (ext.contains("GL_EXT_geometry_shader4") || ext.contains("GL_NV_gpu_program4")) ? 0 : Integer.MIN_VALUE;
/* 8321 */     int flag160 = ext.contains("GL_NV_explicit_multisample") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 8323 */       Checks.checkFunctions(provider, caps, new int[] { 1508, 1509, 1510, 1511, 1512, 1513, 1514, 1515, 1516, 1517, 1518, 1519, 1520, 1521, 1522, 1523, 1524, 1525, 1526, 1527, 1528, 1529, 1530, 1531, 1532, 1533, 1534, 1535, 1536, 1537, 1538, 1539, 1540, 1541, flag0 + 1542, flag0 + 1543, flag0 + 1544, flag3 + 1545, flag3 + 1546, flag3 + 1547, flag3 + 1548, flag3 + 1549, flag3 + 1550, flag3 + 1551, flag3 + 1552, flag3 + 1553, flag3 + 1554, flag3 + 1555, flag3 + 1556, flag3 + 1557, flag3 + 1558, flag3 + 1559, flag3 + 1560, flag3 + 1561, flag3 + 1562, flag3 + 1563, flag3 + 1564, flag3 + 1565, flag3 + 1566, flag3 + 1567, flag3 + 1568, flag3 + 1569, flag3 + 1570, flag3 + 1571, flag3 + 1572, flag3 + 1573, flag3 + 1574, flag3 + 1575, flag3 + 1576, flag3 + 1577, flag3 + 1578, flag3 + 1579, flag3 + 1580, flag3 + 1581, flag3 + 1582, flag3 + 1583, flag3 + 1586, flag3 + 1587, flag3 + 1588, flag3 + 1592, flag3 + 1593, flag3 + 1594, flag3 + 1595, flag3 + 1596, flag55 + 1597, flag55 + 1598, flag55 + 1599, flag55 + 1600, flag55 + 1601, flag55 + 1602, flag55 + 1603, flag55 + 1604, flag55 + 1605, flag3 + 1606, flag3 + 1607, flag3 + 1608, flag3 + 1609, flag3 + 1610, flag3 + 1611, flag3 + 1612, flag3 + 1613, flag3 + 1614, flag3 + 1615, flag3 + 1616, flag3 + 1617, flag3 + 1618, flag3 + 1619, flag3 + 1620, flag3 + 1621, flag3 + 1622, flag3 + 1623, flag82 + 1624, flag82 + 1625, flag82 + 1626, flag82 + 1627, flag82 + 1628, flag82 + 1629, flag88 + 1630, flag88 + 1631, flag88 + 1632, flag88 + 1633, flag88 + 1634, flag88 + 1635, flag88 + 1636, flag88 + 1637, flag88 + 1638, flag88 + 1639, flag88 + 1640, flag88 + 1641, flag88 + 1642, flag88 + 1643, flag88 + 1644, flag88 + 1645, flag88 + 1646, flag88 + 1647, flag88 + 1648, flag107 + 1649, flag107 + 1650, flag107 + 1651, flag107 + 1652, flag107 + 1653, flag107 + 1654, flag113 + 1655, flag113 + 1656, flag115 + 1657, flag115 + 1658, flag115 + 1659, flag115 + 1660, flag115 + 1661, flag115 + 1662, flag115 + 1663, flag115 + 1664, flag123 + 1665, flag123 + 1666, flag123 + 1667, flag123 + 1668, flag123 + 1669, flag123 + 1670, flag123 + 1671, flag123 + 1672, flag131 + 1673, flag132 + 1674, flag132 + 1675, flag132 + 1676, flag132 + 1677, flag132 + 1678, flag132 + 1679, flag132 + 1680, flag132 + 1681, flag42 + 1682, flag42 + 1683, flag42 + 1684, flag143 + 1685, flag42 + 1686, flag42 + 1687, flag42 + 1688, flag42 + 1689, flag42 + 1690, flag42 + 1691, flag42 + 1692, flag42 + 1693, flag42 + 1694, flag42 + 1695, flag42 + 1696, flag42 + 1697, flag42 + 1698, flag157 + 1699, flag157 + 1700, flag157 + 1701, flag160 + 1702, flag160 + 1703, flag42 + 1704, flag42 + 1705, flag42 + 1706, flag42 + 1707, flag42 + 1708, flag42 + 1709, flag42 + 1710, flag42 + 1711, flag42 + 1712, flag42 + 1713, flag42 + 1714, flag42 + 1715, flag42 + 1716, flag42 + 1717, flag42 + 1718, flag42 + 1719, flag42 + 1720, flag42 + 1721, flag42 + 1722, flag42 + 1723, flag42 + 1724 }, new String[] { "glClientAttribDefaultEXT", "glPushClientAttribDefaultEXT", "glMatrixLoadfEXT", "glMatrixLoaddEXT", "glMatrixMultfEXT", "glMatrixMultdEXT", "glMatrixLoadIdentityEXT", "glMatrixRotatefEXT", "glMatrixRotatedEXT", "glMatrixScalefEXT", "glMatrixScaledEXT", "glMatrixTranslatefEXT", "glMatrixTranslatedEXT", "glMatrixOrthoEXT", "glMatrixFrustumEXT", "glMatrixPushEXT", "glMatrixPopEXT", "glTextureParameteriEXT", "glTextureParameterivEXT", "glTextureParameterfEXT", "glTextureParameterfvEXT", "glTextureImage1DEXT", "glTextureImage2DEXT", "glTextureSubImage1DEXT", "glTextureSubImage2DEXT", "glCopyTextureImage1DEXT", "glCopyTextureImage2DEXT", "glCopyTextureSubImage1DEXT", "glCopyTextureSubImage2DEXT", "glGetTextureImageEXT", "glGetTextureParameterfvEXT", "glGetTextureParameterivEXT", "glGetTextureLevelParameterfvEXT", "glGetTextureLevelParameterivEXT", "glTextureImage3DEXT", "glTextureSubImage3DEXT", "glCopyTextureSubImage3DEXT", "glBindMultiTextureEXT", "glMultiTexCoordPointerEXT", "glMultiTexEnvfEXT", "glMultiTexEnvfvEXT", "glMultiTexEnviEXT", "glMultiTexEnvivEXT", "glMultiTexGendEXT", "glMultiTexGendvEXT", "glMultiTexGenfEXT", "glMultiTexGenfvEXT", "glMultiTexGeniEXT", "glMultiTexGenivEXT", "glGetMultiTexEnvfvEXT", "glGetMultiTexEnvivEXT", "glGetMultiTexGendvEXT", "glGetMultiTexGenfvEXT", "glGetMultiTexGenivEXT", "glMultiTexParameteriEXT", "glMultiTexParameterivEXT", "glMultiTexParameterfEXT", "glMultiTexParameterfvEXT", "glMultiTexImage1DEXT", "glMultiTexImage2DEXT", "glMultiTexSubImage1DEXT", "glMultiTexSubImage2DEXT", "glCopyMultiTexImage1DEXT", "glCopyMultiTexImage2DEXT", "glCopyMultiTexSubImage1DEXT", "glCopyMultiTexSubImage2DEXT", "glGetMultiTexImageEXT", "glGetMultiTexParameterfvEXT", "glGetMultiTexParameterivEXT", "glGetMultiTexLevelParameterfvEXT", "glGetMultiTexLevelParameterivEXT", "glMultiTexImage3DEXT", "glMultiTexSubImage3DEXT", "glCopyMultiTexSubImage3DEXT", "glEnableClientStateIndexedEXT", "glDisableClientStateIndexedEXT", "glGetFloatIndexedvEXT", "glGetDoubleIndexedvEXT", "glGetPointerIndexedvEXT", "glEnableIndexedEXT", "glDisableIndexedEXT", "glIsEnabledIndexedEXT", "glGetIntegerIndexedvEXT", "glGetBooleanIndexedvEXT", "glNamedProgramStringEXT", "glNamedProgramLocalParameter4dEXT", "glNamedProgramLocalParameter4dvEXT", "glNamedProgramLocalParameter4fEXT", "glNamedProgramLocalParameter4fvEXT", "glGetNamedProgramLocalParameterdvEXT", "glGetNamedProgramLocalParameterfvEXT", "glGetNamedProgramivEXT", "glGetNamedProgramStringEXT", "glCompressedTextureImage3DEXT", "glCompressedTextureImage2DEXT", "glCompressedTextureImage1DEXT", "glCompressedTextureSubImage3DEXT", "glCompressedTextureSubImage2DEXT", "glCompressedTextureSubImage1DEXT", "glGetCompressedTextureImageEXT", "glCompressedMultiTexImage3DEXT", "glCompressedMultiTexImage2DEXT", "glCompressedMultiTexImage1DEXT", "glCompressedMultiTexSubImage3DEXT", "glCompressedMultiTexSubImage2DEXT", "glCompressedMultiTexSubImage1DEXT", "glGetCompressedMultiTexImageEXT", "glMatrixLoadTransposefEXT", "glMatrixLoadTransposedEXT", "glMatrixMultTransposefEXT", "glMatrixMultTransposedEXT", "glNamedBufferDataEXT", "glNamedBufferSubDataEXT", "glMapNamedBufferEXT", "glUnmapNamedBufferEXT", "glGetNamedBufferParameterivEXT", "glGetNamedBufferSubDataEXT", "glProgramUniform1fEXT", "glProgramUniform2fEXT", "glProgramUniform3fEXT", "glProgramUniform4fEXT", "glProgramUniform1iEXT", "glProgramUniform2iEXT", "glProgramUniform3iEXT", "glProgramUniform4iEXT", "glProgramUniform1fvEXT", "glProgramUniform2fvEXT", "glProgramUniform3fvEXT", "glProgramUniform4fvEXT", "glProgramUniform1ivEXT", "glProgramUniform2ivEXT", "glProgramUniform3ivEXT", "glProgramUniform4ivEXT", "glProgramUniformMatrix2fvEXT", "glProgramUniformMatrix3fvEXT", "glProgramUniformMatrix4fvEXT", "glProgramUniformMatrix2x3fvEXT", "glProgramUniformMatrix3x2fvEXT", "glProgramUniformMatrix2x4fvEXT", "glProgramUniformMatrix4x2fvEXT", "glProgramUniformMatrix3x4fvEXT", "glProgramUniformMatrix4x3fvEXT", "glTextureBufferEXT", "glMultiTexBufferEXT", "glTextureParameterIivEXT", "glTextureParameterIuivEXT", "glGetTextureParameterIivEXT", "glGetTextureParameterIuivEXT", "glMultiTexParameterIivEXT", "glMultiTexParameterIuivEXT", "glGetMultiTexParameterIivEXT", "glGetMultiTexParameterIuivEXT", "glProgramUniform1uiEXT", "glProgramUniform2uiEXT", "glProgramUniform3uiEXT", "glProgramUniform4uiEXT", "glProgramUniform1uivEXT", "glProgramUniform2uivEXT", "glProgramUniform3uivEXT", "glProgramUniform4uivEXT", "glNamedProgramLocalParameters4fvEXT", "glNamedProgramLocalParameterI4iEXT", "glNamedProgramLocalParameterI4ivEXT", "glNamedProgramLocalParametersI4ivEXT", "glNamedProgramLocalParameterI4uiEXT", "glNamedProgramLocalParameterI4uivEXT", "glNamedProgramLocalParametersI4uivEXT", "glGetNamedProgramLocalParameterIivEXT", "glGetNamedProgramLocalParameterIuivEXT", "glNamedRenderbufferStorageEXT", "glGetNamedRenderbufferParameterivEXT", "glNamedRenderbufferStorageMultisampleEXT", "glNamedRenderbufferStorageMultisampleCoverageEXT", "glCheckNamedFramebufferStatusEXT", "glNamedFramebufferTexture1DEXT", "glNamedFramebufferTexture2DEXT", "glNamedFramebufferTexture3DEXT", "glNamedFramebufferRenderbufferEXT", "glGetNamedFramebufferAttachmentParameterivEXT", "glGenerateTextureMipmapEXT", "glGenerateMultiTexMipmapEXT", "glFramebufferDrawBufferEXT", "glFramebufferDrawBuffersEXT", "glFramebufferReadBufferEXT", "glGetFramebufferParameterivEXT", "glNamedCopyBufferSubDataEXT", "glNamedFramebufferTextureEXT", "glNamedFramebufferTextureLayerEXT", "glNamedFramebufferTextureFaceEXT", "glTextureRenderbufferEXT", "glMultiTexRenderbufferEXT", "glVertexArrayVertexOffsetEXT", "glVertexArrayColorOffsetEXT", "glVertexArrayEdgeFlagOffsetEXT", "glVertexArrayIndexOffsetEXT", "glVertexArrayNormalOffsetEXT", "glVertexArrayTexCoordOffsetEXT", "glVertexArrayMultiTexCoordOffsetEXT", "glVertexArrayFogCoordOffsetEXT", "glVertexArraySecondaryColorOffsetEXT", "glVertexArrayVertexAttribOffsetEXT", "glVertexArrayVertexAttribIOffsetEXT", "glEnableVertexArrayEXT", "glDisableVertexArrayEXT", "glEnableVertexArrayAttribEXT", "glDisableVertexArrayAttribEXT", "glGetVertexArrayIntegervEXT", "glGetVertexArrayPointervEXT", "glGetVertexArrayIntegeri_vEXT", "glGetVertexArrayPointeri_vEXT", "glMapNamedBufferRangeEXT", "glFlushMappedNamedBufferRangeEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8394 */         }) || Checks.reportMissing("GL", "GL_EXT_direct_state_access"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_draw_buffers2(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8398 */     if (!ext.contains("GL_EXT_draw_buffers2")) {
/* 8399 */       return false;
/*      */     }
/*      */     
/* 8402 */     return (Checks.checkFunctions(provider, caps, new int[] { 1725, 1596, 1595, 1592, 1593, 1594 }, new String[] { "glColorMaskIndexedEXT", "glGetBooleanIndexedvEXT", "glGetIntegerIndexedvEXT", "glEnableIndexedEXT", "glDisableIndexedEXT", "glIsEnabledIndexedEXT"
/*      */ 
/*      */ 
/*      */         
/* 8406 */         }) || Checks.reportMissing("GL", "GL_EXT_draw_buffers2"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_draw_instanced(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8410 */     if (!ext.contains("GL_EXT_draw_instanced")) {
/* 8411 */       return false;
/*      */     }
/*      */     
/* 8414 */     return (Checks.checkFunctions(provider, caps, new int[] { 1726, 1727 }, new String[] { "glDrawArraysInstancedEXT", "glDrawElementsInstancedEXT"
/*      */ 
/*      */ 
/*      */         
/* 8418 */         }) || Checks.reportMissing("GL", "GL_EXT_draw_instanced"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_EGL_image_storage(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8422 */     if (!ext.contains("GL_EXT_EGL_image_storage")) {
/* 8423 */       return false;
/*      */     }
/*      */     
/* 8426 */     int flag0 = hasDSA(ext) ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 8428 */       Checks.checkFunctions(provider, caps, new int[] { 1728, flag0 + 1729 }, new String[] { "glEGLImageTargetTexStorageEXT", "glEGLImageTargetTextureStorageEXT"
/*      */ 
/*      */ 
/*      */         
/* 8432 */         }) || Checks.reportMissing("GL", "GL_EXT_EGL_image_storage"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_external_buffer(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8436 */     if (!ext.contains("GL_EXT_external_buffer")) {
/* 8437 */       return false;
/*      */     }
/*      */     
/* 8440 */     int flag0 = hasDSA(ext) ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 8442 */       Checks.checkFunctions(provider, caps, new int[] { 1730, flag0 + 1731 }, new String[] { "glBufferStorageExternalEXT", "glNamedBufferStorageExternalEXT"
/*      */ 
/*      */ 
/*      */         
/* 8446 */         }) || Checks.reportMissing("GL", "GL_EXT_external_buffer"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_fragment_shading_rate(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8450 */     if (!ext.contains("GL_EXT_fragment_shading_rate")) {
/* 8451 */       return false;
/*      */     }
/*      */     
/* 8454 */     return (Checks.checkFunctions(provider, caps, new int[] { 1732, 1733, 1734, 1735 }, new String[] { "glShadingRateEXT", "glShadingRateCombinerOpsEXT", "glFramebufferShadingRateEXT", "glGetFragmentShadingRatesEXT"
/*      */ 
/*      */ 
/*      */         
/* 8458 */         }) || Checks.reportMissing("GL", "GL_EXT_fragment_shading_rate"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_framebuffer_blit(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8462 */     if (!ext.contains("GL_EXT_framebuffer_blit")) {
/* 8463 */       return false;
/*      */     }
/*      */     
/* 8466 */     return (Checks.checkFunctions(provider, caps, new int[] { 1736 }, new String[] { "glBlitFramebufferEXT"
/*      */ 
/*      */ 
/*      */         
/* 8470 */         }) || Checks.reportMissing("GL", "GL_EXT_framebuffer_blit"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_framebuffer_blit_layers(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8474 */     if (!ext.contains("GL_EXT_framebuffer_blit_layers")) {
/* 8475 */       return false;
/*      */     }
/*      */     
/* 8478 */     return (Checks.checkFunctions(provider, caps, new int[] { 1737, 1738 }, new String[] { "glBlitFramebufferLayersEXT", "glBlitFramebufferLayerEXT"
/*      */ 
/*      */ 
/*      */         
/* 8482 */         }) || Checks.reportMissing("GL", "GL_EXT_framebuffer_blit_layers"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_framebuffer_multisample(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8486 */     if (!ext.contains("GL_EXT_framebuffer_multisample")) {
/* 8487 */       return false;
/*      */     }
/*      */     
/* 8490 */     return (Checks.checkFunctions(provider, caps, new int[] { 1739 }, new String[] { "glRenderbufferStorageMultisampleEXT"
/*      */ 
/*      */ 
/*      */         
/* 8494 */         }) || Checks.reportMissing("GL", "GL_EXT_framebuffer_multisample"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_framebuffer_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8498 */     if (!ext.contains("GL_EXT_framebuffer_object")) {
/* 8499 */       return false;
/*      */     }
/*      */     
/* 8502 */     return (Checks.checkFunctions(provider, caps, new int[] { 1740, 1741, 1742, 1743, 1744, 1745, 1746, 1747, 1748, 1749, 1750, 1751, 1752, 1753, 1754, 1755, 1756 }, new String[] { "glIsRenderbufferEXT", "glBindRenderbufferEXT", "glDeleteRenderbuffersEXT", "glGenRenderbuffersEXT", "glRenderbufferStorageEXT", "glGetRenderbufferParameterivEXT", "glIsFramebufferEXT", "glBindFramebufferEXT", "glDeleteFramebuffersEXT", "glGenFramebuffersEXT", "glCheckFramebufferStatusEXT", "glFramebufferTexture1DEXT", "glFramebufferTexture2DEXT", "glFramebufferTexture3DEXT", "glFramebufferRenderbufferEXT", "glGetFramebufferAttachmentParameterivEXT", "glGenerateMipmapEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8509 */         }) || Checks.reportMissing("GL", "GL_EXT_framebuffer_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_geometry_shader4(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8513 */     if (!ext.contains("GL_EXT_geometry_shader4")) {
/* 8514 */       return false;
/*      */     }
/*      */     
/* 8517 */     return (Checks.checkFunctions(provider, caps, new int[] { 1757, 1758, 1759, 1760 }, new String[] { "glProgramParameteriEXT", "glFramebufferTextureEXT", "glFramebufferTextureLayerEXT", "glFramebufferTextureFaceEXT"
/*      */ 
/*      */ 
/*      */         
/* 8521 */         }) || Checks.reportMissing("GL", "GL_EXT_geometry_shader4"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_gpu_program_parameters(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8525 */     if (!ext.contains("GL_EXT_gpu_program_parameters")) {
/* 8526 */       return false;
/*      */     }
/*      */     
/* 8529 */     return (Checks.checkFunctions(provider, caps, new int[] { 1761, 1762 }, new String[] { "glProgramEnvParameters4fvEXT", "glProgramLocalParameters4fvEXT"
/*      */ 
/*      */ 
/*      */         
/* 8533 */         }) || Checks.reportMissing("GL", "GL_EXT_gpu_program_parameters"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_gpu_shader4(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8537 */     if (!ext.contains("GL_EXT_gpu_shader4")) {
/* 8538 */       return false;
/*      */     }
/*      */     
/* 8541 */     return (Checks.checkFunctions(provider, caps, new int[] { 1763, 1764, 1765, 1766, 1767, 1768, 1769, 1770, 1771, 1772, 1773, 1774, 1775, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785, 1786, 1787, 1788, 1789, 1790, 1791, 1792, 1793, 1794, 1795, 1796 }, new String[] { "glVertexAttribI1iEXT", "glVertexAttribI2iEXT", "glVertexAttribI3iEXT", "glVertexAttribI4iEXT", "glVertexAttribI1uiEXT", "glVertexAttribI2uiEXT", "glVertexAttribI3uiEXT", "glVertexAttribI4uiEXT", "glVertexAttribI1ivEXT", "glVertexAttribI2ivEXT", "glVertexAttribI3ivEXT", "glVertexAttribI4ivEXT", "glVertexAttribI1uivEXT", "glVertexAttribI2uivEXT", "glVertexAttribI3uivEXT", "glVertexAttribI4uivEXT", "glVertexAttribI4bvEXT", "glVertexAttribI4svEXT", "glVertexAttribI4ubvEXT", "glVertexAttribI4usvEXT", "glVertexAttribIPointerEXT", "glGetVertexAttribIivEXT", "glGetVertexAttribIuivEXT", "glGetUniformuivEXT", "glBindFragDataLocationEXT", "glGetFragDataLocationEXT", "glUniform1uiEXT", "glUniform2uiEXT", "glUniform3uiEXT", "glUniform4uiEXT", "glUniform1uivEXT", "glUniform2uivEXT", "glUniform3uivEXT", "glUniform4uivEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8552 */         }) || Checks.reportMissing("GL", "GL_EXT_gpu_shader4"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_memory_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8556 */     if (!ext.contains("GL_EXT_memory_object")) {
/* 8557 */       return false;
/*      */     }
/*      */     
/* 8560 */     int flag0 = hasDSA(ext) ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 8562 */       Checks.checkFunctions(provider, caps, new int[] { 1797, 1798, 1799, 1800, 1801, 1802, 1803, 1804, 1805, 1806, 1807, 1808, flag0 + 1809, flag0 + 1810, flag0 + 1811, flag0 + 1812, flag0 + 1813, 1814, flag0 + 1815 }, new String[] { "glGetUnsignedBytevEXT", "glGetUnsignedBytei_vEXT", "glDeleteMemoryObjectsEXT", "glIsMemoryObjectEXT", "glCreateMemoryObjectsEXT", "glMemoryObjectParameterivEXT", "glGetMemoryObjectParameterivEXT", "glTexStorageMem2DEXT", "glTexStorageMem2DMultisampleEXT", "glTexStorageMem3DEXT", "glTexStorageMem3DMultisampleEXT", "glBufferStorageMemEXT", "glTextureStorageMem2DEXT", "glTextureStorageMem2DMultisampleEXT", "glTextureStorageMem3DEXT", "glTextureStorageMem3DMultisampleEXT", "glNamedBufferStorageMemEXT", "glTexStorageMem1DEXT", "glTextureStorageMem1DEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8571 */         }) || Checks.reportMissing("GL", "GL_EXT_memory_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_memory_object_fd(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8575 */     if (!ext.contains("GL_EXT_memory_object_fd")) {
/* 8576 */       return false;
/*      */     }
/*      */     
/* 8579 */     return (Checks.checkFunctions(provider, caps, new int[] { 1816 }, new String[] { "glImportMemoryFdEXT"
/*      */ 
/*      */ 
/*      */         
/* 8583 */         }) || Checks.reportMissing("GL", "GL_EXT_memory_object_fd"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_memory_object_win32(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8587 */     if (!ext.contains("GL_EXT_memory_object_win32")) {
/* 8588 */       return false;
/*      */     }
/*      */     
/* 8591 */     return (Checks.checkFunctions(provider, caps, new int[] { 1817, 1818 }, new String[] { "glImportMemoryWin32HandleEXT", "glImportMemoryWin32NameEXT"
/*      */ 
/*      */ 
/*      */         
/* 8595 */         }) || Checks.reportMissing("GL", "GL_EXT_memory_object_win32"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_mesh_shader(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8599 */     if (!ext.contains("GL_EXT_mesh_shader")) {
/* 8600 */       return false;
/*      */     }
/*      */     
/* 8603 */     return (Checks.checkFunctions(provider, caps, new int[] { 1819, 1820, 1821, 1822 }, new String[] { "glDrawMeshTasksEXT", "glDrawMeshTasksIndirectEXT", "glMultiDrawMeshTasksIndirectEXT", "glMultiDrawMeshTasksIndirectCountEXT"
/*      */ 
/*      */ 
/*      */         
/* 8607 */         }) || Checks.reportMissing("GL", "GL_EXT_mesh_shader"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_point_parameters(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8611 */     if (!ext.contains("GL_EXT_point_parameters")) {
/* 8612 */       return false;
/*      */     }
/*      */     
/* 8615 */     return (Checks.checkFunctions(provider, caps, new int[] { 1823, 1824 }, new String[] { "glPointParameterfEXT", "glPointParameterfvEXT"
/*      */ 
/*      */ 
/*      */         
/* 8619 */         }) || Checks.reportMissing("GL", "GL_EXT_point_parameters"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_polygon_offset_clamp(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8623 */     if (!ext.contains("GL_EXT_polygon_offset_clamp")) {
/* 8624 */       return false;
/*      */     }
/*      */     
/* 8627 */     return (Checks.checkFunctions(provider, caps, new int[] { 1825 }, new String[] { "glPolygonOffsetClampEXT"
/*      */ 
/*      */ 
/*      */         
/* 8631 */         }) || Checks.reportMissing("GL", "GL_EXT_polygon_offset_clamp"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_provoking_vertex(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8635 */     if (!ext.contains("GL_EXT_provoking_vertex")) {
/* 8636 */       return false;
/*      */     }
/*      */     
/* 8639 */     return (Checks.checkFunctions(provider, caps, new int[] { 1826 }, new String[] { "glProvokingVertexEXT"
/*      */ 
/*      */ 
/*      */         
/* 8643 */         }) || Checks.reportMissing("GL", "GL_EXT_provoking_vertex"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_raster_multisample(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8647 */     if (!ext.contains("GL_EXT_raster_multisample")) {
/* 8648 */       return false;
/*      */     }
/*      */     
/* 8651 */     return (Checks.checkFunctions(provider, caps, new int[] { 1827 }, new String[] { "glRasterSamplesEXT"
/*      */ 
/*      */ 
/*      */         
/* 8655 */         }) || Checks.reportMissing("GL", "GL_EXT_raster_multisample"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_secondary_color(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8659 */     if (!ext.contains("GL_EXT_secondary_color")) {
/* 8660 */       return false;
/*      */     }
/*      */     
/* 8663 */     return (Checks.checkFunctions(provider, caps, new int[] { 1828, 1829, 1830, 1831, 1832, 1833, 1834, 1835, 1836, 1837, 1838, 1839, 1840, 1841, 1842, 1843, 1844 }, new String[] { "glSecondaryColor3bEXT", "glSecondaryColor3sEXT", "glSecondaryColor3iEXT", "glSecondaryColor3fEXT", "glSecondaryColor3dEXT", "glSecondaryColor3ubEXT", "glSecondaryColor3usEXT", "glSecondaryColor3uiEXT", "glSecondaryColor3bvEXT", "glSecondaryColor3svEXT", "glSecondaryColor3ivEXT", "glSecondaryColor3fvEXT", "glSecondaryColor3dvEXT", "glSecondaryColor3ubvEXT", "glSecondaryColor3usvEXT", "glSecondaryColor3uivEXT", "glSecondaryColorPointerEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8670 */         }) || Checks.reportMissing("GL", "GL_EXT_secondary_color"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_semaphore(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8674 */     if (!ext.contains("GL_EXT_semaphore")) {
/* 8675 */       return false;
/*      */     }
/*      */     
/* 8678 */     return (Checks.checkFunctions(provider, caps, new int[] { 1797, 1798, 1845, 1846, 1847, 1848, 1849, 1850, 1851 }, new String[] { "glGetUnsignedBytevEXT", "glGetUnsignedBytei_vEXT", "glGenSemaphoresEXT", "glDeleteSemaphoresEXT", "glIsSemaphoreEXT", "glSemaphoreParameterui64vEXT", "glGetSemaphoreParameterui64vEXT", "glWaitSemaphoreEXT", "glSignalSemaphoreEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8683 */         }) || Checks.reportMissing("GL", "GL_EXT_semaphore"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_semaphore_fd(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8687 */     if (!ext.contains("GL_EXT_semaphore_fd")) {
/* 8688 */       return false;
/*      */     }
/*      */     
/* 8691 */     return (Checks.checkFunctions(provider, caps, new int[] { 1852 }, new String[] { "glImportSemaphoreFdEXT"
/*      */ 
/*      */ 
/*      */         
/* 8695 */         }) || Checks.reportMissing("GL", "GL_EXT_semaphore_fd"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_semaphore_win32(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8699 */     if (!ext.contains("GL_EXT_semaphore_win32")) {
/* 8700 */       return false;
/*      */     }
/*      */     
/* 8703 */     return (Checks.checkFunctions(provider, caps, new int[] { 1853, 1854 }, new String[] { "glImportSemaphoreWin32HandleEXT", "glImportSemaphoreWin32NameEXT"
/*      */ 
/*      */ 
/*      */         
/* 8707 */         }) || Checks.reportMissing("GL", "GL_EXT_semaphore_win32"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_separate_shader_objects(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8711 */     if (!ext.contains("GL_EXT_separate_shader_objects")) {
/* 8712 */       return false;
/*      */     }
/*      */     
/* 8715 */     return (Checks.checkFunctions(provider, caps, new int[] { 1855, 1856, 1857 }, new String[] { "glUseShaderProgramEXT", "glActiveProgramEXT", "glCreateShaderProgramEXT"
/*      */ 
/*      */ 
/*      */         
/* 8719 */         }) || Checks.reportMissing("GL", "GL_EXT_separate_shader_objects"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_shader_framebuffer_fetch_non_coherent(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8723 */     if (!ext.contains("GL_EXT_shader_framebuffer_fetch_non_coherent")) {
/* 8724 */       return false;
/*      */     }
/*      */     
/* 8727 */     return (Checks.checkFunctions(provider, caps, new int[] { 1858 }, new String[] { "glFramebufferFetchBarrierEXT"
/*      */ 
/*      */ 
/*      */         
/* 8731 */         }) || Checks.reportMissing("GL", "GL_EXT_shader_framebuffer_fetch_non_coherent"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_shader_image_load_store(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8735 */     if (!ext.contains("GL_EXT_shader_image_load_store")) {
/* 8736 */       return false;
/*      */     }
/*      */     
/* 8739 */     return (Checks.checkFunctions(provider, caps, new int[] { 1859, 1860 }, new String[] { "glBindImageTextureEXT", "glMemoryBarrierEXT"
/*      */ 
/*      */ 
/*      */         
/* 8743 */         }) || Checks.reportMissing("GL", "GL_EXT_shader_image_load_store"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_stencil_clear_tag(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8747 */     if (!ext.contains("GL_EXT_stencil_clear_tag")) {
/* 8748 */       return false;
/*      */     }
/*      */     
/* 8751 */     return (Checks.checkFunctions(provider, caps, new int[] { 1861 }, new String[] { "glStencilClearTagEXT"
/*      */ 
/*      */ 
/*      */         
/* 8755 */         }) || Checks.reportMissing("GL", "GL_EXT_stencil_clear_tag"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_stencil_two_side(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8759 */     if (!ext.contains("GL_EXT_stencil_two_side")) {
/* 8760 */       return false;
/*      */     }
/*      */     
/* 8763 */     return (Checks.checkFunctions(provider, caps, new int[] { 1862 }, new String[] { "glActiveStencilFaceEXT"
/*      */ 
/*      */ 
/*      */         
/* 8767 */         }) || Checks.reportMissing("GL", "GL_EXT_stencil_two_side"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_texture_array(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8771 */     if (!ext.contains("GL_EXT_texture_array")) {
/* 8772 */       return false;
/*      */     }
/*      */     
/* 8775 */     return (Checks.checkFunctions(provider, caps, new int[] { 1759 }, new String[] { "glFramebufferTextureLayerEXT"
/*      */ 
/*      */ 
/*      */         
/* 8779 */         }) || Checks.reportMissing("GL", "GL_EXT_texture_array"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_texture_buffer_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8783 */     if (!ext.contains("GL_EXT_texture_buffer_object")) {
/* 8784 */       return false;
/*      */     }
/*      */     
/* 8787 */     return (Checks.checkFunctions(provider, caps, new int[] { 1863 }, new String[] { "glTexBufferEXT"
/*      */ 
/*      */ 
/*      */         
/* 8791 */         }) || Checks.reportMissing("GL", "GL_EXT_texture_buffer_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_texture_integer(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8795 */     if (!ext.contains("GL_EXT_texture_integer")) {
/* 8796 */       return false;
/*      */     }
/*      */     
/* 8799 */     return (Checks.checkFunctions(provider, caps, new int[] { 1864, 1865, 1866, 1867, 1868, 1869 }, new String[] { "glClearColorIiEXT", "glClearColorIuiEXT", "glTexParameterIivEXT", "glTexParameterIuivEXT", "glGetTexParameterIivEXT", "glGetTexParameterIuivEXT"
/*      */ 
/*      */ 
/*      */         
/* 8803 */         }) || Checks.reportMissing("GL", "GL_EXT_texture_integer"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_texture_storage(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8807 */     if (!ext.contains("GL_EXT_texture_storage")) {
/* 8808 */       return false;
/*      */     }
/*      */     
/* 8811 */     int flag0 = hasDSA(ext) ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 8813 */       Checks.checkFunctions(provider, caps, new int[] { 1870, 1871, 1872, flag0 + 1375, flag0 + 1376, flag0 + 1377 }, new String[] { "glTexStorage1DEXT", "glTexStorage2DEXT", "glTexStorage3DEXT", "glTextureStorage1DEXT", "glTextureStorage2DEXT", "glTextureStorage3DEXT"
/*      */ 
/*      */ 
/*      */         
/* 8817 */         }) || Checks.reportMissing("GL", "GL_EXT_texture_storage"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_timer_query(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8821 */     if (!ext.contains("GL_EXT_timer_query")) {
/* 8822 */       return false;
/*      */     }
/*      */     
/* 8825 */     return (Checks.checkFunctions(provider, caps, new int[] { 1873, 1874 }, new String[] { "glGetQueryObjecti64vEXT", "glGetQueryObjectui64vEXT"
/*      */ 
/*      */ 
/*      */         
/* 8829 */         }) || Checks.reportMissing("GL", "GL_EXT_timer_query"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_transform_feedback(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8833 */     if (!ext.contains("GL_EXT_transform_feedback")) {
/* 8834 */       return false;
/*      */     }
/*      */     
/* 8837 */     return (Checks.checkFunctions(provider, caps, new int[] { 1875, 1876, 1877, 1878, 1879, 1880, 1881, 1595, 1596 }, new String[] { "glBindBufferRangeEXT", "glBindBufferOffsetEXT", "glBindBufferBaseEXT", "glBeginTransformFeedbackEXT", "glEndTransformFeedbackEXT", "glTransformFeedbackVaryingsEXT", "glGetTransformFeedbackVaryingEXT", "glGetIntegerIndexedvEXT", "glGetBooleanIndexedvEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8842 */         }) || Checks.reportMissing("GL", "GL_EXT_transform_feedback"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_vertex_attrib_64bit(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8846 */     if (!ext.contains("GL_EXT_vertex_attrib_64bit")) {
/* 8847 */       return false;
/*      */     }
/*      */     
/* 8850 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 8852 */       Checks.checkFunctions(provider, caps, new int[] { 1882, 1883, 1884, 1885, 1886, 1887, 1888, 1889, 1890, 1891, flag0 + 1384 }, new String[] { "glVertexAttribL1dEXT", "glVertexAttribL2dEXT", "glVertexAttribL3dEXT", "glVertexAttribL4dEXT", "glVertexAttribL1dvEXT", "glVertexAttribL2dvEXT", "glVertexAttribL3dvEXT", "glVertexAttribL4dvEXT", "glVertexAttribLPointerEXT", "glGetVertexAttribLdvEXT", "glVertexArrayVertexAttribLOffsetEXT"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8857 */         }) || Checks.reportMissing("GL", "GL_EXT_vertex_attrib_64bit"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_win32_keyed_mutex(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8861 */     if (!ext.contains("GL_EXT_win32_keyed_mutex")) {
/* 8862 */       return false;
/*      */     }
/*      */     
/* 8865 */     return (Checks.checkFunctions(provider, caps, new int[] { 1892, 1893 }, new String[] { "glAcquireKeyedMutexWin32EXT", "glReleaseKeyedMutexWin32EXT"
/*      */ 
/*      */ 
/*      */         
/* 8869 */         }) || Checks.reportMissing("GL", "GL_EXT_win32_keyed_mutex"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_window_rectangles(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8873 */     if (!ext.contains("GL_EXT_window_rectangles")) {
/* 8874 */       return false;
/*      */     }
/*      */     
/* 8877 */     return (Checks.checkFunctions(provider, caps, new int[] { 1894 }, new String[] { "glWindowRectanglesEXT"
/*      */ 
/*      */ 
/*      */         
/* 8881 */         }) || Checks.reportMissing("GL", "GL_EXT_window_rectangles"));
/*      */   }
/*      */   
/*      */   private static boolean check_EXT_x11_sync_object(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8885 */     if (!ext.contains("GL_EXT_x11_sync_object")) {
/* 8886 */       return false;
/*      */     }
/*      */     
/* 8889 */     return (Checks.checkFunctions(provider, caps, new int[] { 1895 }, new String[] { "glImportSyncEXT"
/*      */ 
/*      */ 
/*      */         
/* 8893 */         }) || Checks.reportMissing("GL", "GL_EXT_x11_sync_object"));
/*      */   }
/*      */   
/*      */   private static boolean check_GREMEDY_frame_terminator(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8897 */     if (!ext.contains("GL_GREMEDY_frame_terminator")) {
/* 8898 */       return false;
/*      */     }
/*      */     
/* 8901 */     return (Checks.checkFunctions(provider, caps, new int[] { 1896 }, new String[] { "glFrameTerminatorGREMEDY"
/*      */ 
/*      */ 
/*      */         
/* 8905 */         }) || Checks.reportMissing("GL", "GL_GREMEDY_frame_terminator"));
/*      */   }
/*      */   
/*      */   private static boolean check_GREMEDY_string_marker(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8909 */     if (!ext.contains("GL_GREMEDY_string_marker")) {
/* 8910 */       return false;
/*      */     }
/*      */     
/* 8913 */     return (Checks.checkFunctions(provider, caps, new int[] { 1897 }, new String[] { "glStringMarkerGREMEDY"
/*      */ 
/*      */ 
/*      */         
/* 8917 */         }) || Checks.reportMissing("GL", "GL_GREMEDY_string_marker"));
/*      */   }
/*      */   
/*      */   private static boolean check_INTEL_framebuffer_CMAA(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8921 */     if (!ext.contains("GL_INTEL_framebuffer_CMAA")) {
/* 8922 */       return false;
/*      */     }
/*      */     
/* 8925 */     return (Checks.checkFunctions(provider, caps, new int[] { 1898 }, new String[] { "glApplyFramebufferAttachmentCMAAINTEL"
/*      */ 
/*      */ 
/*      */         
/* 8929 */         }) || Checks.reportMissing("GL", "GL_INTEL_framebuffer_CMAA"));
/*      */   }
/*      */   
/*      */   private static boolean check_INTEL_map_texture(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8933 */     if (!ext.contains("GL_INTEL_map_texture")) {
/* 8934 */       return false;
/*      */     }
/*      */     
/* 8937 */     return (Checks.checkFunctions(provider, caps, new int[] { 1899, 1900, 1901 }, new String[] { "glSyncTextureINTEL", "glUnmapTexture2DINTEL", "glMapTexture2DINTEL"
/*      */ 
/*      */ 
/*      */         
/* 8941 */         }) || Checks.reportMissing("GL", "GL_INTEL_map_texture"));
/*      */   }
/*      */   
/*      */   private static boolean check_INTEL_performance_query(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8945 */     if (!ext.contains("GL_INTEL_performance_query")) {
/* 8946 */       return false;
/*      */     }
/*      */     
/* 8949 */     return (Checks.checkFunctions(provider, caps, new int[] { 1902, 1903, 1904, 1905, 1906, 1907, 1908, 1909, 1910, 1911 }, new String[] { "glBeginPerfQueryINTEL", "glCreatePerfQueryINTEL", "glDeletePerfQueryINTEL", "glEndPerfQueryINTEL", "glGetFirstPerfQueryIdINTEL", "glGetNextPerfQueryIdINTEL", "glGetPerfCounterInfoINTEL", "glGetPerfQueryDataINTEL", "glGetPerfQueryIdByNameINTEL", "glGetPerfQueryInfoINTEL"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8954 */         }) || Checks.reportMissing("GL", "GL_INTEL_performance_query"));
/*      */   }
/*      */   
/*      */   private static boolean check_KHR_blend_equation_advanced(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8958 */     if (!ext.contains("GL_KHR_blend_equation_advanced")) {
/* 8959 */       return false;
/*      */     }
/*      */     
/* 8962 */     return (Checks.checkFunctions(provider, caps, new int[] { 1912 }, new String[] { "glBlendBarrierKHR"
/*      */ 
/*      */ 
/*      */         
/* 8966 */         }) || Checks.reportMissing("GL", "GL_KHR_blend_equation_advanced"));
/*      */   }
/*      */   
/*      */   private static boolean check_KHR_debug(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8970 */     if (!ext.contains("GL_KHR_debug")) {
/* 8971 */       return false;
/*      */     }
/*      */     
/* 8974 */     return (Checks.checkFunctions(provider, caps, new int[] { 875, 876, 877, 878, 879, 880, 881, 882, 883, 884 }, new String[] { "glDebugMessageControl", "glDebugMessageInsert", "glDebugMessageCallback", "glGetDebugMessageLog", "glPushDebugGroup", "glPopDebugGroup", "glObjectLabel", "glGetObjectLabel", "glObjectPtrLabel", "glGetObjectPtrLabel"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 8979 */         }) || Checks.reportMissing("GL", "GL_KHR_debug"));
/*      */   }
/*      */   
/*      */   private static boolean check_KHR_parallel_shader_compile(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8983 */     if (!ext.contains("GL_KHR_parallel_shader_compile")) {
/* 8984 */       return false;
/*      */     }
/*      */     
/* 8987 */     return (Checks.checkFunctions(provider, caps, new int[] { 1913 }, new String[] { "glMaxShaderCompilerThreadsKHR"
/*      */ 
/*      */ 
/*      */         
/* 8991 */         }) || Checks.reportMissing("GL", "GL_KHR_parallel_shader_compile"));
/*      */   }
/*      */   
/*      */   private static boolean check_KHR_robustness(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 8995 */     if (!ext.contains("GL_KHR_robustness")) {
/* 8996 */       return false;
/*      */     }
/*      */     
/* 8999 */     return (Checks.checkFunctions(provider, caps, new int[] { 1024, 1033, 1040, 1042, 1043 }, new String[] { "glGetGraphicsResetStatus", "glReadnPixels", "glGetnUniformfv", "glGetnUniformiv", "glGetnUniformuiv"
/*      */ 
/*      */ 
/*      */         
/* 9003 */         }) || Checks.reportMissing("GL", "GL_KHR_robustness"));
/*      */   }
/*      */   
/*      */   private static boolean check_MESA_framebuffer_flip_y(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9007 */     if (!ext.contains("GL_MESA_framebuffer_flip_y")) {
/* 9008 */       return false;
/*      */     }
/*      */     
/* 9011 */     return (Checks.checkFunctions(provider, caps, new int[] { 1914, 1915 }, new String[] { "glFramebufferParameteriMESA", "glGetFramebufferParameterivMESA"
/*      */ 
/*      */ 
/*      */         
/* 9015 */         }) || Checks.reportMissing("GL", "GL_MESA_framebuffer_flip_y"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_alpha_to_coverage_dither_control(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9019 */     if (!ext.contains("GL_NV_alpha_to_coverage_dither_control")) {
/* 9020 */       return false;
/*      */     }
/*      */     
/* 9023 */     return (Checks.checkFunctions(provider, caps, new int[] { 1916 }, new String[] { "glAlphaToCoverageDitherControlNV"
/*      */ 
/*      */ 
/*      */         
/* 9027 */         }) || Checks.reportMissing("GL", "GL_NV_alpha_to_coverage_dither_control"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_bindless_multi_draw_indirect(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9031 */     if (!ext.contains("GL_NV_bindless_multi_draw_indirect")) {
/* 9032 */       return false;
/*      */     }
/*      */     
/* 9035 */     return (Checks.checkFunctions(provider, caps, new int[] { 1917, 1918 }, new String[] { "glMultiDrawArraysIndirectBindlessNV", "glMultiDrawElementsIndirectBindlessNV"
/*      */ 
/*      */ 
/*      */         
/* 9039 */         }) || Checks.reportMissing("GL", "GL_NV_bindless_multi_draw_indirect"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_bindless_multi_draw_indirect_count(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9043 */     if (!ext.contains("GL_NV_bindless_multi_draw_indirect_count")) {
/* 9044 */       return false;
/*      */     }
/*      */     
/* 9047 */     return (Checks.checkFunctions(provider, caps, new int[] { 1919, 1920 }, new String[] { "glMultiDrawArraysIndirectBindlessCountNV", "glMultiDrawElementsIndirectBindlessCountNV"
/*      */ 
/*      */ 
/*      */         
/* 9051 */         }) || Checks.reportMissing("GL", "GL_NV_bindless_multi_draw_indirect_count"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_bindless_texture(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9055 */     if (!ext.contains("GL_NV_bindless_texture")) {
/* 9056 */       return false;
/*      */     }
/*      */     
/* 9059 */     return (Checks.checkFunctions(provider, caps, new int[] { 1921, 1922, 1923, 1924, 1925, 1926, 1927, 1928, 1929, 1930, 1931, 1932, 1933 }, new String[] { "glGetTextureHandleNV", "glGetTextureSamplerHandleNV", "glMakeTextureHandleResidentNV", "glMakeTextureHandleNonResidentNV", "glGetImageHandleNV", "glMakeImageHandleResidentNV", "glMakeImageHandleNonResidentNV", "glUniformHandleui64NV", "glUniformHandleui64vNV", "glProgramUniformHandleui64NV", "glProgramUniformHandleui64vNV", "glIsTextureHandleResidentNV", "glIsImageHandleResidentNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9065 */         }) || Checks.reportMissing("GL", "GL_NV_bindless_texture"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_blend_equation_advanced(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9069 */     if (!ext.contains("GL_NV_blend_equation_advanced")) {
/* 9070 */       return false;
/*      */     }
/*      */     
/* 9073 */     return (Checks.checkFunctions(provider, caps, new int[] { 1934, 1935 }, new String[] { "glBlendParameteriNV", "glBlendBarrierNV"
/*      */ 
/*      */ 
/*      */         
/* 9077 */         }) || Checks.reportMissing("GL", "GL_NV_blend_equation_advanced"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_clip_space_w_scaling(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9081 */     if (!ext.contains("GL_NV_clip_space_w_scaling")) {
/* 9082 */       return false;
/*      */     }
/*      */     
/* 9085 */     return (Checks.checkFunctions(provider, caps, new int[] { 1936 }, new String[] { "glViewportPositionWScaleNV"
/*      */ 
/*      */ 
/*      */         
/* 9089 */         }) || Checks.reportMissing("GL", "GL_NV_clip_space_w_scaling"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_command_list(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9093 */     if (!ext.contains("GL_NV_command_list")) {
/* 9094 */       return false;
/*      */     }
/*      */     
/* 9097 */     return (Checks.checkFunctions(provider, caps, new int[] { 1937, 1938, 1939, 1940, 1941, 1942, 1943, 1944, 1945, 1946, 1947, 1948, 1949, 1950, 1951, 1952, 1953 }, new String[] { "glCreateStatesNV", "glDeleteStatesNV", "glIsStateNV", "glStateCaptureNV", "glGetCommandHeaderNV", "glGetStageIndexNV", "glDrawCommandsNV", "glDrawCommandsAddressNV", "glDrawCommandsStatesNV", "glDrawCommandsStatesAddressNV", "glCreateCommandListsNV", "glDeleteCommandListsNV", "glIsCommandListNV", "glListDrawCommandsStatesClientNV", "glCommandListSegmentsNV", "glCompileCommandListNV", "glCallCommandListNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9103 */         }) || Checks.reportMissing("GL", "GL_NV_command_list"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_conditional_render(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9107 */     if (!ext.contains("GL_NV_conditional_render")) {
/* 9108 */       return false;
/*      */     }
/*      */     
/* 9111 */     return (Checks.checkFunctions(provider, caps, new int[] { 1954, 1955 }, new String[] { "glBeginConditionalRenderNV", "glEndConditionalRenderNV"
/*      */ 
/*      */ 
/*      */         
/* 9115 */         }) || Checks.reportMissing("GL", "GL_NV_conditional_render"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_conservative_raster(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9119 */     if (!ext.contains("GL_NV_conservative_raster")) {
/* 9120 */       return false;
/*      */     }
/*      */     
/* 9123 */     return (Checks.checkFunctions(provider, caps, new int[] { 1956 }, new String[] { "glSubpixelPrecisionBiasNV"
/*      */ 
/*      */ 
/*      */         
/* 9127 */         }) || Checks.reportMissing("GL", "GL_NV_conservative_raster"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_conservative_raster_dilate(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9131 */     if (!ext.contains("GL_NV_conservative_raster_dilate")) {
/* 9132 */       return false;
/*      */     }
/*      */     
/* 9135 */     return (Checks.checkFunctions(provider, caps, new int[] { 1957 }, new String[] { "glConservativeRasterParameterfNV"
/*      */ 
/*      */ 
/*      */         
/* 9139 */         }) || Checks.reportMissing("GL", "GL_NV_conservative_raster_dilate"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_conservative_raster_pre_snap_triangles(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9143 */     if (!ext.contains("GL_NV_conservative_raster_pre_snap_triangles")) {
/* 9144 */       return false;
/*      */     }
/*      */     
/* 9147 */     return (Checks.checkFunctions(provider, caps, new int[] { 1958 }, new String[] { "glConservativeRasterParameteriNV"
/*      */ 
/*      */ 
/*      */         
/* 9151 */         }) || Checks.reportMissing("GL", "GL_NV_conservative_raster_pre_snap_triangles"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_copy_image(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9155 */     if (!ext.contains("GL_NV_copy_image")) {
/* 9156 */       return false;
/*      */     }
/*      */     
/* 9159 */     return (Checks.checkFunctions(provider, caps, new int[] { 1959 }, new String[] { "glCopyImageSubDataNV"
/*      */ 
/*      */ 
/*      */         
/* 9163 */         }) || Checks.reportMissing("GL", "GL_NV_copy_image"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_depth_buffer_float(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9167 */     if (!ext.contains("GL_NV_depth_buffer_float")) {
/* 9168 */       return false;
/*      */     }
/*      */     
/* 9171 */     return (Checks.checkFunctions(provider, caps, new int[] { 1960, 1961, 1962 }, new String[] { "glDepthRangedNV", "glClearDepthdNV", "glDepthBoundsdNV"
/*      */ 
/*      */ 
/*      */         
/* 9175 */         }) || Checks.reportMissing("GL", "GL_NV_depth_buffer_float"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_draw_texture(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9179 */     if (!ext.contains("GL_NV_draw_texture")) {
/* 9180 */       return false;
/*      */     }
/*      */     
/* 9183 */     return (Checks.checkFunctions(provider, caps, new int[] { 1963 }, new String[] { "glDrawTextureNV"
/*      */ 
/*      */ 
/*      */         
/* 9187 */         }) || Checks.reportMissing("GL", "GL_NV_draw_texture"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_draw_vulkan_image(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9191 */     if (!ext.contains("GL_NV_draw_vulkan_image")) {
/* 9192 */       return false;
/*      */     }
/*      */     
/* 9195 */     return (Checks.checkFunctions(provider, caps, new int[] { 1964, 1965, 1966, 1967, 1968 }, new String[] { "glDrawVkImageNV", "glGetVkProcAddrNV", "glWaitVkSemaphoreNV", "glSignalVkSemaphoreNV", "glSignalVkFenceNV"
/*      */ 
/*      */ 
/*      */         
/* 9199 */         }) || Checks.reportMissing("GL", "GL_NV_draw_vulkan_image"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_explicit_multisample(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9203 */     if (!ext.contains("GL_NV_explicit_multisample")) {
/* 9204 */       return false;
/*      */     }
/*      */     
/* 9207 */     return (Checks.checkFunctions(provider, caps, new int[] { 1969, 1970, 1971 }, new String[] { "glGetMultisamplefvNV", "glSampleMaskIndexedNV", "glTexRenderbufferNV"
/*      */ 
/*      */ 
/*      */         
/* 9211 */         }) || Checks.reportMissing("GL", "GL_NV_explicit_multisample"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_fence(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9215 */     if (!ext.contains("GL_NV_fence")) {
/* 9216 */       return false;
/*      */     }
/*      */     
/* 9219 */     return (Checks.checkFunctions(provider, caps, new int[] { 1972, 1973, 1974, 1975, 1976, 1977, 1978 }, new String[] { "glDeleteFencesNV", "glGenFencesNV", "glIsFenceNV", "glTestFenceNV", "glGetFenceivNV", "glFinishFenceNV", "glSetFenceNV"
/*      */ 
/*      */ 
/*      */         
/* 9223 */         }) || Checks.reportMissing("GL", "GL_NV_fence"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_fragment_coverage_to_color(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9227 */     if (!ext.contains("GL_NV_fragment_coverage_to_color")) {
/* 9228 */       return false;
/*      */     }
/*      */     
/* 9231 */     return (Checks.checkFunctions(provider, caps, new int[] { 1979 }, new String[] { "glFragmentCoverageColorNV"
/*      */ 
/*      */ 
/*      */         
/* 9235 */         }) || Checks.reportMissing("GL", "GL_NV_fragment_coverage_to_color"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_framebuffer_mixed_samples(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9239 */     if (!ext.contains("GL_NV_framebuffer_mixed_samples")) {
/* 9240 */       return false;
/*      */     }
/*      */     
/* 9243 */     return (Checks.checkFunctions(provider, caps, new int[] { 1827, 1980, 1981, 1982 }, new String[] { "glRasterSamplesEXT", "glCoverageModulationTableNV", "glGetCoverageModulationTableNV", "glCoverageModulationNV"
/*      */ 
/*      */ 
/*      */         
/* 9247 */         }) || Checks.reportMissing("GL", "GL_NV_framebuffer_mixed_samples"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_framebuffer_multisample_coverage(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9251 */     if (!ext.contains("GL_NV_framebuffer_multisample_coverage")) {
/* 9252 */       return false;
/*      */     }
/*      */     
/* 9255 */     return (Checks.checkFunctions(provider, caps, new int[] { 1983 }, new String[] { "glRenderbufferStorageMultisampleCoverageNV"
/*      */ 
/*      */ 
/*      */         
/* 9259 */         }) || Checks.reportMissing("GL", "GL_NV_framebuffer_multisample_coverage"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_gpu_multicast(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9263 */     if (!ext.contains("GL_NV_gpu_multicast")) {
/* 9264 */       return false;
/*      */     }
/*      */     
/* 9267 */     return (Checks.checkFunctions(provider, caps, new int[] { 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995 }, new String[] { "glRenderGpuMaskNV", "glMulticastBufferSubDataNV", "glMulticastCopyBufferSubDataNV", "glMulticastCopyImageSubDataNV", "glMulticastBlitFramebufferNV", "glMulticastFramebufferSampleLocationsfvNV", "glMulticastBarrierNV", "glMulticastWaitSyncNV", "glMulticastGetQueryObjectivNV", "glMulticastGetQueryObjectuivNV", "glMulticastGetQueryObjecti64vNV", "glMulticastGetQueryObjectui64vNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9273 */         }) || Checks.reportMissing("GL", "GL_NV_gpu_multicast"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_gpu_shader5(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9277 */     if (!ext.contains("GL_NV_gpu_shader5")) {
/* 9278 */       return false;
/*      */     }
/*      */     
/* 9281 */     int flag0 = ext.contains("GL_EXT_direct_state_access") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 9283 */       Checks.checkFunctions(provider, caps, new int[] { 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, flag0 + 1076, flag0 + 1077, flag0 + 1078, flag0 + 1079, flag0 + 1080, flag0 + 1081, flag0 + 1082, flag0 + 1083, flag0 + 1084, flag0 + 1085, flag0 + 1086, flag0 + 1087, flag0 + 1088, flag0 + 1089, flag0 + 1090, flag0 + 1091 }, new String[] { "glUniform1i64NV", "glUniform2i64NV", "glUniform3i64NV", "glUniform4i64NV", "glUniform1i64vNV", "glUniform2i64vNV", "glUniform3i64vNV", "glUniform4i64vNV", "glUniform1ui64NV", "glUniform2ui64NV", "glUniform3ui64NV", "glUniform4ui64NV", "glUniform1ui64vNV", "glUniform2ui64vNV", "glUniform3ui64vNV", "glUniform4ui64vNV", "glGetUniformi64vNV", "glGetUniformui64vNV", "glProgramUniform1i64NV", "glProgramUniform2i64NV", "glProgramUniform3i64NV", "glProgramUniform4i64NV", "glProgramUniform1i64vNV", "glProgramUniform2i64vNV", "glProgramUniform3i64vNV", "glProgramUniform4i64vNV", "glProgramUniform1ui64NV", "glProgramUniform2ui64NV", "glProgramUniform3ui64NV", "glProgramUniform4ui64NV", "glProgramUniform1ui64vNV", "glProgramUniform2ui64vNV", "glProgramUniform3ui64vNV", "glProgramUniform4ui64vNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9294 */         }) || Checks.reportMissing("GL", "GL_NV_gpu_shader5"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_half_float(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9298 */     if (!ext.contains("GL_NV_half_float")) {
/* 9299 */       return false;
/*      */     }
/*      */     
/* 9302 */     int flag0 = ext.contains("GL_EXT_fog_coord") ? 0 : Integer.MIN_VALUE;
/* 9303 */     int flag2 = ext.contains("GL_EXT_secondary_color") ? 0 : Integer.MIN_VALUE;
/* 9304 */     int flag4 = ext.contains("GL_EXT_vertex_weighting") ? 0 : Integer.MIN_VALUE;
/* 9305 */     int flag6 = ext.contains("GL_NV_vertex_program") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 9307 */       Checks.checkFunctions(provider, caps, new int[] { 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, flag0 + 2024, flag0 + 2025, flag2 + 2026, flag2 + 2027, flag4 + 2028, flag4 + 2029, flag6 + 2030, flag6 + 2031, flag6 + 2032, flag6 + 2033, flag6 + 2034, flag6 + 2035, flag6 + 2036, flag6 + 2037, flag6 + 2038, flag6 + 2039, flag6 + 2040, flag6 + 2041 }, new String[] { "glVertex2hNV", "glVertex2hvNV", "glVertex3hNV", "glVertex3hvNV", "glVertex4hNV", "glVertex4hvNV", "glNormal3hNV", "glNormal3hvNV", "glColor3hNV", "glColor3hvNV", "glColor4hNV", "glColor4hvNV", "glTexCoord1hNV", "glTexCoord1hvNV", "glTexCoord2hNV", "glTexCoord2hvNV", "glTexCoord3hNV", "glTexCoord3hvNV", "glTexCoord4hNV", "glTexCoord4hvNV", "glMultiTexCoord1hNV", "glMultiTexCoord1hvNV", "glMultiTexCoord2hNV", "glMultiTexCoord2hvNV", "glMultiTexCoord3hNV", "glMultiTexCoord3hvNV", "glMultiTexCoord4hNV", "glMultiTexCoord4hvNV", "glFogCoordhNV", "glFogCoordhvNV", "glSecondaryColor3hNV", "glSecondaryColor3hvNV", "glVertexWeighthNV", "glVertexWeighthvNV", "glVertexAttrib1hNV", "glVertexAttrib1hvNV", "glVertexAttrib2hNV", "glVertexAttrib2hvNV", "glVertexAttrib3hNV", "glVertexAttrib3hvNV", "glVertexAttrib4hNV", "glVertexAttrib4hvNV", "glVertexAttribs1hvNV", "glVertexAttribs2hvNV", "glVertexAttribs3hvNV", "glVertexAttribs4hvNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9319 */         }) || Checks.reportMissing("GL", "GL_NV_half_float"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_internalformat_sample_query(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9323 */     if (!ext.contains("GL_NV_internalformat_sample_query")) {
/* 9324 */       return false;
/*      */     }
/*      */     
/* 9327 */     return (Checks.checkFunctions(provider, caps, new int[] { 2042 }, new String[] { "glGetInternalformatSampleivNV"
/*      */ 
/*      */ 
/*      */         
/* 9331 */         }) || Checks.reportMissing("GL", "GL_NV_internalformat_sample_query"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_memory_attachment(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9335 */     if (!ext.contains("GL_NV_memory_attachment")) {
/* 9336 */       return false;
/*      */     }
/*      */     
/* 9339 */     int flag0 = hasDSA(ext) ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 9341 */       Checks.checkFunctions(provider, caps, new int[] { 2043, 2044, 2045, 2046, flag0 + 2047, flag0 + 2048 }, new String[] { "glGetMemoryObjectDetachedResourcesuivNV", "glResetMemoryObjectParameterNV", "glTexAttachMemoryNV", "glBufferAttachMemoryNV", "glTextureAttachMemoryNV", "glNamedBufferAttachMemoryNV"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9346 */         }) || Checks.reportMissing("GL", "GL_NV_memory_attachment"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_memory_object_sparse(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9350 */     if (!ext.contains("GL_NV_memory_object_sparse")) {
/* 9351 */       return false;
/*      */     }
/*      */     
/* 9354 */     return (Checks.checkFunctions(provider, caps, new int[] { 2049, 2050, 2051, 2052 }, new String[] { "glBufferPageCommitmentMemNV", "glNamedBufferPageCommitmentMemNV", "glTexPageCommitmentMemNV", "glTexturePageCommitmentMemNV"
/*      */ 
/*      */ 
/*      */         
/* 9358 */         }) || Checks.reportMissing("GL", "GL_NV_memory_object_sparse"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_mesh_shader(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9362 */     if (!ext.contains("GL_NV_mesh_shader")) {
/* 9363 */       return false;
/*      */     }
/*      */     
/* 9366 */     return (Checks.checkFunctions(provider, caps, new int[] { 2053, 2054, 2055, 2056 }, new String[] { "glDrawMeshTasksNV", "glDrawMeshTasksIndirectNV", "glMultiDrawMeshTasksIndirectNV", "glMultiDrawMeshTasksIndirectCountNV"
/*      */ 
/*      */ 
/*      */         
/* 9370 */         }) || Checks.reportMissing("GL", "GL_NV_mesh_shader"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_path_rendering(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9374 */     if (!ext.contains("GL_NV_path_rendering")) {
/* 9375 */       return false;
/*      */     }
/*      */     
/* 9378 */     return (Checks.checkFunctions(provider, caps, new int[] { 2057, 2058, 2059, 2060, 2061, 2062, 2063, 2066, 2068, 2069, 2070, 2071, 2072, 2073, 2074, 2075, 2076, 2077, 2078, 2079, 2080, 2081, 2082, 2083, 2084, 2088, 2089, 2090, 2091, 2098, 2099, 2100, 2101, 2102, 2103, 2104, 2105, 2110, 2111, 2112, 2113 }, new String[] { "glPathCommandsNV", "glPathCoordsNV", "glPathSubCommandsNV", "glPathSubCoordsNV", "glPathStringNV", "glPathGlyphsNV", "glPathGlyphRangeNV", "glCopyPathNV", "glInterpolatePathsNV", "glTransformPathNV", "glPathParameterivNV", "glPathParameteriNV", "glPathParameterfvNV", "glPathParameterfNV", "glPathDashArrayNV", "glGenPathsNV", "glDeletePathsNV", "glIsPathNV", "glPathStencilFuncNV", "glPathStencilDepthOffsetNV", "glStencilFillPathNV", "glStencilStrokePathNV", "glStencilFillPathInstancedNV", "glStencilStrokePathInstancedNV", "glPathCoverDepthFuncNV", "glCoverFillPathNV", "glCoverStrokePathNV", "glCoverFillPathInstancedNV", "glCoverStrokePathInstancedNV", "glGetPathParameterivNV", "glGetPathParameterfvNV", "glGetPathCommandsNV", "glGetPathCoordsNV", "glGetPathDashArrayNV", "glGetPathMetricsNV", "glGetPathMetricRangeNV", "glGetPathSpacingNV", "glIsPointInFillPathNV", "glIsPointInStrokePathNV", "glGetPathLengthNV", "glPointAlongPathNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9389 */         }) || Checks.reportMissing("GL", "GL_NV_path_rendering"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_pixel_data_range(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9393 */     if (!ext.contains("GL_NV_pixel_data_range")) {
/* 9394 */       return false;
/*      */     }
/*      */     
/* 9397 */     return (Checks.checkFunctions(provider, caps, new int[] { 2121, 2122 }, new String[] { "glPixelDataRangeNV", "glFlushPixelDataRangeNV"
/*      */ 
/*      */ 
/*      */         
/* 9401 */         }) || Checks.reportMissing("GL", "GL_NV_pixel_data_range"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_point_sprite(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9405 */     if (!ext.contains("GL_NV_point_sprite")) {
/* 9406 */       return false;
/*      */     }
/*      */     
/* 9409 */     return (Checks.checkFunctions(provider, caps, new int[] { 2123, 2124 }, new String[] { "glPointParameteriNV", "glPointParameterivNV"
/*      */ 
/*      */ 
/*      */         
/* 9413 */         }) || Checks.reportMissing("GL", "GL_NV_point_sprite"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_primitive_restart(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9417 */     if (!ext.contains("GL_NV_primitive_restart")) {
/* 9418 */       return false;
/*      */     }
/*      */     
/* 9421 */     return (Checks.checkFunctions(provider, caps, new int[] { 2125, 2126 }, new String[] { "glPrimitiveRestartNV", "glPrimitiveRestartIndexNV"
/*      */ 
/*      */ 
/*      */         
/* 9425 */         }) || Checks.reportMissing("GL", "GL_NV_primitive_restart"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_query_resource(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9429 */     if (!ext.contains("GL_NV_query_resource")) {
/* 9430 */       return false;
/*      */     }
/*      */     
/* 9433 */     return (Checks.checkFunctions(provider, caps, new int[] { 2127 }, new String[] { "glQueryResourceNV"
/*      */ 
/*      */ 
/*      */         
/* 9437 */         }) || Checks.reportMissing("GL", "GL_NV_query_resource"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_query_resource_tag(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9441 */     if (!ext.contains("GL_NV_query_resource_tag")) {
/* 9442 */       return false;
/*      */     }
/*      */     
/* 9445 */     return (Checks.checkFunctions(provider, caps, new int[] { 2128, 2129, 2130 }, new String[] { "glGenQueryResourceTagNV", "glDeleteQueryResourceTagNV", "glQueryResourceTagNV"
/*      */ 
/*      */ 
/*      */         
/* 9449 */         }) || Checks.reportMissing("GL", "GL_NV_query_resource_tag"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_sample_locations(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9453 */     if (!ext.contains("GL_NV_sample_locations")) {
/* 9454 */       return false;
/*      */     }
/*      */     
/* 9457 */     return (Checks.checkFunctions(provider, caps, new int[] { 2131, 2132, 2133 }, new String[] { "glFramebufferSampleLocationsfvNV", "glNamedFramebufferSampleLocationsfvNV", "glResolveDepthValuesNV"
/*      */ 
/*      */ 
/*      */         
/* 9461 */         }) || Checks.reportMissing("GL", "GL_NV_sample_locations"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_scissor_exclusive(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9465 */     if (!ext.contains("GL_NV_scissor_exclusive")) {
/* 9466 */       return false;
/*      */     }
/*      */     
/* 9469 */     return (Checks.checkFunctions(provider, caps, new int[] { 2134, 2135 }, new String[] { "glScissorExclusiveArrayvNV", "glScissorExclusiveNV"
/*      */ 
/*      */ 
/*      */         
/* 9473 */         }) || Checks.reportMissing("GL", "GL_NV_scissor_exclusive"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_shader_buffer_load(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9477 */     if (!ext.contains("GL_NV_shader_buffer_load")) {
/* 9478 */       return false;
/*      */     }
/*      */     
/* 9481 */     return (Checks.checkFunctions(provider, caps, new int[] { 2136, 2137, 2138, 2139, 2140, 2141, 2142, 2143, 2144, 2145, 2146, 1075, 2147, 2148 }, new String[] { "glMakeBufferResidentNV", "glMakeBufferNonResidentNV", "glIsBufferResidentNV", "glMakeNamedBufferResidentNV", "glMakeNamedBufferNonResidentNV", "glIsNamedBufferResidentNV", "glGetBufferParameterui64vNV", "glGetNamedBufferParameterui64vNV", "glGetIntegerui64vNV", "glUniformui64NV", "glUniformui64vNV", "glGetUniformui64vNV", "glProgramUniformui64NV", "glProgramUniformui64vNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9487 */         }) || Checks.reportMissing("GL", "GL_NV_shader_buffer_load"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_shading_rate_image(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9491 */     if (!ext.contains("GL_NV_shading_rate_image")) {
/* 9492 */       return false;
/*      */     }
/*      */     
/* 9495 */     return (Checks.checkFunctions(provider, caps, new int[] { 2149, 2150, 2151, 2152, 2153, 2154, 2155 }, new String[] { "glBindShadingRateImageNV", "glShadingRateImagePaletteNV", "glGetShadingRateImagePaletteNV", "glShadingRateImageBarrierNV", "glShadingRateSampleOrderNV", "glShadingRateSampleOrderCustomNV", "glGetShadingRateSampleLocationivNV"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9500 */         }) || Checks.reportMissing("GL", "GL_NV_shading_rate_image"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_texture_barrier(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9504 */     if (!ext.contains("GL_NV_texture_barrier")) {
/* 9505 */       return false;
/*      */     }
/*      */     
/* 9508 */     return (Checks.checkFunctions(provider, caps, new int[] { 2156 }, new String[] { "glTextureBarrierNV"
/*      */ 
/*      */ 
/*      */         
/* 9512 */         }) || Checks.reportMissing("GL", "GL_NV_texture_barrier"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_texture_multisample(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9516 */     if (!ext.contains("GL_NV_texture_multisample")) {
/* 9517 */       return false;
/*      */     }
/*      */     
/* 9520 */     return (Checks.checkFunctions(provider, caps, new int[] { 2157, 2158, 2159, 2160, 2161, 2162 }, new String[] { "glTexImage2DMultisampleCoverageNV", "glTexImage3DMultisampleCoverageNV", "glTextureImage2DMultisampleNV", "glTextureImage3DMultisampleNV", "glTextureImage2DMultisampleCoverageNV", "glTextureImage3DMultisampleCoverageNV"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9525 */         }) || Checks.reportMissing("GL", "GL_NV_texture_multisample"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_timeline_semaphore(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9529 */     if (!ext.contains("GL_NV_timeline_semaphore")) {
/* 9530 */       return false;
/*      */     }
/*      */     
/* 9533 */     return (Checks.checkFunctions(provider, caps, new int[] { 2163, 2164, 2165 }, new String[] { "glCreateSemaphoresNV", "glSemaphoreParameterivNV", "glGetSemaphoreParameterivNV"
/*      */ 
/*      */ 
/*      */         
/* 9537 */         }) || Checks.reportMissing("GL", "GL_NV_timeline_semaphore"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_transform_feedback(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9541 */     if (!ext.contains("GL_NV_transform_feedback")) {
/* 9542 */       return false;
/*      */     }
/*      */     
/* 9545 */     return (Checks.checkFunctions(provider, caps, new int[] { 2166, 2167, 2168, 2169, 2170, 2171, 2172, 2173, 2174, 2175, 2176, 2177 }, new String[] { "glBeginTransformFeedbackNV", "glEndTransformFeedbackNV", "glTransformFeedbackAttribsNV", "glBindBufferRangeNV", "glBindBufferOffsetNV", "glBindBufferBaseNV", "glTransformFeedbackVaryingsNV", "glActiveVaryingNV", "glGetVaryingLocationNV", "glGetActiveVaryingNV", "glGetTransformFeedbackVaryingNV", "glTransformFeedbackStreamAttribsNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9551 */         }) || Checks.reportMissing("GL", "GL_NV_transform_feedback"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_transform_feedback2(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9555 */     if (!ext.contains("GL_NV_transform_feedback2")) {
/* 9556 */       return false;
/*      */     }
/*      */     
/* 9559 */     return (Checks.checkFunctions(provider, caps, new int[] { 2178, 2179, 2180, 2181, 2182, 2183, 2184 }, new String[] { "glBindTransformFeedbackNV", "glDeleteTransformFeedbacksNV", "glGenTransformFeedbacksNV", "glIsTransformFeedbackNV", "glPauseTransformFeedbackNV", "glResumeTransformFeedbackNV", "glDrawTransformFeedbackNV"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9564 */         }) || Checks.reportMissing("GL", "GL_NV_transform_feedback2"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_vertex_array_range(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9568 */     if (!ext.contains("GL_NV_vertex_array_range")) {
/* 9569 */       return false;
/*      */     }
/*      */     
/* 9572 */     return (Checks.checkFunctions(provider, caps, new int[] { 2185, 2186 }, new String[] { "glVertexArrayRangeNV", "glFlushVertexArrayRangeNV"
/*      */ 
/*      */ 
/*      */         
/* 9576 */         }) || Checks.reportMissing("GL", "GL_NV_vertex_array_range"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_vertex_attrib_integer_64bit(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9580 */     if (!ext.contains("GL_NV_vertex_attrib_integer_64bit")) {
/* 9581 */       return false;
/*      */     }
/*      */     
/* 9584 */     int flag0 = ext.contains("GL_NV_vertex_buffer_unified_memory") ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 9586 */       Checks.checkFunctions(provider, caps, new int[] { 2187, 2188, 2189, 2190, 2191, 2192, 2193, 2194, 2195, 2196, 2197, 2198, 2199, 2200, 2201, 2202, 2203, 2204, flag0 + 2205 }, new String[] { "glVertexAttribL1i64NV", "glVertexAttribL2i64NV", "glVertexAttribL3i64NV", "glVertexAttribL4i64NV", "glVertexAttribL1i64vNV", "glVertexAttribL2i64vNV", "glVertexAttribL3i64vNV", "glVertexAttribL4i64vNV", "glVertexAttribL1ui64NV", "glVertexAttribL2ui64NV", "glVertexAttribL3ui64NV", "glVertexAttribL4ui64NV", "glVertexAttribL1ui64vNV", "glVertexAttribL2ui64vNV", "glVertexAttribL3ui64vNV", "glVertexAttribL4ui64vNV", "glGetVertexAttribLi64vNV", "glGetVertexAttribLui64vNV", "glVertexAttribLFormatNV"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9593 */         }) || Checks.reportMissing("GL", "GL_NV_vertex_attrib_integer_64bit"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_vertex_buffer_unified_memory(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9597 */     if (!ext.contains("GL_NV_vertex_buffer_unified_memory")) {
/* 9598 */       return false;
/*      */     }
/*      */     
/* 9601 */     return (Checks.checkFunctions(provider, caps, new int[] { 2206, 2207, 2208, 2209, 2210, 2211, 2212, 2213, 2214, 2215, 2216, 2217 }, new String[] { "glBufferAddressRangeNV", "glVertexFormatNV", "glNormalFormatNV", "glColorFormatNV", "glIndexFormatNV", "glTexCoordFormatNV", "glEdgeFlagFormatNV", "glSecondaryColorFormatNV", "glFogCoordFormatNV", "glVertexAttribFormatNV", "glVertexAttribIFormatNV", "glGetIntegerui64i_vNV"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9606 */         }) || Checks.reportMissing("GL", "GL_NV_vertex_buffer_unified_memory"));
/*      */   }
/*      */   
/*      */   private static boolean check_NV_viewport_swizzle(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9610 */     if (!ext.contains("GL_NV_viewport_swizzle")) {
/* 9611 */       return false;
/*      */     }
/*      */     
/* 9614 */     return (Checks.checkFunctions(provider, caps, new int[] { 2218 }, new String[] { "glViewportSwizzleNV"
/*      */ 
/*      */ 
/*      */         
/* 9618 */         }) || Checks.reportMissing("GL", "GL_NV_viewport_swizzle"));
/*      */   }
/*      */   
/*      */   private static boolean check_NVX_conditional_render(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9622 */     if (!ext.contains("GL_NVX_conditional_render")) {
/* 9623 */       return false;
/*      */     }
/*      */     
/* 9626 */     return (Checks.checkFunctions(provider, caps, new int[] { 2219, 2220 }, new String[] { "glBeginConditionalRenderNVX", "glEndConditionalRenderNVX"
/*      */ 
/*      */ 
/*      */         
/* 9630 */         }) || Checks.reportMissing("GL", "GL_NVX_conditional_render"));
/*      */   }
/*      */   
/*      */   private static boolean check_NVX_gpu_multicast2(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9634 */     if (!ext.contains("GL_NVX_gpu_multicast2")) {
/* 9635 */       return false;
/*      */     }
/*      */     
/* 9638 */     return (Checks.checkFunctions(provider, caps, new int[] { 2221, 2222, 2223, 2224, 2225, 2226 }, new String[] { "glAsyncCopyImageSubDataNVX", "glAsyncCopyBufferSubDataNVX", "glUploadGpuMaskNVX", "glMulticastViewportArrayvNVX", "glMulticastScissorArrayvNVX", "glMulticastViewportPositionWScaleNVX"
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 9643 */         }) || Checks.reportMissing("GL", "GL_NVX_gpu_multicast2"));
/*      */   }
/*      */   
/*      */   private static boolean check_NVX_progress_fence(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9647 */     if (!ext.contains("GL_NVX_progress_fence")) {
/* 9648 */       return false;
/*      */     }
/*      */     
/* 9651 */     return (Checks.checkFunctions(provider, caps, new int[] { 2227, 2228, 2229, 2230 }, new String[] { "glCreateProgressFenceNVX", "glSignalSemaphoreui64NVX", "glWaitSemaphoreui64NVX", "glClientWaitSemaphoreui64NVX"
/*      */ 
/*      */ 
/*      */         
/* 9655 */         }) || Checks.reportMissing("GL", "GL_NVX_progress_fence"));
/*      */   }
/*      */   
/*      */   private static boolean check_OVR_multiview(FunctionProvider provider, PointerBuffer caps, Set<String> ext) {
/* 9659 */     if (!ext.contains("GL_OVR_multiview")) {
/* 9660 */       return false;
/*      */     }
/*      */     
/* 9663 */     int flag0 = hasDSA(ext) ? 0 : Integer.MIN_VALUE; return (
/*      */       
/* 9665 */       Checks.checkFunctions(provider, caps, new int[] { 2231, flag0 + 2232 }, new String[] { "glFramebufferTextureMultiviewOVR", "glNamedFramebufferTextureMultiviewOVR"
/*      */ 
/*      */ 
/*      */         
/* 9669 */         }) || Checks.reportMissing("GL", "GL_OVR_multiview"));
/*      */   }
/*      */   
/*      */   private static boolean hasDSA(Set<String> ext) {
/* 9673 */     return (ext.contains("GL45") || ext.contains("GL_ARB_direct_state_access") || ext.contains("GL_EXT_direct_state_access"));
/*      */   }
/*      */   
/* 9676 */   private static boolean ARB_framebuffer_object(Set<String> ext) { return (ext.contains("OpenGL30") || ext.contains("GL_ARB_framebuffer_object")); }
/* 9677 */   private static boolean ARB_map_buffer_range(Set<String> ext) { return (ext.contains("OpenGL30") || ext.contains("GL_ARB_map_buffer_range")); }
/* 9678 */   private static boolean ARB_vertex_array_object(Set<String> ext) { return (ext.contains("OpenGL30") || ext.contains("GL_ARB_vertex_array_object")); }
/* 9679 */   private static boolean ARB_copy_buffer(Set<String> ext) { return (ext.contains("OpenGL31") || ext.contains("GL_ARB_copy_buffer")); }
/* 9680 */   private static boolean ARB_texture_buffer_object(Set<String> ext) { return (ext.contains("OpenGL31") || ext.contains("GL_ARB_texture_buffer_object")); }
/* 9681 */   private static boolean ARB_uniform_buffer_object(Set<String> ext) { return (ext.contains("OpenGL31") || ext.contains("GL_ARB_uniform_buffer_object")); }
/* 9682 */   private static boolean ARB_instanced_arrays(Set<String> ext) { return (ext.contains("OpenGL33") || ext.contains("GL_ARB_instanced_arrays")); }
/* 9683 */   private static boolean ARB_sampler_objects(Set<String> ext) { return (ext.contains("OpenGL33") || ext.contains("GL_ARB_sampler_objects")); }
/* 9684 */   private static boolean ARB_transform_feedback2(Set<String> ext) { return (ext.contains("OpenGL40") || ext.contains("GL_ARB_transform_feedback2")); }
/* 9685 */   private static boolean ARB_vertex_attrib_64bit(Set<String> ext) { return (ext.contains("OpenGL41") || ext.contains("GL_ARB_vertex_attrib_64bit")); }
/* 9686 */   private static boolean ARB_separate_shader_objects(Set<String> ext) { return (ext.contains("OpenGL41") || ext.contains("GL_ARB_separate_shader_objects")); }
/* 9687 */   private static boolean ARB_texture_storage(Set<String> ext) { return (ext.contains("OpenGL42") || ext.contains("GL_ARB_texture_storage")); }
/* 9688 */   private static boolean ARB_texture_storage_multisample(Set<String> ext) { return (ext.contains("OpenGL43") || ext.contains("GL_ARB_texture_storage_multisample")); }
/* 9689 */   private static boolean ARB_vertex_attrib_binding(Set<String> ext) { return (ext.contains("OpenGL43") || ext.contains("GL_ARB_vertex_attrib_binding")); }
/* 9690 */   private static boolean ARB_invalidate_subdata(Set<String> ext) { return (ext.contains("OpenGL43") || ext.contains("GL_ARB_invalidate_subdata")); }
/* 9691 */   private static boolean ARB_texture_buffer_range(Set<String> ext) { return (ext.contains("OpenGL43") || ext.contains("GL_ARB_texture_buffer_range")); }
/* 9692 */   private static boolean ARB_clear_buffer_object(Set<String> ext) { return (ext.contains("OpenGL43") || ext.contains("GL_ARB_clear_buffer_object")); }
/* 9693 */   private static boolean ARB_framebuffer_no_attachments(Set<String> ext) { return (ext.contains("OpenGL43") || ext.contains("GL_ARB_framebuffer_no_attachments")); }
/* 9694 */   private static boolean ARB_buffer_storage(Set<String> ext) { return (ext.contains("OpenGL44") || ext.contains("GL_ARB_buffer_storage")); }
/* 9695 */   private static boolean ARB_clear_texture(Set<String> ext) { return (ext.contains("OpenGL44") || ext.contains("GL_ARB_clear_texture")); }
/* 9696 */   private static boolean ARB_multi_bind(Set<String> ext) { return (ext.contains("OpenGL44") || ext.contains("GL_ARB_multi_bind")); } private static boolean ARB_query_buffer_object(Set<String> ext) {
/* 9697 */     return (ext.contains("OpenGL44") || ext.contains("GL_ARB_query_buffer_object"));
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */